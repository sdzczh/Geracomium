package com.zh.service.impl;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zh.dao.inte.BaseDaoI;
import com.zh.pojo.Register;
import com.zh.pojo.User;
import com.zh.service.RegisterService;
import com.zh.service.UserService;
import com.zh.util.DateUtils;
@SuppressWarnings("unchecked")
@Service
@Transactional
public class RegisterServiceImpl implements RegisterService{

	@Autowired
	private BaseDaoI dao;

	@Override
	public List<Register> get(Map<String, Object> map) {
		String sql="from Register";
		List<Register> list = dao.find(sql);
		map.put("data", list);
		return list;
	}

	@Override
	public Integer del(Integer id) {
		String hql = "delete from Register where id="+id;
		return dao.executeHql(hql);
	}

	@Override
	public Integer add(Register register) {
		register.setCreate_time(DateUtils.getCurrentTimeStr());
		return (Integer) dao.save(register);
	}

	@Override
	public Integer update(Register register) {
		dao.update(register);
		return 0;
	}

	@Override
	public List<Register> getById(Integer id, Map<String, Object> map) {
		String hql = "from Register where id="+id;
		List<Register> list = dao.find(hql);
		map.put("data", list.get(0));
		return list;
	}
	
}
