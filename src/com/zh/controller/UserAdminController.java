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
import com.zh.service.UserAdminService;
import com.zh.service.UserService;

/**
 * 用户后台
 * @author 赵赫
 *
 */
@Controller
@RequestMapping("/userAdmin")
public class UserAdminController extends BaseController {

	@Autowired
	UserAdminService userAdminService;

	/**
	 * 登录
	 * @param admin
	 * @return
	 */
	@ResponseBody
	@RequestMapping("login")
	public String adminLogin(User user) {
		List<User> list=userAdminService.login(user);
		if(list == null || list.size() == 0){
			return "false";
		}
		User user1 = list.get(0);
		session.setAttribute("admin", user1);
		return "true";
	}

	/**
	 * 修改密码
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("update")
	public String update(User user, String new1, HttpSession session) {
		List<User> list=userAdminService.login(user);
		if(list == null || list.size() == 0){
			return "false";
		}
		userAdminService.update(user, new1);
		session.invalidate();
		return "true";
	}
	@RequestMapping("toUpdate")
	public String toUpdate() {
		return "userAdmin/update";
	}
	@RequestMapping("userLogin")
	public String userLogin() {
		return "userLogin";
	}
	@RequestMapping("main")
	public String main(HttpSession session, Map<String, Object> map) {
		User user = (User) session.getAttribute("admin");
		map.put("data", user);
		return "userAdmin/main";
	}
}
