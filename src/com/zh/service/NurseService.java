package com.zh.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.zh.pojo.Nurse;
import com.zh.pojo.User;


public interface NurseService {

	List<Map<String, Object>> get(Map<String, Object> map);

	Integer del(Integer id);

	Integer add(Nurse nurse);

	Integer update(Nurse nurse);

	List<Nurse> getById(Integer id, Map<String, Object> map);

	Nurse getByUserId(Integer id);
	
	
}
