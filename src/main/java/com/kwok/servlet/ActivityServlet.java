package com.kwok.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kwok.commons.Result;
import com.kwok.util.DBUtil;

@WebServlet("/ActivityServlet")
public class ActivityServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		
		Result<Integer> result = Result.newInstance();
		
		String unionid = request.getParameter("unionid");
		String itemid = request.getParameter("itemid");
		
		if(unionid != null && itemid != null){
			if(DBUtil.checkSubscribe(unionid)){
				int retrunCode = DBUtil.saveRecoed(unionid, itemid);
				result.setData(retrunCode);
				result.setCode(Result.Type.yes.getValue());
				if(retrunCode == 1){
					result.setMessage("投票成功");
				}
				if (retrunCode == 0) {
					result.setMessage("您已为该项目投过票");
				}
				
				response.getWriter().append(result.toJson());
			}else{
				result.setCode(Result.Type.yes.getValue());
				result.setMessage("您还未关注公众号");
				response.getWriter().append(result.toJson());
			}
		}else{
			result.setCode(Result.Type.err.getValue());
			result.setMessage("非法请求");
			response.getWriter().append(result.toJson());
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
