package com.zh.service.impl;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zh.dao.inte.BaseDaoI;
import com.zh.pojo.Visit;
import com.zh.pojo.User;
import com.zh.service.VisitService;
import com.zh.util.DateUtils;
import com.zh.service.UserService;
@SuppressWarnings("unchecked")
@Service
@Transactional
public class VisitServiceImpl implements VisitService{

	@Autowired
	private BaseDaoI dao;

	@Override
	public List<Visit> get(Map<String, Object> map) {
		String sql="from Visit";
		List<Visit> list = dao.find(sql);
		map.put("data", list);
		return list;
	}

	@Override
	public Integer del(Integer id) {
		String hql = "delete from Visit where id="+id;
		return dao.executeHql(hql);
	}

	@Override
	public Integer add(Visit visit) {
		visit.setCreate_time(DateUtils.getCurrentTimeStr());
		return (Integer) dao.save(visit);
	}

	@Override
	public Integer update(Visit visit) {
		dao.update(visit);
		return 0;
	}

	@Override
	public List<Visit> getById(Integer id, Map<String, Object> map) {
		String hql = "from Visit where id="+id;
		List<Visit> list = dao.find(hql);
		map.put("data", list.get(0));
		return list;
	}
	
}
