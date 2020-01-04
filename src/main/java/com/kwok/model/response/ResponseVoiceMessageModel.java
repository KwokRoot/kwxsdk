package com.kwok.model.response;

/**
 * 回复语音消息模型
 * @author Kwok
 */
public class ResponseVoiceMessageModel {
	
	private String ToUserName; //接收方帐号（收到的OpenID）
	private String FromUserName; //开发者微信号
	private String CreateTime; //消息创建时间戳 （整型）
	private String MsgType; //语音，voice
	private String MediaId; //通过素材管理中的接口上传多媒体文件，得到的id
	
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
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	
}
