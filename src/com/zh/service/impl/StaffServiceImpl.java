package com.zh.service.impl;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zh.dao.inte.BaseDaoI;
import com.zh.pojo.Staff;
import com.zh.pojo.User;
import com.zh.service.StaffService;
import com.zh.service.UserService;
import com.zh.util.DateUtils;
@SuppressWarnings("unchecked")
@Service
@Transactional
public class StaffServiceImpl implements StaffService{

	@Autowired
	private BaseDaoI dao;

	@Override
	public List<Staff> get(Map<String, Object> map) {
		String sql="from Staff";
		List<Staff> list = dao.find(sql);
		map.put("data", list);
		return list;
	}

	@Override
	public Integer del(Integer id) {
		String hql = "delete from Staff where id="+id;
		return dao.executeHql(hql);
	}

	@Override
	public Integer add(Staff staff) {
		staff.setCreate_time(DateUtils.getCurrentTimeStr());
		return (Integer) dao.save(staff);
	}

	@Override
	public Integer update(Staff staff) {
		dao.update(staff);
		return 0;
	}

	@Override
	public List<Staff> getById(Integer id, Map<String, Object> map) {
		String hql = "from Staff where id="+id;
		List<Staff> list = dao.find(hql);
		if(list == null || list.size() == 0){
			return null;
		}
		map.put("data", list.get(0));
		return list;
	}
	
}
