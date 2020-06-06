package com.kwok.model.response;

/**
 * 回复音乐消息模型
 * @author Kwok
 */
public class ResponseMusicMessageModel {

	private String ToUserName; //接收方帐号（收到的OpenID）
	private String FromUserName; //开发者微信号
	private String CreateTime; //消息创建时间 （整型）
	private String MsgType; //music
	private String Title; //音乐标题
	private String Description; //音乐描述
	private String MusicURL; //音乐链接
	private String HQMusicUrl; //高质量音乐链接，WIFI环境优先使用该链接播放音乐
	private String ThumbMediaId; //缩略图的媒体id，通过素材管理中的接口上传多媒体文件，得到的id
	
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
	public String getMusicURL() {
		return MusicURL;
	}
	public void setMusicURL(String musicURL) {
		MusicURL = musicURL;
	}
	public String getHQMusicUrl() {
		return HQMusicUrl;
	}
	public void setHQMusicUrl(String hQMusicUrl) {
		HQMusicUrl = hQMusicUrl;
	}
	public String getThumbMediaId() {
		return ThumbMediaId;
	}
	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}

}
