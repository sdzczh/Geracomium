package com.zh.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.zh.pojo.Bed;
import com.zh.pojo.User;


public interface BedService {

	List<Map<String, Object>> get(Map<String, Object> map);

	Integer del(Integer id);

	Integer add(Bed bed);

	Integer update(Bed bed);

	List<Bed> getById(Integer id, Map<String, Object> map);
	
	
}
