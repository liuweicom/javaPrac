package com.itheima.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieDemo2 extends HttpServlet {

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
		//����һ��cookie����
		Cookie ck=new Cookie("lastAccessTime","");
		//���ñ�ɾ��Cookie��path��������ܻ�ɾ�����
		ck.setPath("/");//�൱��·��Ϊ/day10_Cookie
		//����Cookie�ı���ʱ��
		ck.setMaxAge(0);//-1Ϊ�رջỰ�������0��ʾ���������������ʾ�ڻỰ�б����ʱ�䣬������Ϊ��λ
		//��ckд�ص��ͻ���
		response.addCookie(ck);//��ckд�ص��ͻ��˻���
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
