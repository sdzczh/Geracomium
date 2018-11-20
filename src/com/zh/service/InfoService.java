package com.zh.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.zh.pojo.Info;
import com.zh.pojo.User;


public interface InfoService {

	List<Map<String, Object>> get(Map<String, Object> map);

	Integer del(Integer id);

	Integer add(Info info);

	Integer update(Info info);

	List<Info> getById(Integer id, Map<String, Object> map);

	Info getId(Integer id, Map<String, Object> map);

	Info getByUserId(Integer id);
	
	
}
