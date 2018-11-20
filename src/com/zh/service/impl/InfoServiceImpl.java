package com.zh.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zh.dao.inte.BaseDaoI;
import com.zh.pojo.Info;
import com.zh.pojo.User;
import com.zh.service.InfoService;
import com.zh.service.UserService;
import com.zh.util.DateUtils;
@SuppressWarnings("unchecked")
@Service
@Transactional
public class InfoServiceImpl implements InfoService{

	@Autowired
	private BaseDaoI dao;

	@Override
	public List<Map<String, Object>> get(Map<String, Object> map) {
		String sql="SELECT i.*,u.name FROM info i LEFT JOIN geracomiumdb.user u ON i.userId=u.id";
		List<Map<String, Object>> list = (List<Map<String, Object>>) dao.findBySql(sql);
		map.put("data", list);
		return list;
	}

	@Override
	public Integer del(Integer id) {
		String hql = "delete from Info where id="+id;
		return dao.executeHql(hql);
	}

	@Override
	public Integer add(Info info) {
		info.setCreate_time(DateUtils.getCurrentTimeStr());
		return (Integer) dao.save(info);
	}

	@Override
	public Integer update(Info info) {
		dao.update(info);
		return 0;
	}

	@Override
	public List<Info> getById(Integer id, Map<String, Object> map) {
		String hql = "from Info where id="+id;
		List<Info> list = dao.find(hql);
		Info info = list.get(0);
		hql = "from User where id="+info.getUserId();
		List<User> userList = dao.find(hql);
		map.put("data", info);
		if(userList != null && userList.size() > 0){
			map.put("name", userList.get(0).getName());
		}
		return list;
	}

	@Override
	public Info getId(Integer id, Map<String, Object> map) {
		String sql = "from Info where id="+id;
		List<Info> list = dao.find(sql);
		return list == null || list.size() == 0 ? null : list.get(0);
	}

	@Override
	public Info getByUserId(Integer id) {
		String sql = "from Info where userId="+id;
		List<Info> list = dao.find(sql);
		return list == null || list.size() == 0 ? null : list.get(0);
	}
	
}
