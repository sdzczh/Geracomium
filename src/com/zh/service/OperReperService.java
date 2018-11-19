package com.zh.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.zh.pojo.OperReper;
import com.zh.pojo.User;


public interface OperReperService {

	List<Map<String, Object>> get(Map<String, Object> map);

	Integer del(Integer id);

	Integer add(OperReper operReper);

	Integer update(OperReper operReper);

	List<OperReper> getById(Integer id, Map<String, Object> map);
	
	
}
