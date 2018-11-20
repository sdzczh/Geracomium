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
import com.zh.util.StrUtils;
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
		String sql = "from User where id="+user.getId();
		User user1 = (User) dao.find(sql).get(0);
		user1.setName(user.getName());
		user1.setSex(user.getSex());
		user1.setAge(user.getAge());
		user1.setPassword(new1);
		dao.update(user1);
		
	}

	@Override
	public void updateInfo(User user) {
		/*StringBuffer s = new StringBuffer();
		s.append("update from geracomiumdb.user set ");
		if(user.getAge() != null){
			 s.append("age=").append(user.getAge());
		}
		if(!StrUtils.isBlank(user.getName())){
			s.append(", name=").append(user.getName());
		}
		if(user.getSex()!=null){
			s.append(", sex=").append(user.getSex());
		}
		s.append(" where id=").append(user.getId());
		dao.executeSql(s.toString());*/
		dao.update(user);
	}
	
}
