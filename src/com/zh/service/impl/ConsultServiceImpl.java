package com.zh.service.impl;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zh.dao.inte.BaseDaoI;
import com.zh.pojo.Consult;
import com.zh.pojo.User;
import com.zh.service.ConsultService;
import com.zh.service.UserService;
import com.zh.util.DateUtils;
@SuppressWarnings("unchecked")
@Service
@Transactional
public class ConsultServiceImpl implements ConsultService{

	@Autowired
	private BaseDaoI dao;

	@Override
	public List<Consult> get(Map<String, Object> map) {
		String sql="from Consult";
		List<Consult> list = dao.find(sql);
		map.put("data", list);
		return list;
	}

	@Override
	public Integer del(Integer id) {
		String hql = "delete from Consult where id="+id;
		return dao.executeHql(hql);
	}

	@Override
	public Integer add(Consult consult) {
		consult.setCreate_time(DateUtils.getCurrentTimeStr());
		return (Integer) dao.save(consult);
	}

	@Override
	public Integer update(Consult consult) {
		dao.update(consult);
		return 0;
	}

	@Override
	public List<Consult> getById(Integer id, Map<String, Object> map) {
		String hql = "from Consult where id="+id;
		List<Consult> list = dao.find(hql);
		map.put("data", list.get(0));
		return list;
	}
	
}
