package com.kwok.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.kwok.config.AppConfig;
import com.kwok.model.entity.UserA;
import com.kwok.util.CommonsUtil;
import com.kwok.util.DBUtil;

/**
 * https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect
 * @author Kwok
 */
@WebServlet("/OAuthCallBackServlet")
public class OAuthCallBackServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// System.out.println(request.getQueryString()); //请求参数
		
		String code = request.getParameter("code");
		String ReqAccessTokenPath = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + AppConfig.AppID_A + "&secret="+ AppConfig.AppSecret_A + "&code=" + code + "&grant_type=authorization_code";
		String ReqUserInfoPathFormat = "https://api.weixin.qq.com/sns/userinfo?access_token=%1$s&openid=%2$s&lang=zh_CN"; 
		
		String openid;
		String access_token;
		//String refresh_token;
		
		try {
			
			String jsonStr = CommonsUtil.getRequest(ReqAccessTokenPath);
			Map<String, String> jsonMap = JSON.parseObject(jsonStr, new TypeReference<Map<String, String>>(){});
			
			if(jsonMap.get("access_token") != null){
				
				openid = jsonMap.get("openid");
				access_token = jsonMap.get("access_token");
				//refresh_token = jsonMap.get("refresh_token");
				
				/*
				System.out.println("openid : " + openid);
				System.out.println("access_token : " + access_token);
				System.out.println("refresh_token : " + refresh_token);
				*/
				
				String ReqUserInfoPath = String.format(ReqUserInfoPathFormat, access_token, openid);
				//System.out.println(ReqUserInfoPath);
				
				String userInfoJson = CommonsUtil.getRequest(ReqUserInfoPath);
				
				UserA userA = JSON.parseObject(userInfoJson, UserA.class);
				if(DBUtil.saveUserA(userA)==1){
					System.out.println(userA.getNickname() + " 用户保存或更新成功！");
				}
				
				response.setCharacterEncoding("UTF-8");
				
				/*
				//活动一样例
				request.setAttribute("unionid", userA.getUnionid());
				request.getRequestDispatcher("activity.jsp").forward(request, response);
				*/
				
				//活动二样例
				request.setAttribute("userName", userA.getNickname());
				request.setAttribute("userPic", userA.getHeadimgurl());
				request.setAttribute("userId", userA.getUnionid());
				request.getRequestDispatcher("userInfo.jsp").forward(request, response);
				
				
			}else{
				//System.err.println(jsonStr); //防止微信服务器重复发起请求(微信服务器重复发起请求时，由于 code 只能使用一次，处理该 GET 请求用该 code 再次获取 openid 和 access_token 会返回错误。)。
			}
			
		} catch (Exception e){
			System.err.println("获取 openid 发生错误。");
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
