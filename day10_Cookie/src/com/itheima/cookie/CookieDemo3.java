package com.itheima.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieDemo3 extends HttpServlet {

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
		//先获取客户端保存的数据，即使可能第一访问cookies不存在的时候
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		Cookie[] cookies=request.getCookies();
		String username="";
		String checked="";
		for(int i=0;cookies!=null&&i<cookies.length;i++){
			if("username".equals(cookies[i].getName())){
				username=cookies[i].getValue();
				checked="checked='checked'";
			}
		}
		out.write("<form action='"+request.getContextPath()+"/servlet/CookieDemo4' method='post'><br/>");
		out.write("用户名：<input type='text' name='username' value='"+username+"'><br/>");
		out.write("<input type='checkbox' name='remember'"+checked+"/><br/>");
		out.write("<input type='submit' value='登录'/>");
		out.write("</form>");
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
