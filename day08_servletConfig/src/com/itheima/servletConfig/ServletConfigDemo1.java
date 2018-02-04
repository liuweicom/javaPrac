package com.itheima.servletConfig;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfigDemo1 extends HttpServlet {
	
	
	private ServletConfig config;

	
	
	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String encoding=config.getInitParameter("encoding");
//		System.out.println(encoding);
		//方式二：直接调用gernericConfig中的getServletConfig方法获得servletConfig对象，。。。
//		String encoding2=this.getServletConfig().getInitParameter("encoding");
//		System.out.println(encoding2);
		//方式三：GernericConfig方法中直接已经包含了有了，getInitParameter方法可以直接调用
		String encoding3=this.getInitParameter("encoding");
		System.out.println(encoding3);
	}

//	//方式一：通过重写GernericConfig中的init方法，得到ServletConfig对象，在获取ServletConfig中的getInitParameter方法
//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		// TODO Auto-generated method stub
//		this.config=config;
//	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
