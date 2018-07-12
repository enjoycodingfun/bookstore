package com.ssm.service;

import java.util.List;

import com.ssm.pojo.Product;

public interface ProductService {

	List<Product> findAll(String cid);//按照商品种类查找商品列表

	Product findById(String pid);//根据pid查找商品详细信息

	List<Product> findProductBySearch(String name);//根据搜索条件查询商品

	List<Product> findAll();//后台管理显示所有商品

	void add(Product p);//管理员添加商品

	void update(Product p, String cid);

	int deleteProduct(String pid);

	List<Product> findProductByManyCondition(String pid, String pname, String cid,String minprice,
			String maxprice);
}
