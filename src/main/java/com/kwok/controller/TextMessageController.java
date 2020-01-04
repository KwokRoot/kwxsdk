package com.kwok.controller;

import com.kwok.model.request.RequestTextMessageModel;
import com.kwok.model.response.ResponseTextMessageModel;

/**
 * 文本消息控制层
 * @author Kwok
 */
public class TextMessageController {

	public static ResponseTextMessageModel execute(RequestTextMessageModel requestTextMessageModel) {
		
		ResponseTextMessageModel responseTextMessageModel = new ResponseTextMessageModel();
		
		String requestContent = requestTextMessageModel.getContent();
		
		responseTextMessageModel.setToUserName(requestTextMessageModel.getFromUserName());
		responseTextMessageModel.setFromUserName((requestTextMessageModel.getToUserName()));
		responseTextMessageModel.setCreateTime(Long.toString(System.currentTimeMillis()));
		
		responseTextMessageModel.setContent("亲，对不起：“" + requestContent + "” 指令还没学习成功！");
		
		return responseTextMessageModel;
		
	}

}
