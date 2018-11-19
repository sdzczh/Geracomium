package com.zh.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @描述 MD5加密
 * @author 陈之晶
 * @版本 V1.0.0
 * @日期 2017-6-6
 */
public class MD5Utils {
	
	/**
	 * @描述 MD5加密<br>
	 * @param text 加密内容
	 * @return MD5加密值
	 * @版本 v1.0.0
	 * @日期 2017-6-6
	 */
	public static String getMd5(String text) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(text.getBytes());
			byte[] b = md.digest();

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				int i = b[offset];
				if (i < 0) {
					i += 256;
				}
				if (i < 16) {
					buf.append("0");
				}
				buf.append(Integer.toHexString(i));
			}
			return buf.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @描述 测试工具方法<br>
	 * @param args
	 * @版本 v1.0.0
	 * @日期 2017-6-6
	 */
	public static void main(String[] args) {
		System.out.println(getMd5("antadmin"));
	}
}
