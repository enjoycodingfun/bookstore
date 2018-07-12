package com.ssm.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.pojo.Cart;
import com.ssm.pojo.CartItem;
import com.ssm.pojo.Category;
import com.ssm.pojo.Product;
import com.ssm.pojo.User;
import com.ssm.service.CategoryService;
import com.ssm.service.ProductService;
import com.ssm.service.UserService;
import com.ssm.utils.CommonsUtils;
import com.ssm.utils.MD5Utils;
import com.ssm.utils.SendJMail;

@RequestMapping("/product")
@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/showProductByPage")//分页显示商品
	public String showProductByPage(@RequestParam(defaultValue="1")Integer currentPage,@RequestParam(defaultValue="5")Integer pageSize,Model model,String cid,HttpServletRequest request){
		Page<Object> page = PageHelper.startPage(currentPage, pageSize);
		List<Product> list = productService.findAll(cid);
		PageInfo<Product> pageInfo = new PageInfo<>(list, 3);
		
		String uri = request.getRequestURI();
		String url = uri+"?cid="+cid+"&";
		model.addAttribute("uri", url);
		model.addAttribute("page",pageInfo);
		model.addAttribute("list",list);
		model.addAttribute("navigatepageNums",pageInfo.getNavigatepageNums());
		return "/user/product_list";
	}
	@RequestMapping("/toProductInfo")//显示商品详细信息
	public String showProductInfo(String pid,Model model){
		Product p = productService.findById(pid);//根据pid查找商品详细信息
		//根据pid去得到cid  再去查找Caterory  
		//根据pid得到cid,回显在商品信息页面
		Category c = categoryService.findById(p.getCid());
		p.setCategory(c);
		//存入域对象中
		model.addAttribute("p", p);
		//转发到商品详情页面
		return "/user/product_info";
	}
	@RequestMapping("/findProduct")//根据搜索条件显示分页显示商品
	public String findProductBySearch(@RequestParam(defaultValue="1")Integer currentPage,@RequestParam(defaultValue="5")Integer pageSize,Model model,String name,HttpServletRequest request){
		
		Page<Object> page = PageHelper.startPage(currentPage, pageSize);
		List<Product> list = productService.findProductBySearch(name);
		PageInfo<Product> pageInfo = new PageInfo<>(list, 3);
		
		String uri = request.getRequestURI();
		String url = uri+"?name="+name+"&";
		model.addAttribute("uri", url);
		model.addAttribute("name",name);//回显搜索条件
		model.addAttribute("page",pageInfo);
		model.addAttribute("list",list);
		model.addAttribute("navigatepageNums",pageInfo.getNavigatepageNums());
		return "/user/product_list";
	}
	@RequestMapping("/addProductToCart")//添加商品到购物车
	public String addProductToCart(String pid,Integer buyNum,HttpServletRequest request){
		//根据pid去查找商品对象
		Product p = productService.findById(pid);
		//从Session里面取出购物车
		HttpSession session = request.getSession();
		//购物车  有可能等于null
		Cart cart = (Cart) session.getAttribute("cart");
		//为空则新创建一个
		if(cart==null){
			cart=new Cart();
		}
		//把购物项放到购物车里
		Map<String, CartItem> map = cart.getItems();//获得购物项容器
		//创建购物对象
		CartItem item=new CartItem();//准备空的购物项
		//根据是否是第一次购买来确定
		if(map.containsKey(pid)){
			//从购物车里取出key值是pid的购物项
			item = map.get(pid);//购物项
			//数量+buyNym
			item.setBuyNum(item.getBuyNum()+buyNum);
			item.setSubTotal(item.getSubTotal()+p.getShopPrice()*buyNum);
			//map.put(pid,item);
		}else{
			item.setBuyNum(buyNum);//购买数量
			item.setProduct(p);//商品
			item.setSubTotal(buyNum*p.getShopPrice());//小计
			/**
			 * 第一个购买该商品
			 */
			
			//cart.setItems(map);
		}
		
		map.put(pid,item);
		/**
		 * 总计
		 */
		cart.setTotal(cart.getTotal()+buyNum*p.getShopPrice());//变多~~~
		/**
		 * 把购物车放到session里
		 */
		session.setAttribute("cart", cart);
		//重定向到cart.jsp
		return "redirect:/view/user/cart";
	
	}
	@RequestMapping("/deleteProductFromCart")
	public String deleteProductFromCart(String pid,HttpSession session,Model model) {
		//先从session取出购物车
		Cart cart = (Cart) session.getAttribute("cart");
		if(cart!=null){
			Map<String, CartItem> map = cart.getItems();
			if(map.containsKey(pid)){
				CartItem item = map.get(pid);
				map.remove(pid);
				double tatal = cart.getTotal()-item.getSubTotal();
				if(tatal>0){
					cart.setTotal(cart.getTotal()-item.getSubTotal());
				}else{
					cart.setTotal(0);
				}
			}
		}
		session.setAttribute("cart", cart);
		return "redirect:/view/user/cart";
	}
	@RequestMapping("/showaddpage")//查询所有分类回显在添加下拉框
	public String showaddpage(Model model){
		List<Category> list =  categoryService.findAll();
		model.addAttribute("list",list);
		return "/admin/products/add";
	}
	
	
	
	
	
	
	
	
}
