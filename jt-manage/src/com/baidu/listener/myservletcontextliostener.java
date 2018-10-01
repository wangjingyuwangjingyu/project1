package com.baidu.listener;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class myservletcontextliostener implements ServletContextListener{
	//servlet创建时的对象时执行
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("myservletcontextliostener.contextInitialized()");
		ServletContext servletContext = arg0.getServletContext();
		System.out.println(servletContext);
		//1.获取当前web的虚拟路径
		String contextPath = servletContext.getContextPath();
		//2.将虚拟路径存入servletcontext域中
		servletContext.setAttribute("PATH",contextPath);
	}
	
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("myservletcontextliostener.contextDestroyed()");
	}

}
