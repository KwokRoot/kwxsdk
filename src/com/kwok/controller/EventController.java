package com.kwok.controller;

import java.util.Date;

import com.kwok.commons.EventType;
import com.kwok.model.request.RequestEventModel;
import com.kwok.model.response.ResponseEventModel;
import com.kwok.util.CommonsUtil;

/**
 * 事件类型消息控制层
 * @author Kwok
 */
public class EventController {

	public static ResponseEventModel execute(RequestEventModel requestEventModel) {
		
		ResponseEventModel responseEventModel = new ResponseEventModel();
		String eventType = requestEventModel.getEvent();
		
		switch (eventType) {
		
		case EventType.SUBSCRIBE:
			
			System.out.println(requestEventModel.getFromUserName() + " 在 " + CommonsUtil.formatDate(new Date(Long.parseLong(requestEventModel.getCreateTime()+"000"))) + " 关注。");
			
			responseEventModel.responseTextMessageModel.setToUserName(requestEventModel.getFromUserName());
			responseEventModel.responseTextMessageModel.setFromUserName((requestEventModel.getToUserName()));
			responseEventModel.responseTextMessageModel.setCreateTime(Long.toString(System.currentTimeMillis()));
			responseEventModel.responseTextMessageModel.setContent("感谢您的关注，开发中...");
			
			break;
		case EventType.UNSUBSCRIBE:
		
			String userName = requestEventModel.getFromUserName();
			Date date = new Date(Long.parseLong(requestEventModel.getCreateTime()+"000"));
			System.out.println(userName + " 在 " + CommonsUtil.formatDate(date) + " 取消关注。");
			
			break;
		case EventType.CLICK:
			
		{  // 代码块，防止变量名冲突
			String eventKey = requestEventModel.requestMapMessage.get("EventKey");
			
			responseEventModel.responseTextMessageModel.setToUserName(requestEventModel.getFromUserName());
			responseEventModel.responseTextMessageModel.setFromUserName((requestEventModel.getToUserName()));
			responseEventModel.responseTextMessageModel.setCreateTime(Long.toString(System.currentTimeMillis()));
			responseEventModel.responseTextMessageModel.setContent("事件KEY值：" +eventKey);
		}	
			
			break;
		case EventType.VIEW:
			
		{  // 代码块，防止变量名冲突
			String eventKey = requestEventModel.requestMapMessage.get("EventKey");
			responseEventModel.responseTextMessageModel.setToUserName(requestEventModel.getFromUserName());
			responseEventModel.responseTextMessageModel.setFromUserName((requestEventModel.getToUserName()));
			responseEventModel.responseTextMessageModel.setCreateTime(Long.toString(System.currentTimeMillis()));
			responseEventModel.responseTextMessageModel.setContent("事件KEY值：" +eventKey);
			System.out.println(eventKey);
		}
			
			break;
		default:
			
			System.err.println("------ 事件类型错误 ------");
			
			break;
		}
		
		return responseEventModel;
		
	}
	
}
