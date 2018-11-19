package com.zh.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.zh.pojo.Visit;
import com.zh.pojo.User;


public interface VisitService {

	List<Map<String, Object>> get(Map<String, Object> map);

	Integer del(Integer id);

	Integer add(Visit visit);

	Integer update(Visit visit);

	List<Visit> getById(Integer id, Map<String, Object> map);
	
	
}
