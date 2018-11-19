package com.zh.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.zh.pojo.Diet;
import com.zh.pojo.User;


public interface DietService {

	List<Diet> get(Map<String, Object> map);

	Integer del(Integer id);

	Integer add(Diet diet);

	Integer update(Diet diet);

	List<Diet> getById(Integer id, Map<String, Object> map);
	
	
}
