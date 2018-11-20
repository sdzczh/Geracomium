package com.zh.service.impl;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zh.dao.inte.BaseDaoI;
import com.zh.pojo.Device;
import com.zh.pojo.Nurse;
import com.zh.pojo.User;
import com.zh.service.NurseService;
import com.zh.service.UserService;
import com.zh.util.DateUtils;
@SuppressWarnings("unchecked")
@Service
@Transactional
public class NurseServiceImpl implements NurseService{

	@Autowired
	private BaseDaoI dao;

	@Override
	public List<Map<String, Object>> get(Map<String, Object> map) {
		String sql="SELECT i.*,b.name uname FROM nurse i left join geracomiumdb.user b on i.userId=b.id";
		List<Map<String, Object>> list = (List<Map<String, Object>>) dao.findBySql(sql);
		map.put("data", list);
		return list;
	}

	@Override
	public Integer del(Integer id) {
		String hql = "delete from Nurse where id="+id;
		return dao.executeHql(hql);
	}

	@Override
	public Integer add(Nurse nurse) {
		nurse.setCreate_time(DateUtils.getCurrentTimeStr());
		return (Integer) dao.save(nurse);
	}

	@Override
	public Integer update(Nurse nurse) {
		dao.update(nurse);
		return 0;
	}

	@Override
	public List<Nurse> getById(Integer id, Map<String, Object> map) {
		String hql = "from Nurse where id="+id;
		List<Nurse> list = dao.find(hql);
		map.put("data", list.get(0));
		return list;
	}

	@Override
	public Nurse getByUserId(Integer id) {
		String sql = "from Nurse where userId="+id;
		List<Nurse> list = dao.find(sql);
		return list == null || list.size() == 0 ? null : list.get(0);
	}
	
}
