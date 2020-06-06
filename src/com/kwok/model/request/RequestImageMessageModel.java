package com.kwok.model.request;

/**
 * 接收图片消息模型
 * @author Kwok
 */
public class RequestImageMessageModel {

	private String ToUserName; //开发者微信号
	private String FromUserName; //发送方帐号（一个OpenID）
	private String CreateTime; //消息创建时间 （整型）
	private String MsgType; //image
	private String PicUrl; //图片链接（由系统生成）
	private String MediaId; //图片消息媒体id，可以调用多媒体文件下载接口拉取数据。
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
	public String getPicUrl() {
		return PicUrl;
	}
	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	public String getMsgId() {
		return MsgId;
	}
	public void setMsgId(String msgId) {
		MsgId = msgId;
	}
	
}
