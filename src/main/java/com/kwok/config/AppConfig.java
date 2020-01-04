package com.kwok.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AppConfig {
	
	public static String AppID;
	public static String AppSecret;
	public static String token;
	public static String EncodingAESKey;
	
	static {
		
		Properties prop = new Properties();
		
		try {
			
			String confFilePath = Thread.currentThread().getContextClassLoader().getResource("conf/app.properties").getPath();
			System.out.println("------ 加载配置文件路径 : " + confFilePath + " ------");
			
			prop.load(new FileInputStream(confFilePath));
			
		} catch (IOException e) {
			System.err.println("app.properties 配置文件加载有误！");
			e.printStackTrace();
		}
		
		AppID = prop.getProperty("AppID");
		AppSecret = prop.getProperty("AppSecret");
		token = prop.getProperty("token");
		EncodingAESKey = prop.getProperty("EncodingAESKey");
		
	}
	
}
