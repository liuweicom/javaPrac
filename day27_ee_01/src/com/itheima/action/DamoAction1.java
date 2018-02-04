package com.itheima.action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DamoAction1 extends ActionSupport{
	public String execute(){
		//1.得到ActionContext对象
		ActionContext context=ActionContext.getContext();//这是从当前编程的局部变量中获取引用
		//往map中存入数据
		context.put("contextMap", "hello contextMap");
		//网session中存数据
		//第一种方式：获取key为session的map
		Map<String,Object> sessionAttribute = context.getSession();
		sessionAttribute.put("sessionMap", "hello sessionMap");
		//第二种方式：直接使用原始的HTTPSession对象
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("sessionMap1", "hello sessionMap1");
		//往ServletContext域中存数据
		//第一种方式，获取key值为application的map
		Map<String,Object> application = context.getApplication();
		application.put("applicationMap", "hello application");
		//第二种方式，获取原始ServletContext对象
		ServletContext application1=ServletActionContext.getServletContext();
		application1.setAttribute("application1", "hello aplication2");;
		return SUCCESS;
	}
}
