package com.itheima.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public class ServletDemo3 extends HttpServlet {
	
	protected void doGet (HttpServletRequest req,HttpServlet resp){
		System.out.println("********doGet******");
		System.out.println(req.getRemoteAddr());
	}
}
