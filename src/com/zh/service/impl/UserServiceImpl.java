package com.zh.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zh.dao.inte.BaseDaoI;
import com.zh.pojo.User;
import com.zh.pojo.User;
import com.zh.service.UserService;
import com.zh.util.DateUtils;
@SuppressWarnings("unchecked")
@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private BaseDaoI dao;

	@Override
	public List<User> get(Map<String, Object> map) {
		String sql="from User";
		List<User> list = dao.find(sql);
		map.put("data", list);
		return list;
	}

	@Override
	public Integer del(Integer id) {
		String hql = "delete from User where id="+id;
		return dao.executeHql(hql);
	}

	@Override
	public Integer add(User user) {
		user.setCreate_time(DateUtils.getCurrentTimeStr());
		return (Integer) dao.save(user);
	}

	@Override
	public Integer update(User user) {
		dao.saveOrUpdate(user);
		return 0;
	}

	@Override
	public List<User> getById(Integer id, Map<String, Object> map) {
		String hql = "from User where id="+id;
		List<User> list = dao.find(hql);
		if(list == null || list.size() == 0){
			return null;
		}
		map.put("data", list.get(0));
		return list;
	}

	@Override
	public List<User> getUserByBedId(Integer bedId, Map<String, Object> map) {
		String hql = "from User where bedId="+bedId;
		List<User> list = dao.find(hql);
		if(list == null || list.size() == 0){
			return null;
		}
		map.put("data", list.get(0));
		return list;
	}
	
}