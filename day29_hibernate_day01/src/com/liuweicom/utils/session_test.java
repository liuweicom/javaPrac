package com.liuweicom.utils;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.Test;

import com.liuweicom.a_hello.User;
public class session_test {
	@Test
	public void fun1(){
		org.hibernate.Session session = hibernateUtils.openSession();
		Transaction ts = session.beginTransaction();
		
		User u = new User();
		u.setName("gouzi");
		session.save(u);
		
		ts.commit();
		session.close();
	}
	
	@Test
	public void fun2(){
		org.hibernate.Session session = hibernateUtils.openSession();
		Transaction ts = session.beginTransaction();
		
		User u = (User) session.get(User.class, 1);
		u.setName("gouzi");
		session.update(u);
		
		ts.commit();
		session.close();
	}
}
