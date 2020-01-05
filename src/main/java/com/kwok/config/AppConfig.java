package com.kwok.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AppConfig {
	
	//服务号配置项
	public static String AppID_A;
	public static String AppSecret_A;
	public static String token_A;
	public static String EncodingAESKey_A;
	
	//订阅号配置项
	public static String AppID_B;
	public static String AppSecret_B;
	public static String token_B;
	public static String EncodingAESKey_B;
	
	//数据库配置项
	public static String dbDriver;
	public static String dbUrl;
	public static String dbUserName;
	public static String dbPassword;
	
	//微信中控服务器域名地址配置项
	public static String urlGlobal;
	
	static {
		
		Properties prop = new Properties();
		
		try {
			
			String confFilePath = Thread.currentThread().getContextClassLoader().getResource("app.properties").getPath();
			System.out.println("------ 加载配置文件路径 : " + confFilePath + " ------");
			
			prop.load(new FileInputStream(confFilePath));
			
		} catch (IOException e) {
			System.err.println("app.properties 配置文件加载有误！");
			e.printStackTrace();
		}
		
		AppID_A = prop.getProperty("AppID_A");
		AppSecret_A = prop.getProperty("AppSecret_A");
		token_A = prop.getProperty("token_A");
		EncodingAESKey_A = prop.getProperty("EncodingAESKey_A");
		
		AppID_B = prop.getProperty("AppID_B");
		AppSecret_B = prop.getProperty("AppSecret_B");
		token_B = prop.getProperty("token_B");
		EncodingAESKey_B = prop.getProperty("EncodingAESKey_B");
		
		dbDriver = prop.getProperty("db.driver");
		dbUrl = prop.getProperty("db.url");
		dbUserName = prop.getProperty("db.username");
		dbPassword = prop.getProperty("db.password");
		
		urlGlobal = prop.getProperty("url.global");
		
	}
	
	public static void main(String[] args) {
		
		System.out.println(AppID_A);
		System.out.println(AppID_B);
		System.out.println(dbUrl);
		System.out.println(urlGlobal);
		
	}
	
}
