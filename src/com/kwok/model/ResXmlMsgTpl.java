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
	
	/**
	 * 回复图片消息模版
	 */
	public static String imageMsgTpl=
			"<xml>\n"
			+ "<ToUserName><![CDATA[%1$s]]></ToUserName>\n"
			+ "<FromUserName><![CDATA[%2$s]]></FromUserName>\n"
			+ "<CreateTime>%3$s</CreateTime>\n"
			+ "<MsgType><![CDATA[image]]></MsgType>\n"
			+ "<Image><MediaId><![CDATA[%4$s]]></MediaId></Image>\n"
			+ "</xml>";
	
	/**
	 * 回复语音消息模版
	 */
	public static String voiceMsgTpl=
			"<xml>\n"
		    + "<ToUserName><![CDATA[%1$s]]></ToUserName>\n"
		    + "<FromUserName><![CDATA[%2$s]]></FromUserName>\n"
		    + "<CreateTime>%3$s</CreateTime>\n"
		    + "<MsgType><![CDATA[voice]]></MsgType>\n"
		    + "<Voice><MediaId><![CDATA[%4$s]]></MediaId></Voice>\n"
		    + "</xml>";
	
	/**
	 * 回复视频消息模版
	 */
	public static String videoMsgTpl=
			"<xml>\n"
		    + "<ToUserName><![CDATA[%1$s]]></ToUserName>\n"
		    + "<FromUserName><![CDATA[%2$s]]></FromUserName>\n"
		    + "<CreateTime>%3$s</CreateTime>\n"
		    + "<MsgType><![CDATA[video]]></MsgType>\n"
		    + "<Video>\n"
		    + "<MediaId><![CDATA[%4$s]]></MediaId>\n"
		    + "<Title><![CDATA[%5$s]]></Title>\n"
		    + "<Description><![CDATA[%6$s]]></Description>\n"
		    + "</Video>\n"
		    + "</xml>";
	
	/**
	 * 回复音乐消息模版
	 */
	public static String musicMsgTpl=
			"<xml>\n"
		    + "<ToUserName><![CDATA[%1$s]]></ToUserName>\n"
		    + "<FromUserName><![CDATA[%2$s]]></FromUserName>\n"
		    + "<CreateTime>%3$s</CreateTime>\n"
		    + "<MsgType><![CDATA[music]]></MsgType>\n"
		    + "<Music>\n"
		    + "<Title><![CDATA[%4$s]]></Title>\n"
		    + "<Description><![CDATA[%5$s]]></Description>\n"
		    + "<MusicUrl><![CDATA[%6$s]]></MusicUrl>\n"
		    + "<HQMusicUrl><![CDATA[%7$s]]></HQMusicUrl>\n"
		    + "<ThumbMediaId><![CDATA[%8$s]]></ThumbMediaId>\n"
		    + "</Music>\n"
		    + "</xml>";
	
	/**
	 * 回复图文消息模版
	 */
	public static String newsMsgTpl=
			"<xml>\n"
		    + "<ToUserName><![CDATA[%1$s]]></ToUserName>\n"
		    + "<FromUserName><![CDATA[%2$s]]></FromUserName>\n"
		    + "<CreateTime>%3$s</CreateTime>\n"
		    + "<MsgType><![CDATA[news]]></MsgType>\n"
		    + "<ArticleCount>%4$s</ArticleCount>\n"
		    + "<Articles>\n"
		    + "<item>\n"
		    + "<Title><![CDATA[%5$s]]></Title>\n"
		    + "<Description><![CDATA[%6$s]]></Description>\n"
		    + "<PicUrl><![CDATA[%7$s]]></PicUrl>\n"
		    + "<Url><![CDATA[%8$s]]></Url>\n"
		    + "</item>\n"
		    + "</Articles>\n"
		    + "</xml>";
	
}
