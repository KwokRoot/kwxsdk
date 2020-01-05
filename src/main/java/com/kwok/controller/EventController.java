package com.kwok.controller;

import java.util.Date;

import com.kwok.commons.EventType;
import com.kwok.model.entity.UserB;
import com.kwok.model.request.RequestEventModel;
import com.kwok.model.response.ResponseEventModel;
import com.kwok.util.DBUtil;
import com.kwok.util.DateUtil;

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
			
			System.out.println(requestEventModel.getFromUserName() + " 在 " + DateUtil.dateToStr(Long.parseLong(requestEventModel.getCreateTime()+"000")) + " 关注。");
			
			responseEventModel.responseTextMessageModel.setToUserName(requestEventModel.getFromUserName());
			responseEventModel.responseTextMessageModel.setFromUserName((requestEventModel.getToUserName()));
			responseEventModel.responseTextMessageModel.setCreateTime(Long.toString(System.currentTimeMillis()));
			
			//获取用户名
			UserB userB = new UserB();
			
			userB.setOpenid(requestEventModel.getFromUserName());
			userB.setSubscribe_time(DateUtil.getCurDateTime());
			userB.setSubscribe(1);
			userB.setSex(0);
			userB.setGroupid(0);
			
			responseEventModel.responseTextMessageModel.setContent("感谢您的关注，请回复“签到”，参与年会抽奖！");
			System.err.println(userB.getOpenid() + " 在 " + DateUtil.dateToStr(Long.parseLong(requestEventModel.getCreateTime()+"000")) + " 关注。");
			DBUtil.saveUserB(userB);
			
			break;
		case EventType.UNSUBSCRIBE:
			
			String userName = requestEventModel.getFromUserName();
			Date date = new Date(Long.parseLong(requestEventModel.getCreateTime()+"000"));
			System.err.println(userName + " 在 " + DateUtil.dateToStr(date) + " 取消关注。");
			DBUtil.deleteUserB(userName);
			
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
		case EventType.LOCATION_SELECT:
			
		{  // 代码块，防止变量名冲突
			String eventKey = requestEventModel.requestMapMessage.get("EventKey");
			System.out.println("------------------------------------");
			System.out.println("事件类型：" + EventType.LOCATION_SELECT);
			System.out.println(eventKey);
			System.out.println("------------------------------------");
		}
			
			break;	
		default:
			
			System.err.println("------ 事件类型错误 ------");
			
			break;
		}
		
		return responseEventModel;
		
	}
	
}
