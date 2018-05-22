package com.weiwei.mybatis.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.weiwei.mybatis.dao.UserDao;
import com.weiwei.mybatis.mapper.UserMapper;
import com.weiwei.mybatis.pojo.User;

public class UserDaoTest {

	private ApplicationContext applicationContext;
	
	@Before
	public void setUp() throws Exception{
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
	}
	
	@Test
	public void test () throws Exception{
		UserDao userdao = (UserDao) applicationContext.getBean("userDao");
		User user = userdao.findUserById(1);
		System.out.println(user);
	}
	
	@Test
	public void test2 () throws Exception{
		UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
		User user = userMapper.findUserById(1);
		System.out.println(user);
	}
	
	
	
	
	
	
	
	
	
	
	
}
