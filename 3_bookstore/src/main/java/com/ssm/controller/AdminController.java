package com.ssm.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.pojo.Category;
import com.ssm.pojo.Orders;
import com.ssm.pojo.Product;
import com.ssm.service.CategoryService;
import com.ssm.service.OrderService;
import com.ssm.service.ProductService;
import com.ssm.utils.CommonsUtils;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/showAllProducts")//分页显示商品
	public String showAllProducts(@RequestParam(value="currentpage",defaultValue="1")Integer currentpage,@RequestParam(defaultValue="5")Integer pageSize,Model model,String cid,HttpServletRequest request){
		Page<Object> page = PageHelper.startPage(currentpage, pageSize);
		List<Product> list = productService.findAll();
		
		PageInfo<Product> pageInfo = new PageInfo<>(list, 3);
		List<Category> categorys =  categoryService.findAll();
		String uri = request.getRequestURI();
		String url = uri+"?";
		
		model.addAttribute("categorys",categorys);
		model.addAttribute("uri", url);
		model.addAttribute("page",pageInfo);
		model.addAttribute("list",list);
		model.addAttribute("navigatepageNums",pageInfo.getNavigatepageNums());
		return "forward:/WEB-INF/jsp/admin/products/list.jsp";
		
	}
	@RequestMapping("/adminAddProduct")//供应商添加商品
	public String adminAddProduct(Product p,@RequestParam("file") MultipartFile file,HttpServletRequest request) throws IllegalStateException, IOException{
		if(!file.isEmpty()){
			//获取要上传到的地址
			String realPath = request.getServletContext().getRealPath("/static/upload");
			String name = CommonsUtils.getUUID()+file.getOriginalFilename();
			
			File dest = new File(realPath+"/"+name);
			file.transferTo(dest);//上传图片
			p.setPimage("upload/"+name);
		}
		p.setPid(CommonsUtils.getUUID());
		p.setPdate(new Date());
		productService.add(p);
		
		return "redirect:/admin/showAllProducts";
	}
	@RequestMapping("/showeditpage")//显示编辑页面,回显
	public String showeditpage(String pid,Model model){
		Product p = productService.findById(pid);
		List<Category> categorys =  categoryService.findAll();
		model.addAttribute("list",categorys);//查询所有商品类型,回显在下拉框
		model.addAttribute("p",p);
		return "forward:/WEB-INF/jsp/admin/products/edit.jsp";
	}
	@RequestMapping("/updateProduct")//保存编辑后的商品
	public String updateProduct(Product p, String cid,@RequestParam("file") MultipartFile file,HttpServletRequest request) throws IllegalStateException, IOException {
		if(!file.isEmpty()){
			//获取要上传到的地址
			String realPath = request.getServletContext().getRealPath("/static/upload");
			String name = CommonsUtils.getUUID()+file.getOriginalFilename();
			
			File dest = new File(realPath+"/"+name);
			file.transferTo(dest);//上传图片
			p.setPimage("upload/"+name);
		}
		p.setPdate(new Date());
		productService.update(p,cid);
		return "redirect:/admin/showAllProducts";
	}
	@RequestMapping(value="/deleteProduct/{pid}",method=RequestMethod.DELETE)//删除商品
	@ResponseBody
	public Map<String,Object>  deleteProduct(@PathVariable String pid) {
		int i = productService.deleteProduct(pid);
		Map<String, Object> map = new HashMap<>();
		 if(i!=0){
				map.put("flag", "1");
				return map;
			}else{
				map.put("flag", "2");
				return map;
			}
	}
	@RequestMapping("/findProductByManyCondition")
	public String findProductByManyCondition(String pid,String pname,String cid,
			String minprice,String maxprice,@RequestParam(value="currentpage",defaultValue="1")Integer currentpage,@RequestParam(defaultValue="5")Integer pageSize,Model model,HttpServletRequest request){
		Page<Object> page = PageHelper.startPage(currentpage, pageSize);
		List<Product> list = productService.findProductByManyCondition(pid,pname,cid,minprice,maxprice);
		for (Product product : list) {
			Category c = categoryService.findById(product.getCid());
			product.setCategory(c);
		}
		PageInfo<Product> pageInfo = new PageInfo<>(list, 3);
		List<Category> categorys =  categoryService.findAll();
		String uri = request.getRequestURI();
		String url = uri+"?"+"pid="+pid+"&pname="+pname+"&cid="+cid+"&minprice="+minprice+"&maxprice="+maxprice+"&";
		
		model.addAttribute("pid",pid);
		model.addAttribute("pname",pname);
		model.addAttribute("cid",cid);
		model.addAttribute("minprice",minprice);
		model.addAttribute("maxprice",maxprice);
		
		model.addAttribute("categorys",categorys);
		model.addAttribute("uri", url);
		model.addAttribute("page",pageInfo);
		model.addAttribute("list",list);
		model.addAttribute("navigatepageNums",pageInfo.getNavigatepageNums());
		return "forward:/WEB-INF/jsp/admin/products/list.jsp";
	}
	@RequestMapping("/showAllOrders")
	public String showAllOrders(Model model){
		List<Orders> list =  orderService.findAll();
		model.addAttribute("list",list);
		return "forward:/WEB-INF/jsp/admin/orders/list.jsp";
	}
	@RequestMapping("/showOrdersInfo")//后台查看订单
	public String showOrdersInfo(String oid,Model model) {
		Orders orders = orderService.findOrderById(oid);
		model.addAttribute("order",orders);
		return"forward:/WEB-INF/jsp/admin/orders/view.jsp";
	}
	@RequestMapping(value="/deleteOrder/{oid}",method=RequestMethod.DELETE)
	@ResponseBody
	public Map<String,Object>  deleteMyOrder(@PathVariable String oid) {
		int i = orderService.deleteMyOrder(oid);
		Map<String, Object> map = new HashMap<>();
		 if(i!=0){
				map.put("flag", "1");
				return map;
			}else{
				map.put("flag", "2");
				return map;
			}
	}
	

}
