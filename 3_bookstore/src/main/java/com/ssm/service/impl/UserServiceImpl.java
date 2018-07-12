package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.mapper.UserMapper;
import com.ssm.pojo.User;
import com.ssm.pojo.UserExample;
import com.ssm.pojo.UserExample.Criteria;
import com.ssm.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper usermapper;
	@Override//登录时验证用户名
	public boolean checkUname(String uname) {
		UserExample userexample = new UserExample();
		Criteria criteria = userexample.createCriteria();
		criteria.andUnameEqualTo(uname);
		List<User> list = usermapper.selectByExample(userexample);
		if(list.isEmpty()){
			return false;//名字没查到,不正确
		}
		return true;//名字查到,正确
	}
	@Override//登录时验证用户名密码是否正确
	public User findUser(User user) {
		UserExample userexample = new UserExample();
		Criteria criteria = userexample.createCriteria();
		criteria.andUnameEqualTo(user.getUname()).andUpwdEqualTo(user.getUpwd());
		List<User> list = usermapper.selectByExample(userexample);
		if(list.isEmpty()){
			return null;//没查到,不正确
		}
		return list.get(0);
	}
	@Override//注册
	public boolean register(User user) {
		int i = usermapper.insertSelective(user);
		if(i!=0){
			return true;
		}
		return false;
	}
	@Override//修改用户信息
	public void modifyUserInfo(User u) {
		usermapper.updateByPrimaryKey(u);
	}
}
