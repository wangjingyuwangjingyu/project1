package com.baidu.jt.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ToLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("------1-------");
//		request.getRequestDispatcher("/qiantai/login.jsp").forward(request,response);
		response.sendRedirect("/qiantai/login.jsp");
//		response.setHeader("Refresh","0,url=/qiantai/login.jsp");
//		response.setHeader("Refresh","0,url=http://www.baidu.com");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
