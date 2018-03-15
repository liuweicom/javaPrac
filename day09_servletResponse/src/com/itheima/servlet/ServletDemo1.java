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
		//��������Ĭ�ϵı���ΪISO-8859-1,����֧�����ģ�tomcatĬ�����õ�
		//���߷�����Ӧ��ʹ�õ���UTF_8��������ı�
//		response.setCharacterEncoding("UTF-8");
//		���������Ӧ��ʹ��UTF_8�����ı������߿ͻ���Ҫʹ��ʲô����
//		response.setHeader("content-type", "text/html;charset=UTF-8");
		
		//�����������롣�ͱ��б�����˼��Ч�����߷�����Ӧ��ʹ��UTF-8�����ı���ͬʱ���߿ͻ���Ҫʵ��UTF-8Ҫʹ��ʲô�ı�
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.write("��ã�");
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
