package com.kwok.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.kwok.config.AppConfig;
import com.kwok.util.CommonsUtil;
import com.kwok.util.WXUtil;

/**
 * 获取微信 JS-SDK 配置信息
 * @author Kwok
 */
@WebServlet(urlPatterns = { "/WeiXinShareConfigServlet" })
public class WeiXinShareConfigServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String urlStr = request.getParameter("urlStr");
		//System.out.println(urlStr);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("appId", AppConfig.AppID_B);
		
		Date date=new Date();
		long timeStamp=date.getTime()/1000;
		
		map.put("timestamp", timeStamp);
		
		String nonceStr = CommonsUtil.getRandomStr(6);
		map.put("nonceStr", nonceStr);
		
		String jsApiTicket = null;
		try {
			jsApiTicket = WXUtil.getJsApiTicket();
			//System.out.println(jsApiTicket);
		
			if(jsApiTicket==null || "".equals(jsApiTicket) || "PARAMETER ERROR!".equals(jsApiTicket)){
				System.err.println("获取 JsApiTicket 出现错误！");
			}
			
			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("jsapi_ticket", jsApiTicket);
			paramMap.put("noncestr", nonceStr);
			paramMap.put("timestamp", String.valueOf(timeStamp));
			paramMap.put("url", urlStr);
			
			map.put("signature", WXUtil.getSha1Signature(paramMap));
			response.getWriter().append(JSON.toJSONString(map));
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().append("ERROR:" + e.getMessage());
		}
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
