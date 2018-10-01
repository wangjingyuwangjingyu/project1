package com.tedu.jt.web.backend;
/*
 * ע��:servlet
 * @author:wangjingyu
 * @time:2018��8��17������3:46:59
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

public class proaddservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html;charset=utf-8");
		System.out.println("1");
//		String name = request.getParameter("name");
//		String category = request.getParameter("category");
//		double price = Double.parseDouble(request.getParameter("price"));
//		int pnum = Integer.parseInt(request.getParameter("pnum"));
//		String description = request.getParameter("description");
//		
//		if(name==null){
//			System.out.println("name");
//			return;
//		}
//		//�������
//		addprod(name,category,price,pnum,description);
//		
//		//3.��ʾ�û���Ʒ��ӳɹ���3�����ת����Ʒ���б�ҳ��
//		PrintWriter writer = response.getWriter();
//		writer.write("<h1 style='width:100%;padding:30px;text-align:center;font-size:26px;color:red;'>");
//		writer.write("��Ʒ��ӳɹ���3�����ת����Ʒ�б�ҳ��");
//		writer.write("</h1>");
//		//4.��ʱˢ��:3�����ת����Ʒ�б�ҳ��
//		response.setHeader("Refresh", "3;url="+request.getContextPath()+"/backend/prod_list.jsp");
	}
	/**
	 * ����Ʒ��Ϣ���浽���ݿ���
	 * @param name
	 * @param category
	 * @param price
	 * @param pnum
	 * @param description
	 */
	private void addprod(String name, String category, double price, int pnum, String description) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn = JDBCUtils.getConn();
			String sql="insert into product name,category,price,pnum,description values(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, category);
			ps.setDouble(3, price);
			ps.setInt(4, pnum);
			ps.setString(5, description);			
			int rows = ps.executeUpdate();
			System.out.println("Ӱ������:"+rows);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.close(conn, ps, rs);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
