package com.kwok.model.request;

/**
 * 接收语音消息模型
 * @author Kwok
 */
public class RequestVoiceMessageModel {
	
	private String ToUserName; //开发者微信号
	private String FromUserName; //发送方帐号（一个OpenID）
	private String CreateTime; //消息创建时间 （整型）
	private String MsgType; //语音为voice
	private String MediaId; //语音消息媒体id，可以调用多媒体文件下载接口拉取数据。
	private String Format; //语音格式，如amr，speex等
	private String Recognition; //语音识别结果，UTF8编码
	private String MsgID; //消息id，64位整型
	
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
	public String getFormat() {
		return Format;
	}
	public void setFormat(String format) {
		Format = format;
	}
	public String getRecognition() {
		return Recognition;
	}
	public void setRecognition(String recognition) {
		Recognition = recognition;
	}
	public String getMsgID() {
		return MsgID;
	}
	public void setMsgID(String msgID) {
		MsgID = msgID;
	}
	
}
