package com.kwok.model.request;

import java.util.Map;

/**
 * 接收事件类型消息模型
 * @author Kwok
 */
public class RequestEventModel {
	
	private String ToUserName; //开发者微信号
	private String FromUserName; //发送方帐号（一个OpenID）
	private String CreateTime; //消息创建时间 （整型）
	private String MsgType; //消息类型，event
	private String Event; //事件类型，CLICK
	
	public Map<String, String> requestMapMessage; //请求的所有参数
	
	public RequestEventModel(Map<String, String> reqMapMessage) {
		
		this.ToUserName = reqMapMessage.get("ToUserName");
		this.FromUserName = reqMapMessage.get("FromUserName");
		this.CreateTime = reqMapMessage.get("CreateTime");
		this.MsgType = reqMapMessage.get("MsgType");
		this.Event = reqMapMessage.get("Event");
		this.requestMapMessage = reqMapMessage;
		
	}
	
	public RequestEventModel(){
		
	}
	
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
	public String getEvent() {
		return Event;
	}
	public void setEvent(String event) {
		Event = event;
	}
	
}
