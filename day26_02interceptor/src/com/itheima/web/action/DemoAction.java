package com.itheima.web.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class DemoAction extends ActionSupport {
	public String login(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute("user", "test");
		return SUCCESS;
	}
	
	public String execute(){
		return SUCCESS;
	}
}
