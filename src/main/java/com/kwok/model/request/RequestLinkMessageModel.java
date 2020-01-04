package com.kwok.model.request;

/**
 * 接收链接消息模型
 * @author Kwok
 */
public class RequestLinkMessageModel {

	private String ToUserName; //接收方微信号
	private String FromUserName; //发送方微信号，若为普通用户，则是一个OpenID
	private String CreateTime; //消息创建时间
	private String MsgType; //消息类型，link
	private String Title; //消息标题
	private String Description; //消息描述
	private String Url; //消息链接
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
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	public String getMsgId() {
		return MsgId;
	}
	public void setMsgId(String msgId) {
		MsgId = msgId;
	}
	
}
