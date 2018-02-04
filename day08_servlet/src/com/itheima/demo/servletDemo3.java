package com.itheima.demo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class servletDemo3 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse resp){
		System.out.println("hello DoGet-----------");
		System.out.println("req.getRemoteAddr()");
	}
	
	protected void doPost(HttpServletRequest req,HttpServletResponse resp){
		System.out.println("----------DoPost-----------");
	}
}
