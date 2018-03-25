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
		//获取客户端保存的最后时间（先获取上一次的值）
		Cookie[] cookies=request.getCookies();//获取客户端所有的Cookie对象
		for(int i=0;cookies!=null&&i<cookies.length;i++){
			if("lastAccessTime".equals(cookies[i].getName())){//判断当前是想要的Cookie,则把Cookie中的value取出
				long l=Long.parseLong(cookies[i].getValue());//取出数据
				out.write("你最后的访问时间为："+new Date(l).toLocaleString());//将毫秒时间转化成yyyy-MM-dd的格式
			}
		}
		out.write("<a href='"+request.getContextPath()+"/servlet/CookieDemo2'>clear</a>");
		//创建COOKIE
		Cookie ck=new Cookie("lastAccessTime",System.currentTimeMillis()+"");
		//设置Cookie的有效时间，单位是秒
		ck.setMaxAge(60*5);
		//设置cookies的path
		//ck.setpath('day10_Cookie');
		//ck.setpath(request.getContextPath());
		ck.setPath("/");//此时在服务器端/表示的位置为day10_Cookie
		//将cookie的信息放回到客户端
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
