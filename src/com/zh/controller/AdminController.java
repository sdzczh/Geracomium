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
import com.zh.pojo.User;
import com.zh.service.AdminService;
import com.zh.service.UserService;


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
	@ResponseBody
	@RequestMapping("login")
	public String adminLogin(Admin admin) {
		List<Admin> list=adminService.login(admin);
		if(list == null || list.size() == 0){
			return "false";
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
	/**
	 * 修改密码
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("update")
	public String update(Admin admin, String new1) {
		List<Admin> list=adminService.login(admin);
		if(list == null || list.size() == 0){
			return "false";
		}
		adminService.update(admin);
		return "true";
	}
	@RequestMapping("toUpdate")
	public String toUpdate() {
		return "update";
	}
	@RequestMapping("main")
	public String main(HttpSession session) {
		Object admin = session.getAttribute("admin");
		if(admin == null){
			return "login";
		}
		return "main";
	}
}
