package com.kwok.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nutz.dao.Cnd;

import com.kwok.model.entity.Record2;
import com.kwok.model.entity.UserA;
import com.kwok.util.DBUtil;

@WebServlet("/Activity2Servlet")
public class Activity2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String score = request.getParameter("score");
		
		if(userId != null){
			UserA userA = DBUtil.getNutDao().fetch(UserA.class, userId);
			if(userA != null){
				Record2 record2 = new Record2();
				
				record2.setUnionid(userId);
				
				if (score != null && !"".equals(score)) {
					record2.setScore(Integer.valueOf(score));
				}
				
				record2.setUserName(userA.getNickname());
				record2.setUserPic(userA.getHeadimgurl());
				record2.setTime(new Date());
				
				Record2 record2_2 = DBUtil.getNutDao().fetch(Record2.class, Cnd.where("unionid", "=", record2.getUnionid()));
				if(record2_2 !=null){
					if(record2_2.getScore() <= record2.getScore()){
						record2.setId(record2_2.getId());
						DBUtil.getNutDao().update(record2);
					}
				}else{
					DBUtil.getNutDao().insert(record2);
				}
			}else{
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
			
		}
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
