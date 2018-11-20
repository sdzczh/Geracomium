package com.zh.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.zh.pojo.BedType;
import com.zh.pojo.User;


public interface BedTypeService {

	List<BedType> get(Map<String, Object> map);

	Integer del(Integer id);

	Integer add(BedType bedType);

	Integer update(BedType bedType);

	List<BedType> getById(Integer id, Map<String, Object> map);

	BigDecimal getPriceByBedId(Integer bedId);

}
