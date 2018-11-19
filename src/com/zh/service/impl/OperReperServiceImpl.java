package com.zh.service.impl;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zh.dao.inte.BaseDaoI;
import com.zh.pojo.OperReper;
import com.zh.pojo.User;
import com.zh.service.OperReperService;
import com.zh.service.UserService;
@SuppressWarnings("unchecked")
@Service
@Transactional
public class OperReperServiceImpl implements OperReperService{

	@Autowired
	private BaseDaoI dao;

	@Override
	public List<OperReper> get(Map<String, Object> map) {
		String sql="from OperReper";
		List<OperReper> list = dao.find(sql);
		map.put("data", list);
		return list;
	}

	@Override
	public Integer del(Integer id) {
		String hql = "delete from OperReper where id="+id;
		return dao.executeHql(hql);
	}

	@Override
	public Integer add(OperReper operReper) {
		return (Integer) dao.save(operReper);
	}

	@Override
	public Integer update(OperReper operReper) {
		dao.update(operReper);
		return 0;
	}

	@Override
	public List<OperReper> getById(Integer id, Map<String, Object> map) {
		String hql = "from OperReper where id="+id;
		List<OperReper> list = dao.find(hql);
		map.put("data", list);
		return list;
	}
	
}
