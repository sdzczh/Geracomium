package com.zh.service.impl;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zh.dao.inte.BaseDaoI;
import com.zh.pojo.Out;
import com.zh.pojo.User;
import com.zh.service.OutService;
import com.zh.service.UserService;
@SuppressWarnings("unchecked")
@Service
@Transactional
public class OutServiceImpl implements OutService{

	@Autowired
	private BaseDaoI dao;

	@Override
	public List<Out> get(Map<String, Object> map) {
		String sql="from Out";
		List<Out> list = dao.find(sql);
		map.put("data", list);
		return list;
	}

	@Override
	public Integer del(Integer id) {
		String hql = "delete from Out where id="+id;
		return dao.executeHql(hql);
	}

	@Override
	public Integer add(Out out) {
		return (Integer) dao.save(out);
	}

	@Override
	public Integer update(Out out) {
		dao.update(out);
		return 0;
	}

	@Override
	public List<Out> getById(Integer id, Map<String, Object> map) {
		String hql = "from Out where id="+id;
		List<Out> list = dao.find(hql);
		map.put("data", list);
		return list;
	}
	
}
