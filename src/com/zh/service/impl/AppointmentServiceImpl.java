package com.zh.service.impl;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zh.dao.inte.BaseDaoI;
import com.zh.pojo.Appointment;
import com.zh.pojo.User;
import com.zh.service.AppointmentService;
import com.zh.service.UserService;
import com.zh.util.DateUtils;
@SuppressWarnings("unchecked")
@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService{

	@Autowired
	private BaseDaoI dao;

	@Override
	public List<Appointment> get(Map<String, Object> map) {
		String sql="from Appointment";
		List<Appointment> list = dao.find(sql);
		map.put("data", list);
		return list;
	}

	@Override
	public Integer del(Integer id) {
		String hql = "delete from Appointment where id="+id;
		return dao.executeHql(hql);
	}

	@Override
	public Integer add(Appointment appointment) {
		return (Integer) dao.save(appointment);
	}

	@Override
	public Integer update(Appointment appointment) {
		dao.saveOrUpdate(appointment);
		return 0;
	}

	@Override
	public List<Appointment> getById(Integer id, Map<String, Object> map) {
		String hql = "from Appointment where id="+id;
		List<Appointment> list = dao.find(hql);
		map.put("data", list.get(0));
		return list;
	}
	
}
