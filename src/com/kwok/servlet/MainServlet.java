package com.kwok.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kwok.commons.MsgType;
import com.kwok.config.AppConfig;
import com.kwok.util.ResXmlMsgTpl;
import com.kwok.util.WXUtil;
import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String signature = request.getParameter("signature");
		String timestamp =  request.getParameter("timestamp");
		String nonce =  request.getParameter("nonce");
		String echostr =  request.getParameter("echostr");
		
		if(WXUtil.CheckSign(signature, timestamp, nonce)){
			response.getWriter().append(echostr);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		
		String timestamp =  request.getParameter("timestamp");
		String nonce =  request.getParameter("nonce");
		String encrypt_type = request.getParameter("encrypt_type");
		String msg_signature = request.getParameter("msg_signature");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		StringBuffer sb = new StringBuffer("");
		String line;
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		
		//System.out.println("接收的消息: \n" + sb.toString());
		
		String reqXmlMessage = sb.toString();
		
		//接收的消息，如果是安全模式下传输的密文并解密消息。
		if(encrypt_type != null){
			try {
				WXBizMsgCrypt mc = new WXBizMsgCrypt(AppConfig.token, AppConfig.EncodingAESKey, AppConfig.AppID);
				reqXmlMessage = mc.decryptMsg(msg_signature, timestamp, nonce, sb.toString());
				//System.out.println("解密后明文: \n" + reqXmlMessage);
			} catch (AesException e) {
				e.printStackTrace();
			}
		}
		
		Map<String, String> reqMapMessage = WXUtil.xmlToMap(reqXmlMessage);
		//System.out.println(reqMapMessage);
		
		// 发送方帐号（一个OpenID）
		String userName = reqMapMessage.get("FromUserName");
		// 开发者微信号
		String appName= reqMapMessage.get("ToUserName");
		// 文本消息内容
		String Content = reqMapMessage.get("Content");
		// 消息id，64位整型
		//String MsgId = reqMapMessage.get("MsgId");
		// 消息创建时间 （整型）
		//String CreateTime = reqMapMessage.get("CreateTime");
		// 消息类型
		String msgType = reqMapMessage.get("MsgType");
		
		switch (msgType) {
		
		case MsgType.TEXT:
			
			String resXmlMessage = String.format(ResXmlMsgTpl.textMsgTpl, userName, appName, new Date().getTime(), Content);
			
			if(encrypt_type != null){
				//安全模式
				try {
					WXBizMsgCrypt mc = new WXBizMsgCrypt(AppConfig.token, AppConfig.EncodingAESKey, AppConfig.AppID);
					String resEncryptXmlMessage = mc.encryptMsg(resXmlMessage, timestamp, nonce);
					response.getWriter().append(resEncryptXmlMessage);
				} catch (AesException e) {
					e.printStackTrace();
				}
				
			}else{
				// 明文模式
				response.getWriter().append(resXmlMessage);
			}
			
			break;
		case MsgType.IMAGE:
			
			break;
		case MsgType.VOICE:
			
			break;
		case MsgType.VIDEO:
			
			break;
		case MsgType.SHORTVIDEO:
			
			break;
		case MsgType.LOCATION:
			
			break;
		case MsgType.LINK:
			
			break;
		default:
			
			break;
		}
		
	}
}
