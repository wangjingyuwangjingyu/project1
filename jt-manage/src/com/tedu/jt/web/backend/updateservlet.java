package com.tedu.jt.web.backend;

/*
 * 注释:servlet
 * @author:wangjingyu
 * @time:2018年8月22日下午3:24:45
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
		String[] str=new String[]{"手机数码","电脑平板","家用电器","汽车用品","食品饮料","图书杂志","服装服饰","理财产品","嫖娼服务"};
		product1 p=finddata(id);
		request.setAttribute("product",p);
		request.setAttribute("str",str);
		request.getRequestDispatcher("/backend/prod_update.jsp").forward(request, response);
	}
	/**
	 * 根据deleteid查找商品的信息
	 * @param id				商品id
	 * @param name				商品名称
	 * @param catefory			商品栏目
	 * @param price				商品价格
	 * @param pnum				商品数量
	 * @param deleteid			商品逻辑删除
	 * @return void				返回值
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
