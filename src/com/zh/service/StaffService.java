package com.zh.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.zh.pojo.Staff;
import com.zh.pojo.User;


public interface StaffService {

	List<Staff> get(Map<String, Object> map);

	Integer del(Integer id);

	Integer add(Staff staff);

	Integer update(Staff staff);

	List<Staff> getById(Integer id, Map<String, Object> map);
	
	
}
