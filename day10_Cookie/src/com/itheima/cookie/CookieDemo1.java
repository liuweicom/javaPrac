package com.itheima.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieDemo1 extends HttpServlet {

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
		PrintWriter out=response.getWriter();
		//��ȡ�ͻ��˱�������ʱ�䣨�Ȼ�ȡ��һ�ε�ֵ��
		Cookie[] cookies=request.getCookies();//��ȡ�ͻ������е�Cookie����
		for(int i=0;cookies!=null&&i<cookies.length;i++){
			if("lastAccessTime".equals(cookies[i].getName())){//�жϵ�ǰ����Ҫ��Cookie,���Cookie�е�valueȡ��
				long l=Long.parseLong(cookies[i].getValue());//ȡ������
				out.write("�����ķ���ʱ��Ϊ��"+new Date(l).toLocaleString());//������ʱ��ת����yyyy-MM-dd�ĸ�ʽ
			}
		}
		out.write("<a href='"+request.getContextPath()+"/servlet/CookieDemo2'>clear</a>");
		//����COOKIE
		Cookie ck=new Cookie("lastAccessTime",System.currentTimeMillis()+"");
		//����Cookie����Чʱ�䣬��λ����
		ck.setMaxAge(60*5);
		//����cookies��path
		//ck.setpath('day10_Cookie');
		//ck.setpath(request.getContextPath());
		ck.setPath("/");//��ʱ�ڷ�������/��ʾ��λ��Ϊday10_Cookie
		//��cookie����Ϣ�Żص��ͻ���
		response.addCookie(ck);
		
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
