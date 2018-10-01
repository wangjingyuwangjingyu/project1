package com.tedu.jt.web.backend;

/*
 * ע��:servlet
 * @author:wangjingyu
 * @time:2018��8��22������3:24:45
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

public class updateservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(new String(request.getParameter("id").getBytes("iso-8859-1"),"utf-8"));
		String[] str=new String[]{"�ֻ�����","����ƽ��","���õ���","������Ʒ","ʳƷ����","ͼ����־","��װ����","��Ʋ�Ʒ","��潷���"};
		product1 p=finddata(id);
		request.setAttribute("product",p);
		request.setAttribute("str",str);
		request.getRequestDispatcher("/backend/prod_update.jsp").forward(request, response);
	}
	/**
	 * ����deleteid������Ʒ����Ϣ
	 * @param id				��Ʒid
	 * @param name				��Ʒ����
	 * @param catefory			��Ʒ��Ŀ
	 * @param price				��Ʒ�۸�
	 * @param pnum				��Ʒ����
	 * @param deleteid			��Ʒ�߼�ɾ��
	 * @return void				����ֵ
	 * 
	 */
	private product1 finddata(int id) {
			product1 p=new product1();
			Connection con=null;
			PreparedStatement ps=null;
			ResultSet rs=null;
			try {
				con=JDBCUtils.getConn();
				String sql="select * from product where id=?";
				ps=con.prepareStatement(sql);
				ps.setInt(1,id);
				rs = ps.executeQuery();
				if(rs.next()){
					p.setId(rs.getInt("id"));
					p.setName(rs.getString("name"));
					p.setCategory(rs.getString("category"));
					p.setPnum(rs.getInt("pnum"));
					p.setPrice(rs.getDouble("price"));
					p.setDescription(rs.getString("description"));
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtils.close(con, ps, rs);
			}
			return p;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
