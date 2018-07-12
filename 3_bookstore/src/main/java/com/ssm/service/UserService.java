package com.ssm.service;

import com.ssm.pojo.User;

public interface UserService {

	boolean checkUname(String uname);

	User findUser(User user);//登录时验证用户名密码对不对

	boolean register(User user);//注册时保存用户

	void modifyUserInfo(User u);//修改用户名

}
