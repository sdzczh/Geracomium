package com.zh.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.zh.pojo.Repertory;
import com.zh.pojo.User;


public interface RepertoryService {

	List<Repertory> get(Map<String, Object> map);

	Integer del(Integer id);

	Integer add(Repertory repertory);

	Integer update(Repertory repertory);

	List<Repertory> getById(Integer id, Map<String, Object> map);
	
	
}
