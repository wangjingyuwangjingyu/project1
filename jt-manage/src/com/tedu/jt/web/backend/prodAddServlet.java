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
				writer.write("��д������,3��󷵻�"); 
				writer.write("</h1>");
				//4.��ʱˢ��:3�����ת����Ʒ�б�ҳ��
				response.setHeader("Refresh", "3;url="+request.getContextPath()+"/backend/prod_add.jsp");
				return;
			}
			price = Double.parseDouble(request.getParameter("price"));
			pnum = Integer.parseInt(request.getParameter("pnum"));
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("����!!!");
		}
		
		
		//�������
		int rows=addprod(name,category,price,pnum,description);
		if(rows>0){
			//3.��ʾ�û���Ʒ��ӳɹ���3�����ת����Ʒ���б�ҳ��
			PrintWriter writer = response.getWriter();
			writer.write("<h1 style='width:100%;padding:30px;text-align:center;font-size:26px;color:red;'>");
			writer.write("��Ʒ��ӳɹ�,3�����ת����Ʒ�б�ҳ��");
			writer.write("</h1>");
		}else{
			//3.��ʾ�û���Ʒ��ӳɹ���3�����ת����Ʒ���б�ҳ��
			PrintWriter writer = response.getWriter();
			writer.write("<h1 style='width:100%;padding:30px;text-align:center;font-size:26px;color:red;'>");
			writer.write("���ʧ��,3�����ת����Ʒ�б�ҳ��");
			writer.write("</h1>");
		}
		//4.��ʱˢ��:3�����ת����Ʒ�б�ҳ��
//		response.setHeader("Refresh", "3;url="+request.getContextPath()+"/prodlistservlet");
		request.getRequestDispatcher("/prodlistservlet").forward(request,response);
	}
	/**
	 * ����Ʒ��Ϣ���浽���ݿ���
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
			System.out.println("Ӱ������:"+rows);
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
