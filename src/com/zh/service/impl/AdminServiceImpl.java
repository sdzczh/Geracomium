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
import com.zh.service.UserService;
@SuppressWarnings("unchecked")
@Service
@Transactional
public class AdminServiceImpl implements AdminService{

	@Autowired
	private BaseDaoI dao;

	@Override
	public List<Admin> login(Admin admin) {
		String sql="from Admin where account='"+admin.getAccount()+"' and password='"+admin.getPassword()+"'";
		List<Admin> list=dao.find(sql);
		return list;
	}

	@Override
	public void update(Admin admin, String new1) {
		String sql = "update admin set admin.password='"+new1+"' where account='admin'";
		dao.executeSql(sql);
		
	}
	
}
