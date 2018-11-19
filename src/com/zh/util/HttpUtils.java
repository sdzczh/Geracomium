package com.zh.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import com.zh.glob.GolbParams;


/**
 * @描述 Http请求工具类
 * @author 陈之晶
 * @版本 V1.0.0
 * @日期 2017-6-6
 */
public class HttpUtils {
	
	/**
	 * @描述 POST请求<br>
	 * @param url 请求地址
	 * @param json 参数(JSON格式)
	 * @return 返回值
	 * @版本 v1.0.0
	 * @日期 2017-6-6
	 */
	public static String postWithJson(String url, String json) {
		String result = "";
		String encoderJson = null;
		try {
			encoderJson = URLEncoder.encode(json,GolbParams.UTF8);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		httpPost.addHeader("Content-Type",GolbParams.APPLICATION_JSON);

		StringEntity se = null;
		try {
			se = new StringEntity(encoderJson);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		se.setContentType(GolbParams.CONTENT_TYPE_TEXT_JSON);
		se.setContentEncoding(new BasicHeader("Content-Type", GolbParams.APPLICATION_JSON));
		httpPost.setEntity(se);
		CloseableHttpResponse respon = null;
		try {
			respon = httpClient.execute(httpPost);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (respon.getStatusLine().getStatusCode() == 200) {
			HttpEntity httpEntity = respon.getEntity();
			try {
				result = EntityUtils.toString(httpEntity);
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;		
	}
	
	/**
	 * @描述 GET请求<br>
	 * @param url 请求地址
	 * @param param 参数
	 * @return 返回值
	 * @版本 v1.0.0
	 * @日期 2017-6-6
	 */
	public static String get(String url, String param) {
		String result = "";
		BufferedReader in = null;
		try {
			String urlName = url + "?" + param;
			URL realUrl = new URL(urlName);

			URLConnection conn = realUrl.openConnection();

			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
			conn.connect();
			Map<String, List<String>> map = conn.getHeaderFields();
			for (String key : map.keySet()) {
				System.out.println(key + "--->" + map.get(key));
			}
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result = result + "/n" + line;
			}
		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}
}
