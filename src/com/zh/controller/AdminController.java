package com.zh.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.zh.base.BaseController;
import com.zh.pojo.Admin;
import com.zh.pojo.User;
import com.zh.service.AdminService;
import com.zh.service.UserManageService;


@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {

	@Autowired
	AdminService adminService;

	/**
	 * 登录
	 * @param admin
	 * @return
	 */
	@RequestMapping("login")
	public String adminLogin(Admin admin) {
		List<Map<String, Object>> list=adminService.login(admin);
		if(list == null || list.size() == 0){
			session.setAttribute("账号或密码错误", "result");
			return "fasle";
		}
		session.setAttribute("admin", JSON.toJSON(list.get(0)));
		return "true";
	}
	/**
	 * 退出登录
	 * @param admin
	 * @return
	 */
	@RequestMapping("exit")
	public String exit(HttpSession session) {
		session.removeAttribute("admin");
		session.invalidate();
		return "login";
	}
}
