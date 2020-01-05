package com.kwok.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nutz.dao.Cnd;

import com.kwok.model.entity.UserB;
import com.kwok.util.DBUtil;
import com.kwok.util.NativeCache;

@WebServlet("/2020/plus")
public class ActivityServletPlus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<UserB> leftUserBList = DBUtil.getNutDao().query(UserB.class, Cnd.where("sex", "=", 1).and("groupid", "=", 0));
		request.setAttribute("userBList", leftUserBList);
		
		List<UserB> userBLuckList = DBUtil.getNutDao().query(UserB.class, Cnd.where("sex", "=", 1).and("groupid", "=", 1).orderBy("remark", "asc"));
		request.setAttribute("userBLuckList", userBLuckList);
		
		/*
		 * 后台控制幸运用户
		 * 
		 */
		
		UserB luckUser = null;
		int leftUserCount = leftUserBList.size();
		int LuckUserCount = userBLuckList.size();
		if(leftUserCount > 0){
			Random random = new Random();
			int luckNo = random.nextInt(leftUserCount);
			luckUser = leftUserBList.get(luckNo);
		}
		
		/*
		 * 特殊用户处理
		 */
		
		Integer RankNum = LuckUserCount + 1;
		if(NativeCache.specialUserMap.get(RankNum) != null){
			for (UserB userB : leftUserBList) {
				if(userB.getOpenid()!=null 
						&& userB.getOpenid().equalsIgnoreCase(NativeCache.specialUserMap.get(RankNum))){
					luckUser = userB;
				}
			}
		}
		
		request.setAttribute("userB", luckUser);
		
		
		request.getRequestDispatcher("/2020_plus.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
