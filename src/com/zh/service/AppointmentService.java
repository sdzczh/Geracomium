package com.zh.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.zh.pojo.Appointment;
import com.zh.pojo.User;


public interface AppointmentService {

	List<Appointment> get(Map<String, Object> map);

	Integer del(Integer id);

	Integer add(Appointment appointment);

	Integer update(Appointment appointment);

	List<Appointment> getById(Integer id, Map<String, Object> map);
	
	
}
