package com.baidu.jt.user;

/*
 * 注释:servlet
 * @author:wangjingyu
 * @time:2018年8月23日上午11:22:56
 * 
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class userselect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(true){
			
		}else{
			
		}
		response.setHeader("Refresh","2,url=/backend/userlist.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
