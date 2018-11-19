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
import com.zh.pojo.Out;
import com.zh.pojo.User;
import com.zh.service.AdminService;
import com.zh.service.OutService;
import com.zh.service.UserService;

/**
 * 外出登记
 * @author 赵赫
 *
 */
@Controller
@RequestMapping("/out")
public class OutController extends BaseController {

	@Autowired
	OutService outService;

	/**
	 * 查询
	 * @param map
	 * @param out
	 * @return
	 */
	@RequestMapping("getOut")
	public String get(Map<String, Object> map) {
		outService.get(map);
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
		outService.del(id);
		return "true";
	}
	/**
	 * 增加
	 * @param out
	 * @return
	 */
	@ResponseBody
	@RequestMapping("add")
	public String add(Out out) {
		outService.add(out);
		return "true";
	}
	/**
	 * 修改
	 * @param out
	 * @return
	 */
	@ResponseBody
	@RequestMapping("update")
	public String update(Out out) {
		outService.update(out);
		return "true";
	}
	/**
	 * 跳转到更新页面
	 * @param out
	 * @return
	 */
	@RequestMapping("toUpdate")
	public String toUpdate(Map<String, Object> map, Integer id) {
		outService.getById(id, map);
		return "out/update";
	}
	/**
	 * 跳转到添加页面
	 * @param out
	 * @return
	 */
	@RequestMapping("toAdd")
	public String toAdd() {
		return "out/add";
	}
}
