package com.itheima.web.action;
/**
 * 创建动作类的第一种方式：
 * 	创建一个普通的类
 * 	他就是一个POJO :一个原始的 老的 Java 对象
 * 	plain old java object
 * @author Administrator
 *
 */
public class DemoAction {
	public String user2(){
		System.out.println("user2++++++++++");
		return "success";
	}
}
