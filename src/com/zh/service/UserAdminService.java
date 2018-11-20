package com.zh.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.zh.pojo.Admin;
import com.zh.pojo.User;


public interface UserAdminService {

	List<User> login(User user);

	void update(User user, String new1);

	void updateInfo(User user);
	
	
}
