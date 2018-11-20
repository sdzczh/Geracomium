package com.zh.controller;

import java.math.BigDecimal;
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
import com.zh.pojo.Device;
import com.zh.pojo.Info;
import com.zh.pojo.Nurse;
import com.zh.pojo.User;
import com.zh.service.AdminService;
import com.zh.service.BedTypeService;
import com.zh.service.DeviceService;
import com.zh.service.InfoService;
import com.zh.service.NurseService;
import com.zh.service.UserAdminService;
import com.zh.service.UserService;
import com.zh.util.DateUtils;
import com.zh.util.StrUtils;

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
	@Autowired
	UserService userService;
	@Autowired
	InfoService infoService;
	@Autowired
	DeviceService deviceService;
	@Autowired
	NurseService nurseService;
	@Autowired
	BedTypeService bedTypeService;

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
		session.setAttribute("user", user1);
		return "true";
	}

	/**
	 * 修改密码
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("update")
	public String update(User user, HttpSession session, String new1) {
		List<User> list=userAdminService.login(user);
		if(list == null || list.size() == 0){
			return "false";
		}
		userAdminService.update(user, new1);
		return "true";
	}
	@RequestMapping("toUpdate")
	public String toUpdate(Integer id, Map<String, Object> map) {
		List<User> list = userService.getById(id, map);
		map.put("data", list.get(0));
		return "userAdmin/update";
	}
	@RequestMapping("userLogin")
	public String userLogin() {
		return "userLogin";
	}
	@RequestMapping("main")
	public String main(HttpSession session, Map<String, Object> map) {
		User user = (User) session.getAttribute("user");
		Info info = infoService.getByUserId(user.getId());
		String create_time = info.getCreate_time();
		String exit_time = info.getExit_time();
		Integer num = null;
		if(StrUtils.isBlank(exit_time)){
			num = DateUtils.differentDays(DateUtils.strToDate(create_time), DateUtils.getCurrentDate());
			map.put("active", "入住中");
		}else{
			num = DateUtils.differentDays(DateUtils.strToDate(create_time), DateUtils.strToDate(exit_time));
			map.put("active", "已结束入住");
		}
		BigDecimal amount = bedTypeService.getPriceByBedId(user.getBedId());
		map.put("num", num);
		map.put("price", amount);
		map.put("amount", amount.multiply(new BigDecimal(num)));
		map.put("data", user);
		return "userAdmin/main";
	}
	@RequestMapping("device")
	public String toDevice(Map<String, Object> map) {
		User user = (User) session.getAttribute("user");
		Device device = deviceService.getByUserId(user.getId());
		if(device != null){
			map.put("name", device.getName());
			map.put("state", device.getState() == 0 ? "未使用" : "已使用");
			map.put("create_time", device.getCreate_time());
		}
		return "userAdmin/device";
	}
	@RequestMapping("nurse")
	public String toNurse(Map<String, Object> map) {
		User user = (User) session.getAttribute("user");
		Nurse nurse = nurseService.getByUserId(user.getId());
		if(nurse != null){
			map.put("name", nurse.getName());
			map.put("create_time", nurse.getCreate_time());
		}
		return "userAdmin/nurse";
	}
}
