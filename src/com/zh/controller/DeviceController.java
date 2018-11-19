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
import com.zh.pojo.Device;
import com.zh.pojo.User;
import com.zh.service.AdminService;
import com.zh.service.DeviceService;
import com.zh.service.UserService;

/**
 * 设备
 * @author 赵赫
 *
 */
@Controller
@RequestMapping("/device")
public class DeviceController extends BaseController {

	@Autowired
	DeviceService deviceService;

	/**
	 * 查询
	 * @param map
	 * @param device
	 * @return
	 */
	@RequestMapping("getDevice")
	public String get(Map<String, Object> map) {
		deviceService.get(map);
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
		deviceService.del(id);
		return "true";
	}
	/**
	 * 增加
	 * @param device
	 * @return
	 */
	@ResponseBody
	@RequestMapping("add")
	public String add(Device device) {
		deviceService.add(device);
		return "true";
	}
	/**
	 * 修改
	 * @param device
	 * @return
	 */
	@ResponseBody
	@RequestMapping("update")
	public String update(Device device) {
		deviceService.update(device);
		return "true";
	}
	/**
	 * 跳转到更新页面
	 * @param device
	 * @return
	 */
	@RequestMapping("toUpdate")
	public String toUpdate(Map<String, Object> map, Integer id) {
		deviceService.getById(id, map);
		return "device/update";
	}
	/**
	 * 跳转到添加页面
	 * @param device
	 * @return
	 */
	@RequestMapping("toAdd")
	public String toAdd() {
		return "device/add";
	}
}
