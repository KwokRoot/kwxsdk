package com.kwok.model.response;

import com.kwok.model.ResXmlMsgTpl;

/**
 * 回复文本消息模型
 * @author Kwok
 */
public class ResponseTextMessageModel {
	
	private String ToUserName; //接收方帐号（收到的OpenID）
	private String FromUserName; //开发者微信号
	private String CreateTime; //消息创建时间 （整型）
	private String MsgType; //text
	private String Content; //回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示）
	
	
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	public String getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	
	
	public String toXmlString() {
		
		return String.format(ResXmlMsgTpl.textMsgTpl, ToUserName, FromUserName, CreateTime, Content);
	
	}
	
}
