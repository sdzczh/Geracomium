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
import com.zh.pojo.BedType;
import com.zh.pojo.User;
import com.zh.service.AdminService;
import com.zh.service.BedTypeService;
import com.zh.service.UserService;

/**
 * 床类型
 * @author 赵赫
 *
 */
@Controller
@RequestMapping("/bedType")
public class BedTypeController extends BaseController {

	@Autowired
	BedTypeService bedTypeService;

	/**
	 * 查询
	 * @param map
	 * @param bedType
	 * @return
	 */
	@RequestMapping("get")
	public String get(Map<String, Object> map) {
		bedTypeService.get(map);
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
		bedTypeService.del(id);
		return "true";
	}
	/**
	 * 增加
	 * @param bedType
	 * @return
	 */
	@ResponseBody
	@RequestMapping("add")
	public String add(BedType bedType) {
		bedTypeService.add(bedType);
		return "true";
	}
	/**
	 * 修改
	 * @param bedType
	 * @return
	 */
	@ResponseBody
	@RequestMapping("update")
	public String update(BedType bedType) {
		bedTypeService.update(bedType);
		return "true";
	}
	/**
	 * 跳转到更新页面
	 * @param bedType
	 * @return
	 */
	@RequestMapping("toUpdate")
	public String toUpdate(Map<String, Object> map, Integer id) {
		bedTypeService.getById(id, map);
		return "bedType/update";
	}
	/**
	 * 跳转到添加页面
	 * @param bedType
	 * @return
	 */
	@RequestMapping("toAdd")
	public String toAdd() {
		return "bedType/add";
	}
}
