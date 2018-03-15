package com.itheima.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo1 extends HttpServlet {

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
		//服务器中默认的编码为ISO-8859-1,它不支持中文，tomcat默认设置的
		//告诉服务器应用使用的是UTF_8编码解析文本
//		response.setCharacterEncoding("UTF-8");
//		告诉浏览器应用使用UTF_8解析文本，告诉客户端要使用什么编码
//		response.setHeader("content-type", "text/html;charset=UTF-8");
		
		//上面的两句代码。和本行表达的意思等效，告诉服务器应用使用UTF-8解析文本，同时告诉客户端要实用UTF-8要使用什么文本
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.write("你好！");
	}

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
