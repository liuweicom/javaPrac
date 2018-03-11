package com.liuweicom.a_hello;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

public class Test01 {

	@Test
	public void fun1() {
		//1.读取配置文件
		Configuration con = new Configuration().configure();
		//2.根据配置，创建Factory
		SessionFactory sessionFactory = con.buildSessionFactory();
		//3.更据获得操作数据库的session对象
		Session session = sessionFactory.openSession();
		//4.操作数据库
		User u = new User();
		u.setName("zhangsan");
		u.setPassword("1234");
		session.save(u);
		//5.关闭资源
		session.close();
		sessionFactory.close();
		
	}
}
