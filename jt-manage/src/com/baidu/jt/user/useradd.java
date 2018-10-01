package com.baidu.jt.user;

/*
 * 注释:servlet
 * @author:wangjingyu
 * @time:2018年8月23日上午11:22:50
 * 
 */
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tedu.jt.utils.JDBCUtils;

public class useradd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String beizhuziliao = request.getParameter("beizhuziliao");
		System.out.println(username+"---"+password+"---"+beizhuziliao);
		boolean flag=zhuce(username,password,beizhuziliao);
		if(flag){
			response.getWriter().write("<h1>注册成功,2秒跳转</h1>");
			response.setHeader("Refresh","2,url=/qiantai/login.jsp");
		}else{
			response.getWriter().write("<h1>注册失败,2秒跳转</h1>");
			response.setHeader("Refresh","2,url=/qiantai/regist.jsp");
		}
	}

	private boolean zhuce(String username, String password, String beizhuziliao) {
		Connection conn=null;
		PreparedStatement ps=null;
		int rows=0;
		try {
			conn = JDBCUtils.getConn();
			String sql="insert into user (username,password,img,beizhuziliao) values(?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, "");
			ps.setString(4, beizhuziliao);
			rows = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.close(conn,ps, null);
		}
		if(rows>0){
			return true;
		}else{
			return false;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
