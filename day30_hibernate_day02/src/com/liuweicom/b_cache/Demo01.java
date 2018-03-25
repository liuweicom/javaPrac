package com.liuweicom.b_cache;

import org.hibernate.Session;
import org.junit.Test;

import com.liuweicom.domain.User;
import com.liuweicom.utils.hibernateUtils;

public class Demo01 {
	//֤������Ĵ���
	@Test
	public void fun1(){
		Session session = hibernateUtils.openSession();
		session.beginTransaction();
		
		User u1 = (User) session.get(User.class, 1);//����select��䣬�����ݿ�ȡ����¼������װ�ɶ��󣬳־û�״̬���� =���浽����
		User u2 = (User) session.get(User.class, 1);//�ٳԲ�ѯ�ǣ���ӻ����в��ң�����select
		User u3 = (User) session.get(User.class, 1);//�ٳԲ�ѯ�ǣ���ӻ����в��ң�����select
		
		System.out.println(u1 == u2);//true
		
		System.out.println(u1 == u2);//true
		
		session.getTransaction().commit();
		session.close();
	}
	
	//֤��session����Ŀ���
		@Test
		public void fun4(){
			Session session = hibernateUtils.openSession();
			session.beginTransaction();
			
			User u1 = (User) session.get(User.class, 1);//����select��䣬�����ݿ�ȡ����¼������װ�ɶ���
			session.update(u1);
			
			session.getTransaction().commit();
			session.close();//����״̬
		}
		
		//֤������Ĵ���
		@Test
		public void fun2(){
			Session session = hibernateUtils.openSession();
			session.beginTransaction();
			
			User u1 = new User();
			u1.setId(1);
			u1.setName("hahha");
			u1.setPassword("1234");
			
			session.update(u1);//��Ȼu1�е����ݺ����ݿ��д洢������һ����
//			����Ҳֻ�Ǹ��µ�session�Ļ����У���session����Ϊ�գ�
//			��session��ͬ��������Ҫͬ�������ݿ���
			session.getTransaction().commit();
			session.close();
		}
		
		//����һ������Ч�ʵ����
		@Test
		public void fun3(){
			Session session = hibernateUtils.openSession();
			session.beginTransaction();
			
			User u1 = (User) session.get(User.class, 1);//����select��䣬�����ݿ�ȡ����¼������װ�ɶ��󣬳־û�״̬���� =���浽����
			u1.setName("tom");
			session.update(u1);
			u1.setName("k=jsck");
			session.update(u1);
			u1.setName("hahha");
			session.update(u1);//���Ｔʹ�������name��������commit�ύ��ʱ�����һ��session�����е����ݣ���session�п���յ�����ʱһ���ģ����Բ��ø���
			session.getTransaction().commit();
			session.close();
		}
		
		//*****�־û��ı���
		//���ʾ��Ǵ��ڻ����еĶ��󣬾��ǳ־û�״̬�������е����ݣ�������Ϳ����е�����һ�����ͻ��Զ����µ����ݿ���
}
