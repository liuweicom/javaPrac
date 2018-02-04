package com.itheima.web.action;

import com.itheima.web.domain.User;
import com.itheima.web.service.UserServer;
import com.itheima.web.service.Impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	private UserServer service=new UserServiceImpl();
	
	private User user=new User();
	
	
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	public String register(){
		//1.更据用户名，获取数据库的用户对象
		System.out.println(1);
		System.out.println(1);
		
		System.out.println(1);
		
		System.out.println(1);
		User dbUser=service.findUserByUsername(user.getUsername());
		//2.判断对象是否存在
		if(dbUser!=null){
		
			return "exists";
		}
		//3.不存在，保存用户
		
//		信息
		int res=service.register(user);
		//4.如果用户不大于0，返回null
		if(res>0){
			return SUCCESS;
		}
		return "exists";
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	

}
