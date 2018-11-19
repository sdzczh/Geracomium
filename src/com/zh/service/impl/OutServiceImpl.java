package com.zh.service.impl;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zh.dao.inte.BaseDaoI;
import com.zh.pojo.Out;
import com.zh.pojo.User;
import com.zh.service.OutService;
import com.zh.service.UserService;
import com.zh.util.DateUtils;
@SuppressWarnings("unchecked")
@Service
@Transactional
public class OutServiceImpl implements OutService{

	@Autowired
	private BaseDaoI dao;

	@Override
	public List<Map<String, Object>> get(Map<String, Object> map) {
		String sql="SELECT i.*,u.name FROM geracomiumdb.outLog i LEFT JOIN geracomiumdb.user u ON i.userId=u.id";
		List<Map<String, Object>> list = (List<Map<String, Object>>) dao.findBySql(sql);
		map.put("data", list);
		return list;
	}

	@Override
	public Integer del(Integer id) {
		String hql = "delete from Out where id="+id;
		return dao.executeHql(hql);
	}

	@Override
	public Integer add(Out out) {
		/*String hql = "INSERT INTO geracomiumdb.out (create_time, userId, withName) VALUES ("+out.getCreate_time()+","+out.getUserId()+","+out.getWithName()+")";
		dao.executeSql(hql);*/
		dao.save(out);
		return 0;
	}

	@Override
	public Integer update(Out out) {
		dao.update(out);
		return 0;
	}

	@Override
	public List<Out> getById(Integer id, Map<String, Object> map) {
		String hql = "from Out where id="+id;
		List<Out> list = dao.find(hql);
		Out out = list.get(0);
		map.put("data", out);
		hql = "from User where id="+out.getUserId();
		List<User> userList = dao.find(hql);
		map.put("data", out);
		if(userList != null && userList.size() > 0){
			map.put("name", userList.get(0).getName());
		}
		return list;
	}
	
}
