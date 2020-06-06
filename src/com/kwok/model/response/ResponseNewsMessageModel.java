package com.kwok.model.response;

/**
 * 回复图文消息模型
 * @author Kwok
 */
public class ResponseNewsMessageModel {
	
	private String ToUserName; //接收方帐号（收到的OpenID）
	private String FromUserName; //开发者微信号
	private String CreateTime; //消息创建时间 （整型）
	private String MsgType; //news
	private String ArticleCount; //图文消息个数，限制为8条以内
	private String Articles; //多条图文消息信息，默认第一个item为大图,注意，如果图文数超过8，则将会无响应
	private String Title; //图文消息标题
	private String Description; //图文消息描述
	private String PicUrl; //图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
	private String Url; //点击图文消息跳转链接
	
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
	public String getArticleCount() {
		return ArticleCount;
	}
	public void setArticleCount(String articleCount) {
		ArticleCount = articleCount;
	}
	public String getArticles() {
		return Articles;
	}
	public void setArticles(String articles) {
		Articles = articles;
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
	public String getPicUrl() {
		return PicUrl;
	}
	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}

}
