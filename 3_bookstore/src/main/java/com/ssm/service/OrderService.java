package com.ssm.service;

import java.util.List;

import com.ssm.pojo.Cart;
import com.ssm.pojo.Orders;
import com.ssm.pojo.User;

public interface OrderService {

	boolean createOrder(Cart cart, String receiverName, String receiverPhone, String receiverAddress, User u);

	List<Orders> findMyorders(String name);

	int deleteMyOrder(String oid);

	List<Orders> findAll();//后台订单展示

	Orders findOrderById(String oid);//后台查看订单

}
