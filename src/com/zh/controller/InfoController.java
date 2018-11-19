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
import com.zh.pojo.Info;
import com.zh.pojo.User;
import com.zh.service.AdminService;
import com.zh.service.InfoService;
import com.zh.service.UserManageService;

/**
 * 住院信息
 * @author 赵赫
 *
 */
@Controller
@RequestMapping("/info")
public class InfoController extends BaseController {

	@Autowired
	InfoService infoService;

	/**
	 * 查询
	 * @param map
	 * @param info
	 * @return
	 */
	@RequestMapping("getInfo")
	public String get(Map<String, Object> map) {
		infoService.get(map);
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
		infoService.del(id);
		return "true";
	}
	/**
	 * 增加
	 * @param info
	 * @return
	 */
	@ResponseBody
	@RequestMapping("add")
	public String add(Info info) {
		infoService.add(info);
		return "true";
	}
	/**
	 * 修改
	 * @param info
	 * @return
	 */
	@ResponseBody
	@RequestMapping("update")
	public String update(Info info) {
		infoService.update(info);
		return "true";
	}
	/**
	 * 跳转到更新页面
	 * @param info
	 * @return
	 */
	@RequestMapping("toUpdate")
	public String toUpdate(Map<String, Object> map, Integer id) {
		infoService.getById(id, map);
		return "info/update";
	}
	/**
	 * 跳转到添加页面
	 * @param info
	 * @return
	 */
	@RequestMapping("toAdd")
	public String toAdd() {
		return "info/add";
	}
}
