package com.zh.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.zh.base.BaseController;
import com.zh.pojo.Admin;
import com.zh.pojo.BedType;
import com.zh.pojo.OperReper;
import com.zh.pojo.Repertory;
import com.zh.pojo.Staff;
import com.zh.pojo.User;
import com.zh.service.AdminService;
import com.zh.service.OperReperService;
import com.zh.service.RepertoryService;
import com.zh.service.StaffService;
import com.zh.service.UserService;

/**
 * 入库/出库
 * @author 赵赫
 *
 */
@Controller
@RequestMapping("/operReper")
public class OperReperController extends BaseController {

	@Autowired
	OperReperService operReperService;
	@Autowired
	RepertoryService repertoryService;
	@Autowired
	StaffService staffService;

	/**
	 * 查询
	 * @param map
	 * @param operReper
	 * @return
	 */
	@RequestMapping("get")
	public String get(Map<String, Object> map) {
		operReperService.get(map);
		return "operReper/list";
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("del")
	public String del(Integer id) {
		operReperService.del(id);
		return "true";
	}
	/**
	 * 增加
	 * @param operReper
	 * @return
	 */
	@ResponseBody
	@RequestMapping("add")
	public String add(OperReper operReper, Map<String, Object> map) {
		List<Repertory> list = repertoryService.getById(operReper.getRid(), map);
		if(list == null || list.size() == 0){
			return "false";
		}
		List<Staff> list2 = staffService.getById(operReper.getSid(), map);
		if(list2 == null || list2.size() == 0){
			return "error";
		}
		operReperService.add(operReper);
		return "true";
	}
	/**
	 * 修改
	 * @param operReper
	 * @return
	 */
	@ResponseBody
	@RequestMapping("update")
	public String update(OperReper operReper, Map<String, Object> map) {
		List<Repertory> list = repertoryService.getById(operReper.getRid(), map);
		if(list == null || list.size() == 0){
			return "false";
		}
		List<Staff> list2 = staffService.getById(operReper.getSid(), map);
		if(list2 == null || list2.size() == 0){
			return "error";
		}
		operReperService.update(operReper);
		return "true";
	}
	/**
	 * 跳转到更新页面
	 * @param operReper
	 * @return
	 */
	@RequestMapping("toUpdate")
	public String toUpdate(Map<String, Object> map, Integer id) {
		operReperService.getById(id, map);
		return "operReper/update";
	}
	/**
	 * 跳转到添加页面
	 * @param operReper
	 * @return
	 */
	@RequestMapping("toAdd")
	public String toAdd() {
		return "operReper/add";
	}
}
