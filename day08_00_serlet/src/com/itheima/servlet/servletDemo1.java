package com.itheima.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class servletDemo1 implements Servlet{
	//servlet�������ڵķ���  ��serve��һ�α����ʵ�ʱ����� ʵ����
	public servletDemo1(){
		System.out.println("***********ServletDemoִ����******");
	}
	

	
	//��servlert��һ�α����ʵ�ʱ����� ��ʼ��
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("*******init******");
	}

	//����ÿ�η���ʱ��Ҫ������
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("*********serviceִ����******");
	}

	//���� 
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("**********destoryִ����******");
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
