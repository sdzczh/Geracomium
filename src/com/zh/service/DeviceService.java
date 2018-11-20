package com.zh.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.zh.pojo.Device;
import com.zh.pojo.User;


public interface DeviceService {

	List<Map<String, Object>> get(Map<String, Object> map);

	Integer del(Integer id);

	Integer add(Device device);

	Integer update(Device device);

	List<Device> getById(Integer id, Map<String, Object> map);

	Device getByUserId(Integer id);
	
	
}
