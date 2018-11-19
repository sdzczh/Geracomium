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
import com.zh.pojo.Visit;
import com.zh.pojo.User;
import com.zh.service.AdminService;
import com.zh.service.VisitService;
import com.zh.service.UserService;

/**
 * 探视
 * @author 赵赫
 *
 */
@Controller
@RequestMapping("/visit")
public class VisitController extends BaseController {

	@Autowired
	VisitService visitService;

	/**
	 * 查询
	 * @param map
	 * @param visit
	 * @return
	 */
	@RequestMapping("get")
	public String get(Map<String, Object> map) {
		visitService.get(map);
		return "visit/list";
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("del")
	public String del(Integer id) {
		visitService.del(id);
		return "true";
	}
	/**
	 * 增加
	 * @param visit
	 * @return
	 */
	@ResponseBody
	@RequestMapping("add")
	public String add(Visit visit) {
		visitService.add(visit);
		return "true";
	}
	/**
	 * 修改
	 * @param visit
	 * @return
	 */
	@ResponseBody
	@RequestMapping("update")
	public String update(Visit visit) {
		visitService.update(visit);
		return "true";
	}
	/**
	 * 跳转到更新页面
	 * @param visit
	 * @return
	 */
	@RequestMapping("toUpdate")
	public String toUpdate(Map<String, Object> map, Integer id) {
		visitService.getById(id, map);
		return "visit/update";
	}
	/**
	 * 跳转到添加页面
	 * @param visit
	 * @return
	 */
	@RequestMapping("toAdd")
	public String toAdd() {
		return "visit/add";
	}
}
