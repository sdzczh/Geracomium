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
	public List<Map<String, Object>> get(Map<String, Object> map) {
		String sql="SELECT i.*,u.name lname FROM geracomiumdb.visit i LEFT JOIN geracomiumdb.user u ON i.userId=u.id";
		List<Map<String, Object>> list = (List<Map<String, Object>>) dao.findBySql(sql);
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
		Visit visit = list.get(0);
		map.put("data", visit);
		hql = "from User where id="+visit.getUserId();
		List<User> userList = dao.find(hql);
		map.put("data", visit);
		if(userList != null && userList.size() > 0){
			map.put("name", userList.get(0).getName());
		}
		return list;
	}
	
}
