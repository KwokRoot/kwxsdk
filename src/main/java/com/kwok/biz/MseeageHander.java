package com.kwok.biz;

import org.apache.commons.lang3.StringUtils;

import com.kwok.model.entity.UserB;
import com.kwok.util.DBUtil;

public class MseeageHander {

	public static String handerText(String openId, String msg){
		
		String returnStr = null;
		
		UserB user = DBUtil.getNutDao().fetch(UserB.class, openId);
		
		if(user == null){
			return "找不到该用户，请重新关注该公众号！";
		}
		
		if(msg!=null && msg.trim().contains("签到")){
			if(user.getSex()==null || user.getSex()!=1){
				user.setSex(1);
				DBUtil.saveUserB(user);
				return "签到成功，请回复您的真实姓名，参与抽奖。";
			}else{
				return "您已签到成功，请回复您的真实姓名，参与抽奖。";
			}
		}else if(msg!=null && msg.trim().contains("中奖")){
			if(user.getGroupid() == 1){
				return "恭喜您中奖！";
			}else{
				return "没有找到您的中奖信息。";
			}
		}else{
			if(StringUtils.isBlank(user.getNickname())){
				returnStr = "您的姓名为:“" + msg + "”，最后抽奖以此为获奖依据！";
				user.setNickname(StringUtils.trim(msg));
				DBUtil.saveUserB(user);
			}else{
				returnStr = "您的姓名由“" + user.getNickname() + "”修改为“" + msg + "”，最后抽奖以" + msg + "为获奖依据！";
				user.setNickname(StringUtils.trim(msg));
				DBUtil.saveUserB(user);
			}
			return returnStr;
		}
	}
	
}
