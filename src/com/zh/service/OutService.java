package com.zh.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.zh.pojo.Out;
import com.zh.pojo.User;


public interface OutService {

	List<Map<String, Object>> get(Map<String, Object> map);

	Integer del(Integer id);

	Integer add(Out out);

	Integer update(Out out);

	List<Out> getById(Integer id, Map<String, Object> map);
	
	
}
