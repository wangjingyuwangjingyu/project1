package com.baidu.jt.user;

/*
 * 注释:servlet
 * @author:wangjingyu
 * @time:2018年8月23日下午12:30:48
 * 
 */
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tedu.jt.utils.JDBCUtils;

public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String name;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String username=request.getParameter("user");
		String password=request.getParameter("pass");
		System.out.println(username+"==="+password);
		boolean flag=finduser(username,password);
		if(flag){
			response.getWriter().write("<!doctype html>");
			response.getWriter().write("<html>");
			response.getWriter().write("<head>");
			response.getWriter().write("<title>");
			response.getWriter().write("</title>");
			response.getWriter().write("</head>");
			response.getWriter().write("<body>");
			response.getWriter().write("<h1 style='width:500px;height:100px;display:block;text-align: center;font-size:60px;position: absolute;top:0px;left:0px;right:0px;bottom:0px;margin:auto;'>后台验证成功</h1>");
			response.getWriter().write("</body>");
			response.getWriter().write("</html>");
			Cookie cookie = new Cookie("name",username);
			cookie.setMaxAge(3600);
			response.addCookie(cookie);
			HttpSession session = request.getSession();
			session.setAttribute("dlname",this.name);
			response.setHeader("Refresh","1,url=http://localhost:80");
		}else{
			response.getWriter().write("<!doctype html>");
			response.getWriter().write("<html>");
			response.getWriter().write("<head>");
			response.getWriter().write("<title>");
			response.getWriter().write("</title>");
			response.getWriter().write("</head>");
			response.getWriter().write("<body>");
			response.getWriter().write("<h1 style='width:500px;height:100px;display:block;text-align: center;font-size:60px;position: absolute;top:0px;left:0px;right:0px;bottom:0px;margin:auto;'>后台验证失败</h1>");
			response.getWriter().write("</body>");
			response.getWriter().write("</html>");			
			response.setHeader("Refresh","1,url=/qiantai/login.jsp");
		}
	}
	private boolean finduser(String username,String password) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			con=JDBCUtils.getConn();
			String sql="select * from user where username=? and password=?";
			ps=con.prepareStatement(sql);
			ps.setString(1,username);
			ps.setString(2,password);
			rs=ps.executeQuery();
			if(rs.next()){
				this.name=rs.getString("beizhuziliao");
				return true;
			}else{
				return false;						
			}
		} catch (Exception e) {
			
		}finally{
			JDBCUtils.close(con, ps, rs);
		}
		return false;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
