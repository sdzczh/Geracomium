package com.zh.glob;

/**
 * @描述 
 * @版本 V1.0.0 
 * @日期 2017-6-6
 */
public class GolbParams{
	
	/**
	 * 字符编码
	 */
	public static final String UTF8 = "UTF-8";
	
	/**
	 * 返回类型
	 */
	public static final String APPLICATION_JSON = "application/json";
	
	/**
	 * 返回格式
	 */
	public static final String CONTENT_TYPE_TEXT_JSON = "text/json";
	
	/**
	 * 向量
	 */
	public static final String PWD_KEY = "com.!@#ant#@!";
	
	/**
	 * DES
	 */
	public static final String DES="DES";
	
	/**
	 * 管理员信息在Session中的Key值
	 */
	public static final String Manager="manager";
	
	/**
	 * 会员用户信息在Session中的Key值
	 */
	public static final String USER="user";
	
	/**
	 * 服务器出错
	 */
	public static final String SERVER_ERROR="the server has an error";
	
	/**
	 * JSON提示——参数为空
	 */
	public static final String MSG_JSON_ISNULL="json is null";
	/**
	 * JSON提示——账号或密码为空
	 */
	public static final String MSG_ACCOUNT_PWD_ISNULL="username or password is null";
	
	/**
	 * JSON提示——账号或密码错误
	 */
	public static final String MSG_ACCOUNT_PWD_FAIL="username or password is error";

	/**
	 * JSON提示——密码修改——密码错误
	 */
	public static final String MSG_PWD_FAIL="the password is error";
	
	/**
	 * 参数为空
	 */
	public static final String MSG_PARAMS_ERROR="param is null";
	
	/**
	 * 资金不足
	 */
	public static final String MSG_CAPITAL_ERROR="Insufficient funds";
	
	/**
	 * 文件上传路径
	 */
	public static final String FILE_UPLOAD_PATH="/uploadfile";
	
	/**
	 * 随机数
	 */
	public static final String[] ROUND_NUM={"1","2","3","4","5","6","7","8","9","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	
	/**
	 * 用户默认密码
	 */
	public static final String USER_PASSWORD_DEFAULT="21232f297a57a5a743894a0e4a801fc3";
	
	/**
	 * 短信验证码获取地址
	 */
	public static final String SMS_VALIDATE_SERVER_URL="https://api.netease.im/sms/sendcode.action";
	
	/**
	 * 短信验证码获取地址
	 */
	public static final String SMS_NOTICE_SERVER_URL="https://api.netease.im/sms/sendtemplate.action";
	
	
	
}