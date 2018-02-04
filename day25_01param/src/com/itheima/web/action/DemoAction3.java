package com.itheima.web.action;

import com.itheima.web.domain.User;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 动态参数封装的第二种方式：
 * 数据模型和动作方法分开来写
 * @author Administrator
 *
 */
public class DemoAction3 extends ActionSupport  {
	private User user=new User();
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String addUser(){
		System.out.println(user.getUsername()+","+user.getAge());
		return null;
	}
}
