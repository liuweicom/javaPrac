package com.itheima.web.action;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 静态数据封装与动态数据封装的第一种方法，在action方法上是一样的Struts的配置上不同
 * @author Administrator
 *
 */
public class DemoAction1 extends ActionSupport{
	private String username;
	private int age;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String addUser(){
		System.out.println(username+","+age);
		return null;
	}
}
