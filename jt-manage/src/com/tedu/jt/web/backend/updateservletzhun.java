package com.tedu.jt.web.backend;

/*
 * 注释:servlet
 * @author:wangjingyu
 * @time:2018年8月23日上午9:10:12
 * 
 */
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tedu.jt.utils.JDBCUtils;

public class updateservletzhun extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String category=request.getParameter("category");
		String price=request.getParameter("price");
		String pnum=request.getParameter("pnum");
		String description=request.getParameter("description");
		System.out.println(id+"-"+name+"-"+category+"-"+price+"-"+pnum+"-"+description);
		boolean flag=update(id,name,category,price,pnum,description);
		if(flag){
			response.getWriter().write("<h1>修改成功,2秒跳转</h1>");
		}else{
			response.getWriter().write("<h1>修改失败,2秒跳转</h1>");
		}
		response.setHeader("Refresh","2,url=/prodlistservlet");
	}

	private boolean update(String id, String name, String category, String price, String pnum, String description) {
		Connection con=null;
		PreparedStatement ps=null;
		int rows=0;
		try {
			con=JDBCUtils.getConn();
			String sql="update product set name=?,category=?,price=?,pnum=?,description=? where id=?";
			ps=con.prepareStatement(sql);
			ps.setString(1,name);
			ps.setString(2,category);
			ps.setString(3,price);
			ps.setString(4,pnum);
			ps.setString(5,description);
			ps.setString(6,id);
			rows = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.close(con, ps, null);
		}
		if(rows<=0){
			return false;			
		}else{
			return true;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
