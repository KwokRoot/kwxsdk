package com.kwok.model;

public class ResXmlMsgTpl {
	
	/**
	 * 回复文本消息模版
	 */
	public static String textMsgTpl=
			"<xml>\n"
			+ "<ToUserName><![CDATA[%1$s]]></ToUserName>\n"
			+ "<FromUserName><![CDATA[%2$s]]></FromUserName>\n"
			+ "<CreateTime>%3$s</CreateTime>\n"
			+ "<MsgType><![CDATA[text]]></MsgType>\n"
			+ "<Content><![CDATA[%4$s]]></Content>\n"
			+ "</xml>";
	
	
}
