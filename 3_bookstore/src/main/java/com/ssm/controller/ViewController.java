package com.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
	@RequestMapping("/view/{path}")
	public String view(@PathVariable String path){
		return path;
	}
	@RequestMapping("/view/{path}/{path1}")
	public String view(@PathVariable String path,@PathVariable String path1){
		return path+"/"+path1;
	}
	@RequestMapping("/view/{path}/{path1}/{path2}")
	public String view(@PathVariable String path,@PathVariable String path1,@PathVariable String path2){
		return path+"/"+path1+"/"+path2;
	}
}
