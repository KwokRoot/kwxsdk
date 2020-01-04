package com.kwok.model.request;

/**
 * 接收地理位置消息模型
 * @author Kwok
 */
public class RequestLocationMessageModel {

	private String ToUserName; //开发者微信号
	private String FromUserName; //发送方帐号（一个OpenID）
	private String CreateTime; //消息创建时间 （整型）
	private String MsgType; //location
	private String Location_X; //地理位置维度
	private String Location_Y; //地理位置经度
	private String Scale; //地图缩放大小
	private String Label; //地理位置信息
	private String MsgId; //消息id，64位整型
	
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
	public String getLocation_X() {
		return Location_X;
	}
	public void setLocation_X(String location_X) {
		Location_X = location_X;
	}
	public String getLocation_Y() {
		return Location_Y;
	}
	public void setLocation_Y(String location_Y) {
		Location_Y = location_Y;
	}
	public String getScale() {
		return Scale;
	}
	public void setScale(String scale) {
		Scale = scale;
	}
	public String getLabel() {
		return Label;
	}
	public void setLabel(String label) {
		Label = label;
	}
	public String getMsgId() {
		return MsgId;
	}
	public void setMsgId(String msgId) {
		MsgId = msgId;
	}
	
}
