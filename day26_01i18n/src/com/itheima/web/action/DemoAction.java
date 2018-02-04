package com.itheima.web.action;

import com.opensymphony.xwork2.ActionSupport;

public class DemoAction extends ActionSupport{
	public String execute(){
		String value=getText("key");
		System.out.println(value);
		return SUCCESS;
	}
}
