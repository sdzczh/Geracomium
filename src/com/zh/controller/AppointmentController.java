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
import com.zh.pojo.Appointment;
import com.zh.pojo.User;
import com.zh.service.AdminService;
import com.zh.service.AppointmentService;
import com.zh.service.UserService;

/**
 * 预约
 * @author 赵赫
 *
 */
@Controller
@RequestMapping("/appointment")
public class AppointmentController extends BaseController {

	@Autowired
	AppointmentService appointmentService;

	/**
	 * 查询
	 * @param map
	 * @param Appointment
	 * @return
	 */
	@RequestMapping("get")
	public String get(Map<String, Object> map) {
		appointmentService.get(map);
		return "appointment/list";
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("del")
	public String del(Integer id) {
		appointmentService.del(id);
		return "true";
	}
	/**
	 * 增加
	 * @param appointment
	 * @return
	 */
	@ResponseBody
	@RequestMapping("add")
	public String add(Appointment appointment) {
		appointmentService.add(appointment);
		return "true";
	}
	/**
	 * 修改
	 * @param appointment
	 * @return
	 */
	@ResponseBody
	@RequestMapping("update")
	public String update(Appointment appointment) {
		appointmentService.update(appointment);
		return "true";
	}
	/**
	 * 跳转到更新页面
	 * @param appointment
	 * @return
	 */
	@RequestMapping("toUpdate")
	public String toUpdate(Map<String, Object> map, Integer id) {
		appointmentService.getById(id, map);
		return "appointment/update";
	}
	/**
	 * 跳转到添加页面
	 * @param appointment
	 * @return
	 */
	@RequestMapping("toAdd")
	public String toAdd() {
		return "appointment/add";
	}
}
