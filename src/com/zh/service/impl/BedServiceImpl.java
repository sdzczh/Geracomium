package com.zh.service.impl;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zh.dao.inte.BaseDaoI;
import com.zh.pojo.Bed;
import com.zh.pojo.User;
import com.zh.service.BedService;
import com.zh.service.UserService;
@SuppressWarnings("unchecked")
@Service
@Transactional
public class BedServiceImpl implements BedService{

	@Autowired
	private BaseDaoI dao;

	@Override
	public List<Bed> get(Map<String, Object> map) {
		String sql="from Bed";
		List<Bed> list = dao.find(sql);
		map.put("data", list);
		return list;
	}

	@Override
	public Integer del(Integer id) {
		String hql = "delete from Bed where id="+id;
		return dao.executeHql(hql);
	}

	@Override
	public Integer add(Bed bed) {
		return (Integer) dao.save(bed);
	}

	@Override
	public Integer update(Bed bed) {
		dao.update(bed);
		return 0;
	}

	@Override
	public List<Bed> getById(Integer id, Map<String, Object> map) {
		String hql = "from Bed where id="+id;
		List<Bed> list = dao.find(hql);
		map.put("data", list);
		return list;
	}
	
}
