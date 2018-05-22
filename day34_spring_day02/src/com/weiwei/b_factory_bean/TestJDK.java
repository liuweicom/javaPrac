package com.weiwei.b_factory_bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJDK {
	public static void main(String[] args) {
		String xmlPath = "com/weiwei/b_factory_bean/bean.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		UserService userService = (UserService) applicationContext.getBean("proxyServiceId");
		userService.addUser();
		userService.updateUser();
		userService.deleteUser();
		
//		ǰ
//		a_jdk_addUser
//		��
//		ǰ
//		a_jdk_updateUser
//		��
//		ǰ
//		a_jdk_deleteUser
//		��

	}
}
