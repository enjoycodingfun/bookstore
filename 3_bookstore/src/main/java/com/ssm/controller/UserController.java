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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.pojo.News;
import com.ssm.pojo.User;
import com.ssm.service.NewsService;
import com.ssm.service.UserService;
import com.ssm.utils.CommonsUtils;
import com.ssm.utils.MD5Utils;
import com.ssm.utils.SendJMail;

@RequestMapping("/user")
@Controller
public class UserController {
	@Autowired
	private UserService userservice;
	@Autowired
	private NewsService newsservice;
	
	
	@RequestMapping("/checkUname")//登录时检查用户名是否存在
	@ResponseBody
	public Map<String,Object> checkUname(String uname,HttpServletRequest request,HttpServletResponse response){
		boolean flag = userservice.checkUname(uname);
		Map<String,Object> map = new HashMap<>();
		if(flag){//名字查到了
			map.put("flag", "1");
		}else{
			map.put("flag", "0");
		}
		return map;
	}
	@RequestMapping("/login")//登录,自动登录
	public String login(User user,String rememberMe,String autoLogin,HttpServletResponse response, HttpServletRequest request){
		User user1 = userservice.findUser(user);
			Cookie c=new Cookie("username",user.getUname());
			Cookie c1=new Cookie("upwd",user.getUpwd());
			Cookie c2=new Cookie("autoLogin",autoLogin);
			if(user1!=null){
				if("on".equals(rememberMe)){//勾选了记住我框
						//设置时长15天
						c.setMaxAge(15*24*3600);
						c1.setMaxAge(15*24*3600);
					}else{//登陆成功但不记住名字
						c.setMaxAge(0);
						c1.setMaxAge(0);
					}
					//存储cookie
					response.addCookie(c);
					response.addCookie(c1);	
					if("on".equals(autoLogin)){
						c2.setMaxAge(15*24*3600);
					}
					response.addCookie(c2);
					request.getSession().setAttribute("user", user1);
					return "/user/index";
			}else{//没查到user
				return "/user/login";
			}
		}
	@RequestMapping("/logout")//注销
	public String login(HttpServletRequest request,HttpServletResponse response){
		request.getSession().invalidate();
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for (Cookie cookie : cookies) {
				if("autoLogin".equals(cookie.getName())){
					cookie.setMaxAge(0);
					response.addCookie(cookie);
					break;
				}
			}
		}
		return "/user/login";
	}
	@RequestMapping("/checkCode")//注册时候验证验证码是否正确
	@ResponseBody
	public Map<String,Object> checkCode(String code,HttpServletRequest request,HttpServletResponse response){
		String code1 = (String) request.getSession().getAttribute("checkcode_session");//获取自动生成的验证码
		Map<String,Object> map = new HashMap<>();
		if(!code.equals(code1)){//验证码不正确
			map.put("flag", "0");
		}else{
			map.put("flag", "1");
		}
		return map;
	}
	@RequestMapping("/register")//新用户注册
	public String register(User user,HttpServletRequest request,HttpServletResponse response){
		//手动设置 uid  code  state默认是0
		user.setUid(CommonsUtils.getUUID());		
		user.setCode(CommonsUtils.getUUID());
		//密码加密后存储 
		user.setUpwd(MD5Utils.md5(user.getUpwd()));
		//调用service方法注册
		boolean flag=userservice.register(user);
			if(flag){//注册成功
				
				/*String str="http://10.31.158.69:8080"+request.getContextPath()+"/userServlet?action=activeUser&uid="+user.getUid()+"&code="+user.getCode();
				boolean f=SendJMail.sendMail(user.getUemail(), str);
				if(f){//注册成功
					return "redirect:/WEB-INF/jsp/user/registersuccess.jsp";
				}else{//邮箱有问题
					return "forward:/WEB-INF/jsp/user/register.jsp";
				}*/
				return "/user/registersuccess";
			}else{//注册失败  数据有问题
				//转发到主策界面
				//数据回显示   原来写的数据  在给我  
				request.setAttribute("u", user);
				request.setAttribute("error", "注册失败~");
				return "forward:/WEB-INF/jsp/user/register.jsp";
			}
	}
	@RequestMapping("/modifyUserInfo")
	public String modifyUserInfo(User u,HttpServletRequest request) {
		userservice.modifyUserInfo(u);
		request.getSession().setAttribute("user",u);
		return "/user/modifyUserInfoSuccess";
	}
	@RequestMapping("/showNews")
	@ResponseBody
	public Map<String,Object> showNews() {
		List<News> news = newsservice.showNews();
		Map<String,Object> map = new HashMap<>();
		map.put("news",news);
		return map;
	}
	
	
	
	
	
}
