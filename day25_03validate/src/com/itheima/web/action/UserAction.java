package com.itheima.web.action;

import org.apache.commons.lang3.StringUtils;

import com.itheima.web.domain.User;
import com.itheima.web.service.UserServer;
import com.itheima.web.service.Impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	private UserServer service=new UserServiceImpl();
	
	private User user=new User();
	
	/**
	 * 在struts2的框架中，它也提供了一个Map<表单的字段名，错误提示>
	 * 我们要做的：
	 * 往map中存入错误信息
	 * 
	 * 编程时验证：
	 * 动作类必须继承ActionSupport
	 * 重写validate方法
	 * 
	 * validate 方法会在动作方法之前，进行验证
	 * 当重写了validate方法，他会对动作类的所有动作方法进行验证
	 * 第一种方式：
	 * 	使用@SkipValidationdation注解
	 * 第二种方式：
	 * 定义验证方法的名称：validate+动作名称，动作名称的首字符还要大写
	 * 
	 */
//	public void validate(){
//		//当重写了validate方法，他会对动作类的所有动作方法进行验证
//		if(StringUtils.isEmpty(user.getUsername())){
//			//存入错误信息，直接调用父类的addFieldError方法，存入错误信息，第一个参数是表单的name属性值，第二个参数是错误提示
//			addFieldError("username","请输入用户名");
//		}
//	}
	
	//方法二：
	public void validateRegist(){
		if(StringUtils.isEmpty(user.getUsername())){
			//存入错误信息，直接调用父类的addFieldError方法，存入错误信息，第一个参数是表单的name属性值，第二个参数是错误提示
			addFieldError("username","请输入用户名");
		}
	}
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
