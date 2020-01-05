package com.kwok.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.kwok.model.entity.UserB;
import com.kwok.util.CommonsResult;
import com.kwok.util.CommonsResult.ResultCode;
import com.kwok.util.DBUtil;
import com.kwok.util.DateUtil;

@WebServlet("/submit")
public class SubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String openId = request.getParameter("openId");
		
		UserB userB = DBUtil.getNutDao().fetch(UserB.class, openId);
		if(userB!=null){
			userB.setGroupid(1);
			userB.setRemark(DateUtil.getCuryyyyMMddHHmmss());
			DBUtil.saveUserB(userB);
		}
		
        response.setContentType("text/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        CommonsResult<String> commonsResult = CommonsResult.CreateInstance();
        commonsResult.setStatus(ResultCode.ok);
        commonsResult.setMessage("成功");
        out.println(JSON.toJSONString(commonsResult));
        out.flush();
        out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
