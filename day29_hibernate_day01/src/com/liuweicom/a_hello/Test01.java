package com.liuweicom.a_hello;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

public class Test01 {

	@Test
	public void fun1() {
		//1.��ȡ�����ļ�
		Configuration con = new Configuration().configure();
		//2.�������ã�����Factory
		SessionFactory sessionFactory = con.buildSessionFactory();
		//3.���ݻ�ò������ݿ��session����
		Session session = sessionFactory.openSession();
		//4.�������ݿ�
		User u = new User();
		u.setName("zhangsan");
		u.setPassword("1234");
		session.save(u);
		//5.�ر���Դ
		session.close();
		sessionFactory.close();
		
	}
}
