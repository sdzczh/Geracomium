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
import com.zh.pojo.User;
import com.zh.service.UserService;


@Controller
@RequestMapping("/user")
public class UserManagController extends BaseController {

	@Autowired
	UserService userService;

	/**
	 * 查询
	 * @param map
	 * @param user
	 * @return
	 */
	@RequestMapping("get")
	public String get(Map<String, Object> map) {
		userService.get(map);
		return "user/list";
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("del")
	public String del(Integer id) {
		userService.del(id);
		return "true";
	}
	/**
	 * 增加
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping("add")
	public String add(User user) {
		userService.add(user);
		return "true";
	}
	/**
	 * 修改
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping("update")
	public String update(User user) {
		userService.update(user);
		return "true";
	}
	/**
	 * 跳转到更新页面
	 * @param user
	 * @return
	 */
	@RequestMapping("toUpdate")
	public String toUpdate(Map<String, Object> map, Integer id) {
		userService.getById(id, map);
		return "user/update";
	}
	/**
	 * 跳转到添加页面
	 * @param user
	 * @return
	 */
	@RequestMapping("toAdd")
	public String toAdd() {
		return "user/add";
	}
}
