package com.itheima.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class servletDemo1 implements Servlet{
	//servlet生命周期的方法  在serve第一次被访问的时候调用 实例化
	public servletDemo1(){
		System.out.println("***********ServletDemo执行了******");
	}
	

	
	//在servlert第一次被访问的时候调用 初始化
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("*******init******");
	}

	//服务，每次访问时都要被调用
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("*********service执行了******");
	}

	//销毁 
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("**********destory执行了******");
	}
	
	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
