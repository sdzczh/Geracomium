package com.zh.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zh.dao.inte.BaseDaoI;
import com.zh.pojo.BedType;
import com.zh.pojo.User;
import com.zh.service.BedTypeService;
import com.zh.service.UserService;
@SuppressWarnings("unchecked")
@Service
@Transactional
public class BedTypeServiceImpl implements BedTypeService{

	@Autowired
	private BaseDaoI dao;

	@Override
	public List<BedType> get(Map<String, Object> map) {
		String sql="from BedType";
		List<BedType> list = dao.find(sql);
		map.put("data", list);
		return list;
	}

	@Override
	public Integer del(Integer id) {
		String hql = "delete from BedType where id="+id;
		return dao.executeHql(hql);
	}

	@Override
	public Integer add(BedType bedType) {
		return (Integer) dao.save(bedType);
	}

	@Override
	public Integer update(BedType bedType) {
		dao.update(bedType);
		return 0;
	}

	@Override
	public List<BedType> getById(Integer id, Map<String, Object> map) {
		String hql = "from BedType where id="+id;
		List<BedType> list = dao.find(hql);
		if(list == null || list.size() == 0){
			return null;
		}
		map.put("data", list.get(0));
		return list;
	}

	@Override
	public BigDecimal getPriceByBedId(Integer bedId) {
		String sql = "SELECT price FROM bed b LEFT JOIN bed_type bt ON b.type=bt.id WHERE b.id="+bedId;
		List<Map<String, Object>> list = (List<Map<String, Object>>) dao.findBySql(sql);
		if(list == null || list.size() == 0){
			return null;
		}
		Map<String, Object> map = list.get(0);
		BigDecimal amount = new BigDecimal(map.get("price").toString());
		return amount;
	}
	
}
