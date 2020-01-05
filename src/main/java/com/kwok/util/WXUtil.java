package com.kwok.util;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.codec.digest.DigestUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.kwok.config.AppConfig;

/**
 * 与微信项目开发密切的工具类
 * @author Kwok
 */
public class WXUtil {
	
	/**
	 * 接入验证 signature 方法
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @return boolean
	 */
	public static boolean CheckSign(String signature, String timestamp ,String nonce){
		
		String[] array = new String[] { AppConfig.token_B, timestamp, nonce };
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
	
	
	/**
	  * @MethodName getAccessToken 
	  * @Description 向微信中控服务器获取 AccessToken 
	  * @return String 
	  * @throws 
	  * @date 2017年9月30日 下午3:42:39
	  * @author Kwok
	 * @throws Exception 
	  **/
	public static String getAccessToken() throws Exception{
		
		String randomStr = CommonsUtil.getRandomStr(6);
		String reqParam = "?randomStr=" + randomStr + "&signature=" + CommonsUtil.getSha1(randomStr + AppConfig.token_B);
		String accessToken = null;
		try {
			accessToken = CommonsUtil.getRequest(AppConfig.urlGlobal + "/kwxsdk-global/getAccessToken" + reqParam);
		} catch (Exception e) {
			System.err.println("向微信中控服务器获取 AccessToken 错误！");
			e.printStackTrace();
		}
		
		return accessToken;
		
	}
	
	
	/**
	  * @MethodName getJsApiTicket
	  * @Description 向微信中控服务器获取 JsApiTicket 
	  * @return String 
	  * @throws 
	  * @date 2018年3月1日 下午12:49:28
	  * @author Kwok
	 * @throws Exception 
	  **/
	public static String getJsApiTicket() throws Exception{
		
		String randomStr = CommonsUtil.getRandomStr(6);
		String reqParam = "?randomStr=" + randomStr + "&signature=" + CommonsUtil.getSha1(randomStr + AppConfig.token_B);
		String apiTicket = null;
		try {
			apiTicket = CommonsUtil.getRequest(AppConfig.urlGlobal + "/kwxsdk-global/getJsApiTicket" + reqParam);
		} catch (Exception e) {
			System.err.println("向微信中控服务器获取 ApiTicket 错误！");
			e.printStackTrace();
		}
		
		return apiTicket;
		
	}
	
	
	/**
	  * @MethodName getSha1Signature
	  * @Description 参数按照 Key 的 ASCII 码从小到大排序（字典序）后，再进行sha1签名。
	  * @param data
	  * @return String 
	  * @throws 
	  * @date 2018年3月1日 下午2:18:51
	  * @author Kwok
	 * @throws Exception 
	  **/
	public static String getSha1Signature(Map<String, String> data) throws Exception {

		Set<String> keySet = data.keySet();
		String[] keyArray = keySet.toArray(new String[keySet.size()]);
		Arrays.sort(keyArray);
		StringBuilder sb = new StringBuilder();
		for (String k : keyArray) {
			if (data.get(k)!=null && data.get(k).trim().length() > 0) {
				// 参数值为空，则不参与签名
				sb.append(k).append("=").append(data.get(k).trim()).append("&");
			}
		}
		return CommonsUtil.getSha1(sb.toString().substring(0, sb.length() - 1));
	}
	
}
