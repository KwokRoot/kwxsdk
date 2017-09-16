package com.kwok.util;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.kwok.config.AppConfig;

public class WXUtil {
	
	/**
	 * 接入验证 signature 方法
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @return boolean
	 */
	public static boolean CheckSign(String signature, String timestamp ,String nonce){
		
		String[] array = new String[] { AppConfig.token, timestamp, nonce };
		StringBuffer sb = new StringBuffer();
		//字符串排序
		Arrays.sort(array);
		
		for (int i = 0; i < array.length; i++) {
			sb.append(array[i]);
		}
		
		String newSignature = DigestUtils.sha1Hex(sb.toString());
		
		if(signature.equals(newSignature)){
			return true;
		}else{
			return false;
		}
	}
	
	
	/**
	 * xml 文档字符串转 Map
	 * @param xmlStr
	 * @return Map
	 */
	@SuppressWarnings("unchecked")
	public static Map<String,String> xmlToMap(String xmlStr) {
		Map<String,String>map=new HashMap<String,String>();
		SAXReader reader=new SAXReader();	
		
		List<Element> list=new ArrayList<Element>();
		try {
			Document doc=reader.read(new ByteArrayInputStream(xmlStr.getBytes("UTF-8")));	
			Element root =doc.getRootElement();
			list = root.elements();
		} catch (UnsupportedEncodingException e) {
			System.err.println("接收 xml 编码 Error.");
			e.printStackTrace();
		} catch (DocumentException e) {
			System.err.println("xmlToMap Error.");
			e.printStackTrace();
		}	
		
		for(Element e:list){
			map.put(e.getName(),e.getText());	
		}
		return map;	
	}
	
}
