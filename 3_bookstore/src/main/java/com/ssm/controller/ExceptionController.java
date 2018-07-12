package com.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ControllerAdvice

	public class ExceptionController {
		
		@RequestMapping("/error")
		@ExceptionHandler(Exception.class)
		public  ModelAndView handler(Exception e){
			
			ModelAndView mav=new ModelAndView();
			
			mav.addObject("msg", e.getMessage());
			
			mav.setViewName("error");
			
			return mav;
		}
	}
