package com.weiwei.e_anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJDK {
	public static void main(String[] args) {
		String xmlPath = "com/weiwei/e_anno/bean.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		UserService userService = (UserService) applicationContext.getBean("userServiceId");
		userService.addUser();
//		userService.updateUser();
		userService.deleteUser();
		
//		 java.lang.IllegalArgumentException 非法参数异常

	}
}
