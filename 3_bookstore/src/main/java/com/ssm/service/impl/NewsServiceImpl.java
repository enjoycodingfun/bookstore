package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.mapper.NewsMapper;
import com.ssm.pojo.News;
import com.ssm.pojo.NewsExample;
import com.ssm.pojo.NewsExample.Criteria;
import com.ssm.service.NewsService;
@Service
public class NewsServiceImpl implements NewsService {
	@Autowired
	private NewsMapper newsMapper;

	@Override
	public List<News> showNews() {
		NewsExample newsExample = new NewsExample();
		Criteria criteria = newsExample.createCriteria();
		return  newsMapper.selectByExample(newsExample);
	}

}
