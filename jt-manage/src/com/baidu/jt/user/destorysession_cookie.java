package com.baidu.jt.user;

/*
 * 注释:servlet
 * @author:wangjingyu
 * @time:2018年8月23日下午3:12:39
 * 
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class destorysession_cookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie cookie = new Cookie("name","");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		HttpSession session = request.getSession();
		session.setAttribute("name",null);
		System.out.println(session.getAttribute("name"));
		session.invalidate();
		
//		response.setHeader("location",request.getContextPath()+"/manage.jsp");
		request.getRequestDispatcher("/qiantai/login.jsp").forward(request,response);
//		response.setHeader("Refresh","0,url=/qiantai/login.jsp");
//		response.setHeader("Refresh","0,url=http://www.baidu.com");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
