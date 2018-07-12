package com.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.pojo.Category;
import com.ssm.pojo.User;
import com.ssm.service.CategoryService;
import com.ssm.service.UserService;
import com.ssm.utils.CommonsUtils;
import com.ssm.utils.MD5Utils;
import com.ssm.utils.SendJMail;

@RequestMapping("/category")
@Controller
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/ajaxFindCategorys")//初始化商品类目
	@ResponseBody
	public Map<String,Object> findCategorys(){
		List<Category> categorys = categoryService.findAll();
		Map<String,Object> map = new HashMap<>();
		map.put("categorys", categorys);
		return map;
	}

	
	
	
	
	
	
}
