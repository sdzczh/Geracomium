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
import com.zh.pojo.Staff;
import com.zh.pojo.User;
import com.zh.service.AdminService;
import com.zh.service.StaffService;
import com.zh.service.UserService;

/**
 * 员工
 * @author 赵赫
 *
 */
@Controller
@RequestMapping("/staff")
public class StaffController extends BaseController {

	@Autowired
	StaffService staffService;

	/**
	 * 查询
	 * @param map
	 * @param staff
	 * @return
	 */
	@RequestMapping("get")
	public String get(Map<String, Object> map) {
		staffService.get(map);
		return "true";
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("del")
	public String del(Integer id) {
		staffService.del(id);
		return "true";
	}
	/**
	 * 增加
	 * @param staff
	 * @return
	 */
	@ResponseBody
	@RequestMapping("add")
	public String add(Staff staff) {
		staffService.add(staff);
		return "true";
	}
	/**
	 * 修改
	 * @param staff
	 * @return
	 */
	@ResponseBody
	@RequestMapping("update")
	public String update(Staff staff) {
		staffService.update(staff);
		return "true";
	}
	/**
	 * 跳转到更新页面
	 * @param staff
	 * @return
	 */
	@RequestMapping("toUpdate")
	public String toUpdate(Map<String, Object> map, Integer id) {
		staffService.getById(id, map);
		return "staff/update";
	}
	/**
	 * 跳转到添加页面
	 * @param staff
	 * @return
	 */
	@RequestMapping("toAdd")
	public String toAdd() {
		return "staff/add";
	}
}
