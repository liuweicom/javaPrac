package com.itheima.web.action;

import com.itheima.web.domain.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DemoAction4 extends ActionSupport implements ModelDriven<User> {
	private User user=new User();
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	public String addUser(){
		System.out.println(user.getUsername()+","+user.getAge());
		return null;//不返回任何结果视图   NONE常量
	}
	
	
}
