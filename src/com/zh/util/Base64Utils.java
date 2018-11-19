package com.zh.util;

import java.io.UnsupportedEncodingException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import com.zh.glob.GolbParams;

/**
 * @描述 Base64加密解密
 * @版本 V1.0.0 
 * @日期 2017-6-6
 */
public class Base64Utils {
	
	/**
	 * @描述 Base64加密<br>
	 * @param text 加密内容
	 * @return Base64加密值
	 * 版本 v1.0.0
	 * 日期 2017-6-6
	 */
	public static String encoder(String text) {
		byte[] b = (byte[]) null;
		String s = null;
		try {
			b = text.getBytes(GolbParams.UTF8);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if (b != null) {
			s = new BASE64Encoder().encode(b);
		}
		return s;
	}
	
	/**
	 * @描述 Base64解密<br>
	 * @param text 解密内容
	 * @return Base64解密值
	 * @版本 v1.0.0
	 * @日期 2017-6-6
	 */
	public static String decoder(String text) {
		byte[] b = (byte[]) null;
		String result = null;
		if (text != null) {
			BASE64Decoder decoder = new BASE64Decoder();
			try {
				b = decoder.decodeBuffer(text);
				result = new String(b, GolbParams.UTF8);
			} catch (Exception e) {
				e.printStackTrace();
				return result;
			}
		}
		return result;
	}

	/**
	 * @描述 测试工具方法<br>
	 * @param args
	 * @throws UnsupportedEncodingException 
	 * @版本 v1.0.0
	 * @日期 2017-6-6
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		String text = "370830**##!@$";
		String en = encoder(text);
		System.out.println(en);
		System.out.println(decoder("YWRtaW4="));
	}
}