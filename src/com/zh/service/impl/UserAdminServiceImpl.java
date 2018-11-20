package com.zh.service.impl;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zh.dao.inte.BaseDaoI;
import com.zh.pojo.Admin;
import com.zh.pojo.User;
import com.zh.service.AdminService;
import com.zh.service.UserAdminService;
import com.zh.service.UserService;
@SuppressWarnings("unchecked")
@Service
@Transactional
public class UserAdminServiceImpl implements UserAdminService{

	@Autowired
	private BaseDaoI dao;

	@Override
	public List<User> login(User user) {
		String sql="from User where id='"+user.getId()+"' and password='"+user.getPassword()+"'";
		List<User> list=dao.find(sql);
		return list;
	}

	@Override
	public void update(User user, String new1) {
		String sql = "update geracomiumdb.user set user.password='"+new1+"' where id="+user.getId();
		dao.executeSql(sql);
		
	}
	
}
