package com.zh.util;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zh.glob.GolbParams;

/**
 * @描述 String字符串工具类
 * @author  
 * @版本 V1.0.0
 * @日期 2017-6-6
 */
public class StrUtils {

	/**
	 * @描述 去除换行<br>
	 * @param str
	 * @return
	 * @author  
	 * @版本 v1.0.0
	 * @日期 2017-6-9
	 */
	public static String trimEnter(String str){
		Pattern p = Pattern.compile("\\s*|\t|\r|\n");
		Matcher m = p.matcher(str);
		String dest = m.replaceAll("");
		return dest;
	}
	
	/**
	 * @描述 字符串空值判断<br>
	 * @param str 字符串
	 * @return 是否为空
	 * @author  
	 * @版本 v1.0.0
	 * @日期 2017-6-12
	 */
	public static boolean isBlank(String str){
		if(str==null || "".equals(str.trim())){
			return true;
		}
		return false;
	}
	
	/**
	 * @描述 获取随机数<br>
	 * @param len 随机数长度
	 * @return 随机数
	 * @author  
	 * @版本 v1.0.0
	 * @日期 2017-6-27
	 */
	public static String getCode(int len){
		Random ran = new Random();
		StringBuffer str = new StringBuffer();
		for(int i=0;i<len;i++){
			str.append(GolbParams.ROUND_NUM[ran.nextInt(len)]);
		}
		return str.toString();
	}
	
	/**
	 * @描述 对象格式化为JSON<br>
	 * @param obj 返回值对象
	 * @return JSON 字符串
	 * @author  
	 * @版本 v1.0.0
	 * @日期 2017-6-28
	 */	
	public static String response(Object obj){
		JSONObject json = (JSONObject) JSON.toJSON(obj);
		return json.toJSONString();
	}
	
	/**
	 * @描述 判空<br>
	 * @param str
	 * @return
	 * @author  
	 * @版本 v1.0.0
	 * @日期 2017-7-4
	 */
	public static boolean checkNull(String str){
		if(str==null || "".equals(str.trim())|| str.length()==0){
			return true;
		}else{
			return false;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(getCode(8));
	}
}
