package com.kwok.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import com.kwok.config.AppConfig;
import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;

/**
 * 1.Get 请求检验 signature。
 * 2.Get 请求接收消息，如果是安全模式下传输的密文并解密消息。
 * @author Kwok
 */
@WebServlet("/CheckSignServlet")
public class CheckSignServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get 请求验证签名时传递的参数。
		//System.out.println(request.getQueryString());
		
		//微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
		String signature = request.getParameter("signature");
		//时间戳
		String timestamp =  request.getParameter("timestamp");
		//随机数
		String nonce =  request.getParameter("nonce");
		//随机字符串
		String echostr =  request.getParameter("echostr");
		
		String[] array = new String[] { AppConfig.token, timestamp, nonce };
		StringBuffer sb = new StringBuffer();
		//字符串排序
		Arrays.sort(array);
		
		for (int i = 0; i < array.length; i++) {
			sb.append(array[i]);
		}
		
		String newSignature = DigestUtils.sha1Hex(sb.toString());
		
		if(signature.equals(newSignature)){
			response.getWriter().append(echostr);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Post 请求的URL参数可用于校验数据完整性
		System.out.println(request.getQueryString());
		
		String timestamp =  request.getParameter("timestamp");
		String nonce =  request.getParameter("nonce");
		
		//安全模式增加 encrypt_type（加密类型，为aes）和 msg_signature（消息体签名，用于验证消息体的正确性）两个参数。
		String encrypt_type = request.getParameter("encrypt_type");
		String msg_signature = request.getParameter("msg_signature");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		StringBuffer sb = new StringBuffer("");
		String line;
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		
		System.out.println("接收的消息: \n" + sb.toString());
		
		//接收的消息，如果是安全模式下传输的密文并解密消息。
		if(encrypt_type != null){
			try {
				WXBizMsgCrypt mc = new WXBizMsgCrypt(AppConfig.token, AppConfig.EncodingAESKey, AppConfig.AppID);
				String result = mc.decryptMsg(msg_signature, timestamp, nonce, sb.toString());
				System.out.println("解密后明文: \n" + result);
			} catch (AesException e) {
				e.printStackTrace();
			}
		}
	}
}
