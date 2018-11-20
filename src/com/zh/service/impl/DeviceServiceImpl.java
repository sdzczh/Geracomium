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
	public List<Map<String, Object>> get(Map<String, Object> map) {
		String sql="SELECT i.*,b.name uname FROM device i left join staff b on i.userId=b.id";
		List<Map<String, Object>> list = (List<Map<String, Object>>) dao.findBySql(sql);
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
		if(device.getState() == 1){
			device.setCreate_time(DateUtils.getCurrentTimeStr());
		}
		return (Integer) dao.save(device);
	}

	@Override
	public Integer update(Device device) {
		device.setCreate_time(DateUtils.getCurrentTimeStr());
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

	@Override
	public Device getByUserId(Integer id) {
		String sql = "from Device where userId="+id;
		List<Device> list = dao.find(sql);
		return list == null || list.size() == 0 ? null : list.get(0);
	}
	
}
