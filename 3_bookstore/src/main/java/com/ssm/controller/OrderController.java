package com.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.pojo.Cart;
import com.ssm.pojo.Orders;
import com.ssm.pojo.User;
import com.ssm.service.OrderService;


@RequestMapping("/order")
@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/createOrder")//创建订单
	public String creatOrder(String receiverName,String receiverPhone,String receiverAddress,HttpServletRequest request){
		
		
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		if(cart==null){//请先去购物
			return "forward:/WEB-INF/jsp/user/cart.jsp";
		}else{
			User u = (User) session.getAttribute("user");
			//调用service来存储信息
			boolean flag=orderService.createOrder(cart,receiverName,receiverPhone,receiverAddress,u);
			if(flag){//生成订单成功
				//清空购物车
				session.removeAttribute("cart");
				//跳转到支付界面
				return "/user/index";
			}else{
				return "/user/index";//有问题,稍后修改
			}
		}
	}
	@RequestMapping("/showMyorders")
	public String showMyorders(String name,Model model){
		List<Orders> list = orderService.findMyorders(name);
		model.addAttribute("list",list);
		return "forward:/WEB-INF/jsp/user/orderlist.jsp";
	}
	@RequestMapping("/showOrdersInfo")//用户查看订单
	public String showOrdersInfo(String oid,Model model){
		Orders orders = orderService.findOrderById(oid);
		model.addAttribute("order",orders);
		return"forward:/WEB-INF/jsp/user/orderInfo.jsp";
	}
	
	
	@RequestMapping(value="/deleteMyOrder/{oid}",method=RequestMethod.DELETE)
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
