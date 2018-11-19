package com.zh.service.impl;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zh.dao.inte.BaseDaoI;
import com.zh.pojo.Device;
import com.zh.pojo.User;
import com.zh.service.DeviceService;
import com.zh.service.UserService;
import com.zh.util.DateUtils;
@SuppressWarnings("unchecked")
@Service
@Transactional
public class DeviceServiceImpl implements DeviceService{

	@Autowired
	private BaseDaoI dao;

	@Override
	public List<Device> get(Map<String, Object> map) {
		String sql="from Device";
		List<Device> list = dao.find(sql);
		map.put("data", list);
		return list;
	}

	@Override
	public Integer del(Integer id) {
		String hql = "delete from Device where id="+id;
		return dao.executeHql(hql);
	}

	@Override
	public Integer add(Device device) {
		device.setCreate_time(DateUtils.getCurrentTimeStr());
		return (Integer) dao.save(device);
	}

	@Override
	public Integer update(Device device) {
		dao.update(device);
		return 0;
	}

	@Override
	public List<Device> getById(Integer id, Map<String, Object> map) {
		String hql = "from Device where id="+id;
		List<Device> list = dao.find(hql);
		map.put("data", list.get(0));
		return list;
	}
	
}
