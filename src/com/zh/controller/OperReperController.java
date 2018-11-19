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
import com.zh.pojo.OperReper;
import com.zh.pojo.User;
import com.zh.service.AdminService;
import com.zh.service.OperReperService;
import com.zh.service.UserService;

/**
 * 入库/出库
 * @author 赵赫
 *
 */
@Controller
@RequestMapping("/operReper")
public class OperReperController extends BaseController {

	@Autowired
	OperReperService operReperService;

	/**
	 * 查询
	 * @param map
	 * @param operReper
	 * @return
	 */
	@RequestMapping("get")
	public String get(Map<String, Object> map) {
		operReperService.get(map);
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
		operReperService.del(id);
		return "true";
	}
	/**
	 * 增加
	 * @param operReper
	 * @return
	 */
	@ResponseBody
	@RequestMapping("add")
	public String add(OperReper operReper) {
		operReperService.add(operReper);
		return "true";
	}
	/**
	 * 修改
	 * @param operReper
	 * @return
	 */
	@ResponseBody
	@RequestMapping("update")
	public String update(OperReper operReper) {
		operReperService.update(operReper);
		return "true";
	}
	/**
	 * 跳转到更新页面
	 * @param operReper
	 * @return
	 */
	@RequestMapping("toUpdate")
	public String toUpdate(Map<String, Object> map, Integer id) {
		operReperService.getById(id, map);
		return "operReper/update";
	}
	/**
	 * 跳转到添加页面
	 * @param operReper
	 * @return
	 */
	@RequestMapping("toAdd")
	public String toAdd() {
		return "operReper/add";
	}
}
