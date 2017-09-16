package com.kwok.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kwok.config.AppConfig;
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
		
		String xmlMessage = sb.toString();
		
		//接收的消息，如果是安全模式下传输的密文并解密消息。
		if(encrypt_type != null){
			try {
				WXBizMsgCrypt mc = new WXBizMsgCrypt(AppConfig.token, AppConfig.EncodingAESKey, AppConfig.AppID);
				xmlMessage = mc.decryptMsg(msg_signature, timestamp, nonce, sb.toString());
				//System.out.println("解密后明文: \n" + xmlMessage);
			} catch (AesException e) {
				e.printStackTrace();
			}
		}
		
		Map<String, String> mapMessage = WXUtil.xmlToMap(xmlMessage);
		System.out.println(mapMessage);
		
	}
}
