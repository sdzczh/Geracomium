package com.zh.service.impl;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zh.dao.inte.BaseDaoI;
import com.zh.pojo.Diet;
import com.zh.pojo.User;
import com.zh.service.DietService;
import com.zh.service.UserService;
import com.zh.util.DateUtils;
@SuppressWarnings("unchecked")
@Service
@Transactional
public class DietServiceImpl implements DietService{

	@Autowired
	private BaseDaoI dao;

	@Override
	public List<Diet> get(Map<String, Object> map) {
		String sql="from Diet";
		List<Diet> list = dao.find(sql);
		map.put("data", list);
		return list;
	}

	@Override
	public Integer del(Integer id) {
		String hql = "delete from Diet where id="+id;
		return dao.executeHql(hql);
	}

	@Override
	public Integer add(Diet diet) {
		return (Integer) dao.save(diet);
	}

	@Override
	public Integer update(Diet diet) {
		dao.update(diet);
		return 0;
	}

	@Override
	public List<Diet> getById(Integer id, Map<String, Object> map) {
		String hql = "from Diet where id="+id;
		List<Diet> list = dao.find(hql);
		map.put("data", list.get(0));
		return list;
	}
	
}
