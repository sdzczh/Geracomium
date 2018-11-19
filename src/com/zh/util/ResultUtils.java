package com.zh.util;

import com.alibaba.fastjson.JSONObject;
import com.zh.glob.ResponseParam;


/**
 * @描述 返回工具<br>
 * @author 陈之晶
 * @版本 v1.0.0
 * @日期 2017-6-9
 */
public class ResultUtils {

	/**
	 * @描述 成功JSON<br>
	 * @param json
	 * @return
	 * @author 陈之晶
	 * @版本 v1.0.0
	 * @日期 2017-6-9
	 */
	public static String jsonSuccess(String json){
		return "{\"result\":\"ok\",\"data\":"+json+"}";
	}
	/**
	 * @描述 失败JSON<br>
	 * @param json
	 * @return
	 * @author 陈之晶
	 * @版本 v1.0.0
	 * @日期 2017-6-9
	 */
	public static String jsonError(String msg){
		return "{\"result\":\"fail\",\"msg\":\""+msg+"\"}";
	}
	
	/**
	 * @描述 格式化返回值对象<br>
	 * @param responseParam 返回值对象
	 * @return JSON格式字符串
	 * @author 陈之晶
	 * @版本 v1.0.0
	 * @日期 2017-6-21
	 */
	public static String response(ResponseParam responseParam){
		JSONObject json = (JSONObject) JSONObject.toJSON(responseParam);
		return json.toJSONString();
	}
	
	public static String responseError(String msg){
		ResponseParam responseParam = new ResponseParam();
		responseParam.setResult("fail");
		responseParam.setMsg(msg);
		JSONObject json = (JSONObject) JSONObject.toJSON(responseParam);
		return json.toJSONString();
	}
}
