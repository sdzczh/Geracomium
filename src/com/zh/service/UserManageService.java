package com.zh.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.zh.pojo.User;


public interface UserManageService {

	List<User> findUser(User user);
	
	
}
