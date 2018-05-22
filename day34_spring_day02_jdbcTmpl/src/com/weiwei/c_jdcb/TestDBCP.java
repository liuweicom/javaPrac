package com.weiwei.c_jdcb;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.weiwei.domain.User;

public class TestDBCP {
	public static void main(String[] args) {
		User user = new User();
		user.setId(1);
		user.setUsername("gouzi");
		user.setPassword("998");
		
		String xmlPath = "com/weiwei/c_jdcb/bean.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		UserDao userDao = (UserDao) applicationContext.getBean("userDaoId");
		
		userDao.update(user);
	}
}
