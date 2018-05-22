package com.weiwei.f_properties;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.weiwei.domain.User;

public class TestDBCP {
	public static void main(String[] args) {
		String xmlPath = "com/weiwei/f_properties/bean.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		UserDao userDao = (UserDao) applicationContext.getBean("userDaoId");
		
		User user = (User) userDao.getById(1);
		System.out.println(user);
		
		List<User> list = userDao.findAll();
		System.out.println(list);
	}
}
