package com.kwok.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nutz.dao.Cnd;

import com.kwok.model.entity.UserB;
import com.kwok.util.DBUtil;

@WebServlet("/2020")
public class ActivityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<UserB> userBList = DBUtil.getNutDao().query(UserB.class, Cnd.where("sex", "=", 1).and("groupid", "=", 0));
		request.setAttribute("userBList", userBList);
		
		List<UserB> userBLuckList = DBUtil.getNutDao().query(UserB.class, Cnd.where("sex", "=", 1).and("groupid", "=", 1).orderBy("remark", "asc"));
		request.setAttribute("userBLuckList", userBLuckList);
		
		request.getRequestDispatcher("2020.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
