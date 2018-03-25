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
		//getMethod();��ȡ���󷽷�
		//***getRequestURL();���ؿͻ��˷�������ʱ������·��URL
		//***getRequestURI();�����������е���Դ������
		//****getContextPath();��ǰӦ�õ�����·����Ҳ����Ӧ����
		//getQueryString();�����������еĲ�������
		
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
