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
import com.zh.pojo.Repertory;
import com.zh.pojo.Staff;
import com.zh.pojo.User;
import com.zh.service.AdminService;
import com.zh.service.RepertoryService;
import com.zh.service.StaffService;
import com.zh.service.UserService;

/**
 * 仓库
 * @author 赵赫
 *
 */
@Controller
@RequestMapping("/repertory")
public class RepertoryController extends BaseController {

	@Autowired
	RepertoryService repertoryService;
	@Autowired
	StaffService staffService;

	/**
	 * 查询
	 * @param map
	 * @param repertory
	 * @return
	 */
	@RequestMapping("get")
	public String get(Map<String, Object> map) {
		repertoryService.get(map);
		return "repertory/list";
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("del")
	public String del(Integer id) {
		repertoryService.del(id);
		return "true";
	}
	/**
	 * 增加
	 * @param repertory
	 * @return
	 */
	@ResponseBody
	@RequestMapping("add")
	public String add(Repertory repertory, Map<String, Object> map) {
		List<Staff> list = staffService.getById(repertory.getSid(), map);
		if(list == null || list.size() == 0){
			return "false";
		}
		repertoryService.add(repertory);
		return "true";
	}
	/**
	 * 修改
	 * @param repertory
	 * @return
	 */
	@ResponseBody
	@RequestMapping("update")
	public String update(Repertory repertory, Map<String, Object> map) {
		List<Staff> list = staffService.getById(repertory.getSid(), map);
		if(list == null || list.size() == 0){
			return "false";
		}
		repertoryService.update(repertory);
		return "true";
	}
	/**
	 * 跳转到更新页面
	 * @param repertory
	 * @return
	 */
	@RequestMapping("toUpdate")
	public String toUpdate(Map<String, Object> map, Integer id) {
		repertoryService.getById(id, map);
		return "repertory/update";
	}
	/**
	 * 跳转到添加页面
	 * @param repertory
	 * @return
	 */
	@RequestMapping("toAdd")
	public String toAdd() {
		return "repertory/add";
	}
}
