package com.tedu.jt.web.backend;
import java.lang.String;
import java.sql.Connection;
import java.sql.PreparedStatement;
/*
 * 注释:servlet
 * @author:wangjingyu
 * @time:2018年8月22日下午2:18:50
 * 
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tedu.jt.utils.JDBCUtils;


public class delProd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		byte[] bytes = request.getParameter("id").getBytes("iso-8859-1");
		String id = new String(bytes,"utf-8");
		boolean flag=finddelete(id);
		if(flag){
			response.getWriter().write("<h1 style='margin:auto;color:red;position:absolute;top:0px;left:0px;right:0px;bottom:0px;'>删除  id=="+id+" 成功,2秒后跳转</h1>");
		}else{
			response.getWriter().write("<h1 style='margin:auto;color:red;position:absolute;top:0px;left:0px;right:0px;bottom:0px;'>删除  id=="+id+" 失败,2秒后跳转</h1>");
		}
		response.setHeader("Refresh", "2;url="+request.getContextPath()+"/prodlistservlet");
	}

	private boolean finddelete(String id) {
		Connection conn=null;
		PreparedStatement ps=null;
		int rows=0;
		try {
			conn = JDBCUtils.getConn();
			String sql="update product set deleteid=? where id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, "1");
			ps.setString(2, id);
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