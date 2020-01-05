package com.kwok.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nutz.dao.Cnd;

import com.kwok.model.entity.Record2;
import com.kwok.util.DBUtil;

@WebServlet("/RankServlet")
public class RankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List <Record2> rankList = DBUtil.getNutDao().query(Record2.class, Cnd.wrap("order by score desc"), null);
		request.setAttribute("rankList", rankList);
		
		request.getRequestDispatcher("rank.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
