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
import com.zh.pojo.Diet;
import com.zh.pojo.User;
import com.zh.service.AdminService;
import com.zh.service.DietService;
import com.zh.service.UserService;

/**
 * 饮食
 * @author 赵赫
 *
 */
@Controller
@RequestMapping("/diet")
public class DietController extends BaseController {

	@Autowired
	DietService dietService;

	/**
	 * 查询
	 * @param map
	 * @param diet
	 * @return
	 */
	@RequestMapping("get")
	public String get(Map<String, Object> map) {
		dietService.get(map);
		return "diet/list";
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("del")
	public String del(Integer id) {
		dietService.del(id);
		return "true";
	}
	/**
	 * 增加
	 * @param diet
	 * @return
	 */
	@ResponseBody
	@RequestMapping("add")
	public String add(Diet diet) {
		dietService.add(diet);
		return "true";
	}
	/**
	 * 修改
	 * @param diet
	 * @return
	 */
	@ResponseBody
	@RequestMapping("update")
	public String update(Diet diet) {
		dietService.update(diet);
		return "true";
	}
	/**
	 * 跳转到更新页面
	 * @param diet
	 * @return
	 */
	@RequestMapping("toUpdate")
	public String toUpdate(Map<String, Object> map, Integer id) {
		dietService.getById(id, map);
		return "diet/update";
	}
	/**
	 * 跳转到添加页面
	 * @param diet
	 * @return
	 */
	@RequestMapping("toAdd")
	public String toAdd() {
		return "diet/add";
	}
}
