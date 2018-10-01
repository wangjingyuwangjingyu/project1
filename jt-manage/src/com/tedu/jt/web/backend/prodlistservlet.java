package com.tedu.jt.web.backend;

/*
 * 注释:servlet
 * @author:wangjingyu
 * @time:2018年8月22日上午10:39:32
 * 
 */
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tedu.jt.utils.JDBCUtils;

public class prodlistservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("--------------"+request.getSession().getAttribute("name")+"----------------");
		List<product> list=finddata();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/backend/prod_list.jsp").forward(request, response);
	}

	private List<product> finddata() {
		List<product> list=new LinkedList<product>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn=JDBCUtils.getConn();
			String sql="select * from product where deleteid=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1,"0");
			rs=ps.executeQuery();
			product p=null;
			while(rs.next()){
				p=new product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setCategory(rs.getString("category"));
				p.setPrice(rs.getDouble("price"));
				p.setPnum(rs.getInt("pnum"));
				p.setDescription(rs.getString("description"));
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.close(conn, ps, rs);
		}
		return list;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}