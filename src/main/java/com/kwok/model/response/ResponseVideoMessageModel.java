package com.kwok.model.response;

/**
 * 回复视频消息模型
 * @author Kwok
 */
public class ResponseVideoMessageModel {

	private String ToUserName; //接收方帐号（收到的OpenID）
	private String FromUserName; //开发者微信号
	private String CreateTime; //消息创建时间 （整型）
	private String MsgType;//video
	private String MediaId; //通过素材管理中的接口上传多媒体文件，得到的id
	private String Title; //视频消息的标题
	private String Description; //视频消息的描述
	
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
	
}
