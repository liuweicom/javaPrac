package com.liuweicom.c_question;

import org.hibernate.Session;
import org.junit.Test;

import com.liuweicom.domain.User;
import com.liuweicom.utils.hibernateUtils;

public class Demo01 {
	@Test
	public void fun1(){
		Session session = hibernateUtils.openSession();
		session.beginTransaction();
		
		User u = new User();
		u.setId(99);
		session.persist(u);//体现的是持久化，persist提供的理念是将对象完整的持久化，持久化包括对象那个的id
		//在保存之间设置了id，那么就会将设置的id进行insert，但是，主键策略是由数据库来维护的，所以产生了矛盾，跑出异常
		
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void fun2(){
		Session session = hibernateUtils.openSession();
		session.beginTransaction();
		
		User u = new User();
		u.setId(99);
		session.save(u);//save方法，如果保存在对象之前设置了id，那么id被认为是无效的id，仍然会按照主键生成策略生成id
		
		session.getTransaction().commit();
		session.close();
	}
	
}
