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
import com.zh.pojo.Consult;
import com.zh.pojo.User;
import com.zh.service.AdminService;
import com.zh.service.ConsultService;
import com.zh.service.UserService;

/**
 * 咨询
 * @author 赵赫
 *
 */
@Controller
@RequestMapping("/consult")
public class ConsultController extends BaseController {

	@Autowired
	ConsultService consultService;

	/**
	 * 查询
	 * @param map
	 * @param consult
	 * @return
	 */
	@RequestMapping("get")
	public String get(Map<String, Object> map) {
		consultService.get(map);
		return "consult/list";
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("del")
	public String del(Integer id) {
		consultService.del(id);
		return "true";
	}
	/**
	 * 增加
	 * @param consult
	 * @return
	 */
	@ResponseBody
	@RequestMapping("add")
	public String add(Consult consult) {
		consultService.add(consult);
		return "true";
	}
	/**
	 * 修改
	 * @param consult
	 * @return
	 */
	@ResponseBody
	@RequestMapping("update")
	public String update(Consult consult) {
		consultService.update(consult);
		return "true";
	}
	/**
	 * 跳转到更新页面
	 * @param consult
	 * @return
	 */
	@RequestMapping("toUpdate")
	public String toUpdate(Map<String, Object> map, Integer id) {
		consultService.getById(id, map);
		return "consult/update";
	}
	/**
	 * 跳转到添加页面
	 * @param consult
	 * @return
	 */
	@RequestMapping("toAdd")
	public String toAdd() {
		return "consult/add";
	}
}
