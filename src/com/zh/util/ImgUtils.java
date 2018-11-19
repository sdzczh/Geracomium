package com.zh.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
/**
 * @描述 图片加密解密<br>
 * @author 陈之晶
 * @版本 v1.0.0
 * @日期 2017-6-7
 */
public class ImgUtils {
	
	/**
	 * @描述 图片加密<br>
	 * @param imgUrl 图片地址
	 * @return 图片加密值
	 * @author 陈之晶
	 * @版本 v1.0.0
	 * @日期 2017-6-7
	 */
	public static String imgEncode(String imgUrl) {
		InputStream inputStream = null;
		byte[] data = null;
		try {
			inputStream = new FileInputStream(imgUrl);
			data = new byte[inputStream.available()];
			inputStream.read(data);
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 加密
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(data);
	}

	/**
	 * @描述 图片解密<br>
	 * @param imgCode 图片加密值
	 * @param savePath 保存地址
	 * @return 结果
	 * @author 陈之晶
	 * @版本 v1.0.0
	 * @日期 2017-6-7
	 */
	public static boolean imgDecode(String imgCode, String savePath) {
		if (imgCode == null){
			return false;
		}
			BASE64Decoder decoder = new BASE64Decoder();
			try {
			// 解密
			byte[] b = decoder.decodeBuffer(imgCode);
			// 处理数据
			for (int i = 0; i < b.length; ++i) {
			if (b[i] < 0) {
				b[i] += 256;
			}
		}
		OutputStream out = new FileOutputStream(savePath);
		out.write(b);
		out.flush();
		out.close();
		return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * @描述 工具测试方法<br>
	 * @param args
	 * @author 陈之晶
	 * @版本 v1.0.0
	 * @日期 2017-6-7
	 */
	public static void main(String[] args) {
	    String strImg = imgEncode("E:/IMG/timg.jpg");
	    System.out.println(strImg);
	    imgDecode(strImg, "E:/IMG/Test.jpg");
	}
}
