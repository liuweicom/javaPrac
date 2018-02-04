package com.itheima.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DoLoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String username=request.getParameter("username");
		String pwd=request.getParameter("pwd");
		if("tom".equals(username)&&"123".equals(pwd)){
			request.getSession().setAttribute("name", username);;
			request.getRequestDispatcher("/success.jsp").forward(request, response);
		}else{
			request.setAttribute("msg", "用户民或密码不正确");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
	
public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
	doGet(request,response);
	}
}
