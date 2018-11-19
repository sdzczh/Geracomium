package com.zh.util;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * @描述 properties文件加密解密<br>
 * @author 陈之晶
 * @版本 v1.0.0
 * @日期 2017-6-7
 */
public class EncryptPropertyPlaceholderConfigurer extends
		PropertyPlaceholderConfigurer {

	private static final  Logger logger = LoggerFactory.getLogger(EncryptPropertyPlaceholderConfigurer.class);
	
	@Override
	protected void processProperties(
			ConfigurableListableBeanFactory beanFactoryToProcess,
			Properties props) throws BeansException {
		
		String username =  props.getProperty("username");  
		String password = props.getProperty("password");  
		  
        if (password != null) {
            
            String strPwd = "" ; 
            String strUserName = "";
			try {
				strUserName = DES.decrypt(username);
				strPwd = DES.decrypt(password);
			} catch (Exception e) {
				logger.error(e.getMessage());
				//if (SysConstant.debug) {
					e.printStackTrace();
				//}				
			}
            
            props.setProperty("password", strPwd);
            props.setProperty("username", strUserName);  
        }
        
	        
		super.processProperties(beanFactoryToProcess, props);
	}
	public static void main(String[] args) throws Exception {
		System.out.println(DES.encrypt("antuser"));
		System.out.println(DES.encrypt("ant!@#"));
	}
}
