package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.mapper.CategoryMapper;
import com.ssm.pojo.Category;
import com.ssm.pojo.CategoryExample;
import com.ssm.pojo.User;
import com.ssm.pojo.UserExample;
import com.ssm.pojo.UserExample.Criteria;
import com.ssm.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryMapper categoryMapper;
	@Override
	public List<Category> findAll() {
		
		return categoryMapper.findAll();
	}
	@Override//根据cid查找商品所属类目,回显在详情页
	public Category findById(String cid) {
		return categoryMapper.selectByPrimaryKey(cid);
	}

}
