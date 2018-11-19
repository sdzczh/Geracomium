package com.zh.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.zh.pojo.Consult;
import com.zh.pojo.User;


public interface ConsultService {

	List<Consult> get(Map<String, Object> map);

	Integer del(Integer id);

	Integer add(Consult consult);

	Integer update(Consult consult);

	List<Consult> getById(Integer id, Map<String, Object> map);
	
	
}
