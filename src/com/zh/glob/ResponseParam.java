package com.zh.glob;

import com.alibaba.fastjson.JSON;


public class ResponseParam {
	private String result;
	private String msg;
	private Integer exist;
	private Integer orderType;
	private JSON data;
	private Double currentProfit;
	private Double afterCurrentProfit;
	private Integer amountType;
	private Integer page;
	private Integer roews;
	private Integer type;
	private Integer codeId;
	private Integer count;
	
	public Integer getCodeId() {
		return codeId;
	}
	public void setCodeId(Integer codeId) {
		this.codeId = codeId;
	}
	public Integer getAmountType() {
		return amountType;
	}
	public void setAmountType(Integer amountType) {
		this.amountType = amountType;
	}
	public Double getCurrentProfit() {
		return currentProfit;
	}
	public void setCurrentProfit(Double currentProfit) {
		this.currentProfit = currentProfit;
	}
	public Double getAfterCurrentProfit() {
		return afterCurrentProfit;
	}
	public void setAfterCurrentProfit(Double afterCurrentProfit) {
		this.afterCurrentProfit = afterCurrentProfit;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Integer getExist() {
		return exist;
	}
	public void setExist(Integer exist) {
		this.exist = exist;
	}
	public Integer getOrderType() {
		return orderType;
	}
	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}
	public JSON getData() {
		return data;
	}
	public void setData(JSON data) {
		this.data = data;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRoews() {
		return roews;
	}
	public void setRoews(Integer roews) {
		this.roews = roews;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
}
