package com.kwok.test;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 该练习是对 URL 编码、解码的练习。
 * @author Kwok
 */
public class Test_URLEncode {
	
	public static void main(String[] args) throws Exception {
		
		String originalUrl = "https://www.kwok.com/kweixin-oauth";
		String encodeUrl = URLEncoder.encode(originalUrl, "UTF-8");
		System.out.println(encodeUrl);
		System.out.println(URLDecoder.decode(encodeUrl, "UTF-8"));
		
	}
	
}
