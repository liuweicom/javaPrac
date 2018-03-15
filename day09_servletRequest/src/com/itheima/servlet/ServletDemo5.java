package com.itheima.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo5 extends HttpServlet {

	/**
	 * ����ת�����ض��������
	 * ����ת��request�ɷ�����ִ��
	 * �ͻ���ֻ����һ������
	 * ��ַ������
	 * ת��Ҳ��һ�������servletContext
	 * 
	 * �ض���response�ɿͻ���ִ��
	 * �ͻ��˷�����������
	 * ��ַ���ᷢ���ı�
	 * ���ܴ�������
	 * ������ת������Ӧ��
	 */
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;chrset=UTF-8");
		System.out.println("A:do something!");
		System.out.println("B:i couldn't,but i can ask somone to help you !");
		request.setAttribute("s","aaaaaaa");
		//���Ǳ�������ӵ�request����
		//������ת����demo6��
		//ע�⣺����ת��������ת������Ӧ��
//		request.getRequestDispatcher("/servlet/ServletDemo6").forward(request, response);
		//ʹ���ض���
		//������ת����������
		response.sendRedirect(request.getContextPath()+"/servlet/ServletDemo6");
		//�������
		System.out.println("things done");
//		request.getRequestDispatcher("/servlet/ServletDemo6").include(request, response);
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
