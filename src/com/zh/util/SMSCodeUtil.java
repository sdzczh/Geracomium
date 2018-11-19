package com.zh.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zh.glob.GolbParams;

/**
 * @描述 短信验证码获取工具<br>
 * @author 陈之晶
 * @版本 v1.0.0
 * @日期 2017-6-23
 */
@SuppressWarnings("deprecation")
public class SMSCodeUtil {

	/**
     * @描述 获取验证码<br>
     * @param appk 网易云信分配的账号，请替换你在管理后台应用下申请的Appkey
     * @param secret 网易云信分配的密钥，请替换你在管理后台应用下申请的appSecret
     * @param nonce 随机数 
     * @param templateId 短信模板ID
     * @param mobile 手机号码
     * @param codeLen 验证码长度，范围4～10，默认为4
     * @author 陈之晶
     * @版本 v1.0.0
     * @日期 2017-6-23
     */
    public static JSONObject getValidateCode(String appk,String secret,String nonce,String templateId,String mobile,String codeLen){
    	try {
	        DefaultHttpClient httpClient = new DefaultHttpClient();
	        HttpPost httpPost = new HttpPost(GolbParams.SMS_VALIDATE_SERVER_URL);
	        String curTime = String.valueOf((new Date()).getTime() / 1000L);
	        /*
	         * 参考计算CheckSum的java代码，在上述文档的参数列表中，有CheckSum的计算文档示例
	         */
	        String checkSum = SMSCodeCheckSumBuilder.getCheckSum(secret, nonce, curTime);
	
	        // 设置请求的header
	        httpPost.addHeader("AppKey", appk);
	        httpPost.addHeader("Nonce", nonce);
	        httpPost.addHeader("CurTime", curTime);
	        httpPost.addHeader("CheckSum", checkSum);
	        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
	
	        // 设置请求的的参数，requestBody参数
	        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
	        /*
	         * 1.如果是模板短信，请注意参数mobile是有s的，详细参数配置请参考“发送模板短信文档”
	         * 2.参数格式是jsonArray的格式，例如 "['13888888888','13666666666']"
	         * 3.params是根据你模板里面有几个参数，那里面的参数也是jsonArray格式
	         */
	        nvps.add(new BasicNameValuePair("templateid", templateId));
	        nvps.add(new BasicNameValuePair("mobile", mobile));
	        nvps.add(new BasicNameValuePair("codeLen", codeLen));
	
	        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
	
	        // 执行请求
	        HttpResponse response = httpClient.execute(httpPost);
	        /*
	         * 1.打印执行结果，打印结果一般会200、315、403、404、413、414、500
	         * 2.具体的code有问题的可以参考官网的Code状态表
	         */
	        String result = EntityUtils.toString(response.getEntity(), "utf-8");
	        JSONObject json = JSONObject.parseObject(result);
	        return json;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }
    
    /**
     * @描述 发送通知类短信<br>
     * @param appk 网易云信分配的账号，请替换你在管理后台应用下申请的Appkey
     * @param secret 网易云信分配的密钥，请替换你在管理后台应用下申请的appSecret
     * @param nonce 随机数 
     * @param templateId 短信模板ID
     * @param phones 手机号码集合
     * @param hour 小时数
     * @param dateTime 日期
     * @return
     * @author 陈之晶
     * @版本 v1.0.0
     * @日期 2017-6-26
     */
    public static String sendNotice(String appk,String secret,String nonce,String templateId,List<String> phones,String hour,String dateTime){
    	try {
    		DefaultHttpClient httpClient = new DefaultHttpClient();
    		HttpPost httpPost = new HttpPost(GolbParams.SMS_NOTICE_SERVER_URL);
    		String curTime = String.valueOf((new Date()).getTime() / 1000L);
    		/*
    		 * 参考计算CheckSum的java代码，在上述文档的参数列表中，有CheckSum的计算文档示例
    		 */
    		String checkSum = SMSCodeCheckSumBuilder.getCheckSum(secret, nonce, curTime);
    		
    		// 设置请求的header
    		httpPost.addHeader("AppKey", appk);
    		httpPost.addHeader("Nonce", nonce);
    		httpPost.addHeader("CurTime", curTime);
    		httpPost.addHeader("CheckSum", checkSum);
    		httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
    		
    		// 设置请求的的参数，requestBody参数
    		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
    		/*
    		 * 1.如果是模板短信，请注意参数mobile是有s的，详细参数配置请参考“发送模板短信文档”
    		 * 2.参数格式是jsonArray的格式，例如 "['13888888888','13666666666']"
    		 * 3.params是根据你模板里面有几个参数，那里面的参数也是jsonArray格式
    		 */
    		nvps.add(new BasicNameValuePair("templateid", templateId));

    		JSONArray userPhones = (JSONArray) JSON.toJSON(phones);
    		nvps.add(new BasicNameValuePair("mobiles", userPhones.toJSONString()));
    		
    		JSONArray params = new JSONArray();
    		params.add(dateTime);
    		params.add(hour);
    		nvps.add(new BasicNameValuePair("params", params.toJSONString()));
    		
    		httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
    		
    		// 执行请求
    		HttpResponse response = httpClient.execute(httpPost);
    		/*
    		 * 1.打印执行结果，打印结果一般会200、315、403、404、413、414、500
    		 * 2.具体的code有问题的可以参考官网的Code状态表
    		 */
    		String result = EntityUtils.toString(response.getEntity(), "utf-8");
    		JSONObject json = JSONObject.parseObject(result);
    		return json.getString("code");
    	} catch (Exception e) {
    		e.printStackTrace();
    		return null;
    	}
    }
}