package com.tedu.jt.web.backend;
/*
 * 注释:servlet
 * @author:wangjingyu
 * @time:2018年8月17日下午3:46:59
 * 
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tedu.jt.utils.JDBCUtils;

public class prodAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String name,category,description;
		double price;
		int pnum;
		try {
			name = request.getParameter("name");
			category = request.getParameter("category");
			description = request.getParameter("description");
			
			System.out.println("------------"+name);
			if(name==null||category==null||description==null){
				PrintWriter writer = response.getWriter();
				writer.write("<h1 style='width:100%;padding:30px;text-align:center;font-size:26px;color:red;'>");
				writer.write("填写不完整,3秒后返回"); 
				writer.write("</h1>");
				//4.定时刷新:3秒后跳转到商品列表页面
				response.setHeader("Refresh", "3;url="+request.getContextPath()+"/backend/prod_add.jsp");
				return;
			}
			price = Double.parseDouble(request.getParameter("price"));
			pnum = Integer.parseInt(request.getParameter("pnum"));
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("错误!!!");
		}
		
		
		//添加数据
		int rows=addprod(name,category,price,pnum,description);
		if(rows>0){
			//3.提示用户商品添加成功，3秒后跳转到商品的列表页面
			PrintWriter writer = response.getWriter();
			writer.write("<h1 style='width:100%;padding:30px;text-align:center;font-size:26px;color:red;'>");
			writer.write("商品添加成功,3秒后将跳转到商品列表页面");
			writer.write("</h1>");
		}else{
			//3.提示用户商品添加成功，3秒后跳转到商品的列表页面
			PrintWriter writer = response.getWriter();
			writer.write("<h1 style='width:100%;padding:30px;text-align:center;font-size:26px;color:red;'>");
			writer.write("添加失败,3秒后将跳转到商品列表页面");
			writer.write("</h1>");
		}
		//4.定时刷新:3秒后跳转到商品列表页面
//		response.setHeader("Refresh", "3;url="+request.getContextPath()+"/prodlistservlet");
		request.getRequestDispatcher("/prodlistservlet").forward(request,response);
	}
	/**
	 * 将商品信息保存到数据库中
	 * @param name
	 * @param category
	 * @param price
	 * @param pnum
	 * @param description
	 */
	private int addprod(String name, String category, double price, int pnum, String description) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int rows=0;
		try {
			conn = JDBCUtils.getConn();
			System.out.println(conn);
			String sql="insert into product (name,category,price,pnum,description) values(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, category);
			ps.setDouble(3, price);
			ps.setInt(4, pnum);
			ps.setString(5, description);			
			rows = ps.executeUpdate();
			System.out.println("影响行数:"+rows);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.close(conn, ps, rs);
			return rows;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
