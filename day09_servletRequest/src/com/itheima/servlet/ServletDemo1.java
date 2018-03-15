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
		//
		//getMethod();获取请求方法
		//***getRequestURL();返回客户端发出请求时的完整路径URL
		//***getRequestURI();返回请求行中的资源名部分
		//****getContextPath();当前应用的虚拟路径，也就是应用名
		//getQueryString();返回请求行中的参数部分
		
		System.out.println(request.getMethod());//GET
		System.out.println(request.getRequestURL());//http://localhost:8081/day09_servletRequest/servlet/ServletDemo1
		System.out.println(request.getRequestURI());///day09_servletRequest/servlet/ServletDemo1
		System.out.println(request.getContextPath());///day09_servletRequest
		System.out.println(request.getQueryString());//null
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
