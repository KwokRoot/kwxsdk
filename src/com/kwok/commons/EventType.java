package com.kwok.commons;

/**
 * 事件类型
 * @author Kwok
 */
public class EventType {

	
	/**
	 * 订阅
	 */
	public static final String SUBSCRIBE = "subscribe";
	
	/**
	 * 取消订阅
	 */
	public static final String UNSUBSCRIBE = "unsubscribe";
	
	
	/**
	 * 拉取消息
	 */
	public static final String CLICK = "CLICK";
	
	/**
	 * 跳转链接
	 */
	public static final String VIEW = "VIEW";
	
	/**
	 * 扫码推
	 */
	public static final String SCANCODE_PUSH = "scancode_push";
	
	/**
	 * 扫码推(弹出“消息接收中”提示框)
	 */
	public static final String SCANCODE_WAITMSG = "scancode_waitmsg";
	
	/**
	 * 系统拍照发图
	 */
	public static final String PIC_SYSPHOTO = "pic_sysphoto";
	
	/**
	 * 拍照或者相册发图
	 */
	public static final String PIC_PHOTO_OR_ALBUM = "pic_photo_or_album";
	
	/**
	 * 微信相册发图
	 */
	public static final String PIC_WEIXIN = "pic_weixin";
	
	/**
	 * 地理位置
	 */
	public static final String LOCATION_SELECT = "location_select";
	
}
