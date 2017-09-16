package com.kwok.config;

import java.io.IOException;
import java.util.Properties;

/**
 * 从配置文件中加载 App 配置参数
 * @author Kwok
 */
public class AppConfigProperties {

	private static String AppID;
	private static String AppSecret;
	private static String token;
	private static String EncodingAESKey;
	
	public AppConfigProperties(String filePath) {
		
		Properties prop = new Properties();
		
		try {
			prop.load(ClassLoader.getSystemResourceAsStream(filePath));
		} catch (IOException e) {
			System.err.println("Properties 加载配置文件路径有误。");
			e.printStackTrace();
		}
		
		AppID = prop.getProperty("AppID");
		AppSecret = prop.getProperty("AppSecret");
		token = prop.getProperty("token");
		EncodingAESKey = prop.getProperty("EncodingAESKey");
		
	}

	public String getAppID(){
		return AppID;
	}
	
	public String getAppSecret(){
		return AppSecret;
	}
	
	public String getToken(){
		return token;
	}
	
	public String getEncodingAESKey(){
		return EncodingAESKey;
	}
	
	public static void main(String[] args) {
		System.out.println(new AppConfigProperties("conf/app.properties").getAppID());
	}
	
}
