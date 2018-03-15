package com.itheima.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo5 extends HttpServlet {

	/**
	 * 请求转发和重定向的区别：
	 * 请求转发request由服务器执行
	 * 客户端只发送一次请求
	 * 地址栏不变
	 * 转发也是一个与对象servletContext
	 * 
	 * 重定向：response由客户端执行
	 * 客户端发送两次请求
	 * 地址栏会发生改变
	 * 不能传递数据
	 * 可以跳转到其他应用
	 */
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;chrset=UTF-8");
		System.out.println("A:do something!");
		System.out.println("B:i couldn't,but i can ask somone to help you !");
		request.setAttribute("s","aaaaaaa");
		//将非表单数据添加到request域中
		//将请求转发到demo6中
		//注意：请求转发不能跳转到其他应用
//		request.getRequestDispatcher("/servlet/ServletDemo6").forward(request, response);
		//使用重定向
		//可以跳转到其他运用
		response.sendRedirect(request.getContextPath()+"/servlet/ServletDemo6");
		//请求包含
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
