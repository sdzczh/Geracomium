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
import com.zh.pojo.BedType;
import com.zh.pojo.Info;
import com.zh.pojo.User;
import com.zh.service.AdminService;
import com.zh.service.BedService;
import com.zh.service.BedTypeService;
import com.zh.service.InfoService;
import com.zh.service.UserService;
import com.zh.util.DateUtils;

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
	@Autowired
	UserService userService;
	@Autowired
	BedTypeService bedTypeService;
	@Autowired
	BedService bedService;

	/**
	 * 查询
	 * @param map
	 * @param info
	 * @return
	 */
	@RequestMapping("get")
	public String get(Map<String, Object> map) {
		infoService.get(map);
		return "info/list";
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
	public String add(Info info, Map<String, Object> map) {
		List<User> list = userService.getById(info.getUserId(), map);
		if(list == null || list.size() == 0){
			return "false";
		}
		List<BedType> list1 = bedTypeService.getById(info.getBedId(), map);
		if(list1 == null || list1.size() == 0){
			return "error";
		}
		info.setBedId(list.get(0).getBedId());
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
	/**
	 * 结算页面
	 * @return
	 */
	@RequestMapping("toCalcul")
	public String toCalcul(Map<String, Object> map, Integer id) {
		Info info = infoService.getId(id, map);
		String create_time = info.getCreate_time();
		String exit_time = info.getExit_time();
		Integer num = DateUtils.differentDays(DateUtils.strToDate(create_time), DateUtils.strToDate(exit_time));
		Integer bedId = info.getBedId();
		BigDecimal amount = bedTypeService.getPriceByBedId(bedId);
		List<User> list = userService.getById(info.getUserId(), map);
		map.put("create_time", create_time);
		map.put("exit_time", exit_time);
		map.put("name", list.get(0).getName());
		map.put("id", info.getUserId());
		map.put("bedId", info.getBedId());
		map.put("price", amount);
		map.put("num", num);
		map.put("amount", amount.multiply(new BigDecimal(num)));
		return "info/calcul";
	}
}
