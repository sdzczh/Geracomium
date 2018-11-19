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
import com.zh.pojo.Register;
import com.zh.pojo.User;
import com.zh.service.AdminService;
import com.zh.service.RegisterService;
import com.zh.service.UserService;

/**
 * 入住
 * @author 赵赫
 *
 */
@Controller
@RequestMapping("/register")
public class RegisterController extends BaseController {

	@Autowired
	RegisterService registerService;

	/**
	 * 查询
	 * @param map
	 * @param register
	 * @return
	 */
	@RequestMapping("get")
	public String get(Map<String, Object> map) {
		registerService.get(map);
		return "register/list";
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("del")
	public String del(Integer id) {
		registerService.del(id);
		return "true";
	}
	/**
	 * 增加
	 * @param register
	 * @return
	 */
	@ResponseBody
	@RequestMapping("add")
	public String add(Register register) {
		registerService.add(register);
		return "true";
	}
	/**
	 * 修改
	 * @param register
	 * @return
	 */
	@ResponseBody
	@RequestMapping("update")
	public String update(Register register) {
		registerService.update(register);
		return "true";
	}
	/**
	 * 跳转到更新页面
	 * @param register
	 * @return
	 */
	@RequestMapping("toUpdate")
	public String toUpdate(Map<String, Object> map, Integer id) {
		registerService.getById(id, map);
		return "register/update";
	}
	/**
	 * 跳转到添加页面
	 * @param register
	 * @return
	 */
	@RequestMapping("toAdd")
	public String toAdd() {
		return "register/add";
	}
}
