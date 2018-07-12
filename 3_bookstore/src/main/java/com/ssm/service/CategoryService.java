package com.ssm.service;

import java.util.List;

import com.ssm.pojo.Category;

public interface CategoryService {

	List<Category> findAll();//查找所有商品类目

	Category findById(String cid);//根据cid查找商品所属类目,回显在详情页

}
