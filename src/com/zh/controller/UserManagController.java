package com.zh.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.zh.base.BaseController;
import com.zh.pojo.User;
import com.zh.service.UserManageService;


@Controller
@RequestMapping("/user")
public class UserManagController extends BaseController {

	@Autowired
	UserManageService service;

	@RequestMapping("getUser")
	public String findUser(User user) {
		List<User> list=service.findUser(user);
		return "main";
	}
}
