package com.zh.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.zh.pojo.Register;
import com.zh.pojo.User;


public interface RegisterService {

	List<Register> get(Map<String, Object> map);

	Integer del(Integer id);

	Integer add(Register register);

	Integer update(Register register);

	List<Register> getById(Integer id, Map<String, Object> map);
	
	
}
