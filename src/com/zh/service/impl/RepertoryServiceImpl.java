package com.zh.service.impl;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zh.dao.inte.BaseDaoI;
import com.zh.pojo.Repertory;
import com.zh.pojo.User;
import com.zh.service.RepertoryService;
import com.zh.service.UserService;
@SuppressWarnings("unchecked")
@Service
@Transactional
public class RepertoryServiceImpl implements RepertoryService{

	@Autowired
	private BaseDaoI dao;

	@Override
	public List<Repertory> get(Map<String, Object> map) {
		String sql="from Repertory";
		List<Repertory> list = dao.find(sql);
		map.put("data", list);
		return list;
	}

	@Override
	public Integer del(Integer id) {
		String hql = "delete from Repertory where id="+id;
		return dao.executeHql(hql);
	}

	@Override
	public Integer add(Repertory repertory) {
		return (Integer) dao.save(repertory);
	}

	@Override
	public Integer update(Repertory repertory) {
		dao.update(repertory);
		return 0;
	}

	@Override
	public List<Repertory> getById(Integer id, Map<String, Object> map) {
		String hql = "from Repertory where id="+id;
		List<Repertory> list = dao.find(hql);
		if(list == null || list.size() == 0){
			return null;
		}
		map.put("data", list.get(0));
		return list;
	}
	
}
