package com.liuweicom.b_cache;

import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import com.liuweicom.domain.User;
import com.liuweicom.utils.hibernateUtils;

public class Demo02 {
	@Test
	/**
	 * 1.���������ʹ�õ�save����
	 * ���������ʹ�õ�persist����
	 * ����û������
	 * persist���־ã�������Դ��JPA�ӿ�
	 * save�����棩������Դ��Hibernate
	 */
	public void fun1(){
		Session session = hibernateUtils.openSession();
		session.beginTransaction();
		
		User u1 = new User();
		u1.setName("hahha");
		u1.setPassword("1sdr4");
		
		session.save(u1);//�������÷���û������ֻ�����ֽеĲ�ͬ
		//session.persist(u1);
		
		
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	//HQL��ѯ�Ƿ��ʹ���Լ����棿HQL��ѯʱ������ʹ���Լ����棬���ǣ���ѯ�������뻺����
	public void fun2(){
		Session session = hibernateUtils.openSession();
		session.beginTransaction();
		
		List <User> list =  session.createQuery("from User").list();
		List <User> list2 =  session.createQuery("from User").list();
		List <User> list3 =  session.createQuery("from User").list();
		
		session.getTransaction().commit();//ִ��������
		session.close();
	}
	
	
	@Test
	public void fun3(){
		Session session = hibernateUtils.openSession();
		session.beginTransaction();
		
		List <User> list =  session.createQuery("from User").list();
		User u=(User) session.get(User.class, 1);//����ã�ֱ�Ӵӻ������ã���ΪHQL����ѯʱ����������뻺����
		
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	/**
	 * SQL��ѯ������᲻�����һ�������У�
	 * ����ѽ����װ�������У���������һ�������У�
	 * ���������װ�ɶ��󣬾Ͳ�����뻺���У����Ի�Ҫ�ڲ�ѯһ��
	 */
	public void fun4(){
		Session session = hibernateUtils.openSession();
		session.beginTransaction();
		
		List <User> list =  session.createSQLQuery("select * from t_user").list();
		User u=(User) session.get(User.class, 1);//���ﻹ��ѯһ�Σ�һ�����ѯ����
		
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void fun5(){
		Session session = hibernateUtils.openSession();
		session.beginTransaction();
		
		List <User> list =  session.createSQLQuery("select * from t_user").addEntity(User.class).list();
		User u=(User) session.get(User.class, 1);//���list��������뻺���У�����ֻҪ��ѯһ��
		
		session.getTransaction().commit();
		session.close();
	}
	
	/**
	 * criteria=���Ὣ��ѯ�������һ�������У����ǲ�ѯ����ʹ���Լ����棬��HQL��ѯ���һ��
	 */
}
