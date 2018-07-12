package com.ssm.service.impl;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.mapper.CategoryMapper;
import com.ssm.mapper.OrderitemMapper;
import com.ssm.mapper.OrdersMapper;
import com.ssm.mapper.ProductMapper;
import com.ssm.mapper.UserMapper;
import com.ssm.pojo.Cart;
import com.ssm.pojo.CartItem;
import com.ssm.pojo.Category;
import com.ssm.pojo.Orderitem;
import com.ssm.pojo.OrderitemExample;
import com.ssm.pojo.Orders;
import com.ssm.pojo.OrdersExample;
import com.ssm.pojo.OrdersExample.Criteria;
import com.ssm.pojo.Product;
import com.ssm.pojo.User;
import com.ssm.service.OrderService;
import com.ssm.utils.CommonsUtils;
@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrdersMapper ordersMapper;
	@Autowired
	OrderitemMapper orderitemMapper;
	@Autowired
	UserMapper userMapper;
	@Autowired
	ProductMapper productMapper;
	@Autowired
	CategoryMapper categoryMapper;

	@Override
	public boolean createOrder(Cart cart, String receiverName, String receiverPhone, String receiverAddress, User u) {
		Orders orders = new Orders();
		orders.setAddress(receiverAddress);
		orders.setName(receiverName);
		orders.setTelephone(receiverPhone);
		orders.setOid(CommonsUtils.getUUID());
		orders.setOrdertime(new Date());
		orders.setState(0);
		orders.setTotal(cart.getTotal());
		orders.setUid(u.getUid());
		ordersMapper.insert(orders);
		
		Map<String, CartItem> items = cart.getItems();
		Collection<CartItem> values = items.values();//获得全部的商品项
		
		//List<Orderitem> list = new ArrayList();
		for (CartItem c : values) {
			Orderitem o = new Orderitem();
			o.setCount(c.getBuyNum());
			o.setItemid(CommonsUtils.getUUID());
			o.setOid(orders.getOid());
			o.setPid(c.getProduct().getPid());
			o.setSubtotal(c.getSubTotal());
			//list.add(o);
			orderitemMapper.insert(o);
		}
		return true;
	}

	@Override
	public List<Orders> findMyorders(String name) {
		OrdersExample ordersExample = new OrdersExample();
		Criteria criteria = ordersExample.createCriteria();
		criteria.andNameEqualTo(name);
		return ordersMapper.selectByExample(ordersExample);
	}

	@Override
	public int deleteMyOrder(String oid) {
		return ordersMapper.deleteByPrimaryKey(oid);
	}

	@Override
	public List<Orders> findAll() {
		OrdersExample ordersExample = new OrdersExample();
		Criteria criteria = ordersExample.createCriteria();
		return ordersMapper.selectByExample(ordersExample);
	}

	@Override
	public Orders findOrderById(String oid) {
		Orders orders = ordersMapper.selectByPrimaryKey(oid);
		OrderitemExample orderitemExample = new OrderitemExample();
		com.ssm.pojo.OrderitemExample.Criteria criteria = orderitemExample.createCriteria();
		criteria.andOidEqualTo(oid);
		Orderitem orderitem = orderitemMapper.selectByExample(orderitemExample).get(0);
		Product p = productMapper.selectByPrimaryKey(orderitem.getPid());
		Category category = categoryMapper.selectByPrimaryKey(p.getCid());
		User user = userMapper.selectByPrimaryKey(orders.getUid());
		p.setCategory(category);
		orders.setOrderitem(orderitem);
		orders.setProduct(p);
		orders.setUser(user);
		return orders;
	}
}
