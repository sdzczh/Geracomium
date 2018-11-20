package com.zh.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.zh.pojo.User;
import com.zh.pojo.User;


public interface UserService {

	List<User> get(Map<String, Object> map);

	Integer del(Integer id);

	Integer add(User user);

	Integer update(User user);

	List<User> getById(Integer id, Map<String, Object> map);

	List<User> getUserByBedId(Integer bedId, Map<String, Object> map);
	
}
