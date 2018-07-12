package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.mapper.CategoryMapper;
import com.ssm.mapper.ProductMapper;
import com.ssm.pojo.Category;
import com.ssm.pojo.Product;
import com.ssm.pojo.ProductExample;
import com.ssm.pojo.ProductExample.Criteria;
import com.ssm.service.ProductService;
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private CategoryMapper categoryMapper;
	
	
	@Override
	public List<Product> findAll(String cid) {
		ProductExample productExample = new ProductExample();
		Criteria criteria = productExample.createCriteria();
		criteria.andCidEqualTo(cid);
		List<Product> list = productMapper.selectByExample(productExample);
		return list;
	}
	@Override
	public Product findById(String pid) {
		Product p = productMapper.selectByPrimaryKey(pid);
		return p;
	}
	@Override
	public List<Product> findProductBySearch(String name) {
		ProductExample productExample = new ProductExample();
		Criteria criteria = productExample.createCriteria();
		criteria.andPdescLike("%"+name+"%");
		List<Product> list = productMapper.selectByExample(productExample);
		return list;
	}
	@Override
	public List<Product> findAll() {
		List<Product> list = productMapper.findAll();
		return list;
	}
	@Override
	public void add(Product p) {
		productMapper.insert(p);
	}
	@Override
	public void update(Product p, String cid) {
		Category category = categoryMapper.selectByPrimaryKey(cid);
		p.setCategory(category);
		productMapper.updateByPrimaryKeySelective(p);
	}
	@Override
	public int deleteProduct(String pid) {
		return productMapper.deleteByPrimaryKey(pid);
	}
	@Override
	public List<Product> findProductByManyCondition(String pid, String pname, String cid,String minprice,String maxprice) {
		ProductExample productExample = new ProductExample();
		Criteria criteria = productExample.createCriteria();
		if(pid!=null&&!"".equals(pid)){
			criteria.andPidEqualTo(pid);
		}
		if(pname!=null&&!"".equals(pname)){
			criteria.andPnameLike("%"+pname+"%");
		}
		if(cid!=null&&!"".equals(cid)){
			criteria.andCidEqualTo(cid);
		}
		if(minprice!=null&&!"".equals(minprice)&&maxprice!=null&&!"".equals(maxprice)){
			double min = Double.parseDouble(minprice);
			double max = Double.parseDouble(maxprice);
			criteria.andMarketPriceBetween(min, max);
		}
		return  productMapper.selectByExample(productExample);
	}

}
