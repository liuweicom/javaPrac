package com.itheima.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieDemo4 extends HttpServlet {

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
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out =response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		//��ȡ������
		String username=request.getParameter("username");
		String remember=request.getParameter("remember");
		Cookie ck=new Cookie("username",username);
		//����ҵ���߼�
		//�ַ�ת��
		if("tom".equals(username)){
			if(remember!=null){
				ck.setMaxAge(Integer.MAX_VALUE);//����cookies����Ч����ʱ��
			}else{
				ck.setMaxAge(0);//ɾ��cookies
			}
			response.addCookie(ck);//��cookiesд�ص��ͻ���
			out.write("��¼�ɹ�|");
		}else{
			out.write("��¼ʧ��|");
			//����2����ת�����µ�¼
			response.setHeader("refresh", "2;url="+request.getContextPath()+"/servlet/CookieDemo3");
		}
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
