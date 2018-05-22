package com.weiwei.c_hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import com.weiwei.utils.HebernateUtils;

public class Demo3 {
	@Test
	//�ҵ��ֲ����õ�HQL���
	public void fun1(){
		//3 ���session
		Session session = HebernateUtils.openSession();	
		session.beginTransaction();
		//-------------------
		Query query = session.getNamedQuery("com.weiwei.domain.Customer.bcd");
		List<Object> list = query.list();
		for(Object objs: list){
			System.out.println(objs);
		}
		
		//------------------
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	//��������=���ѿ���
	//����ʱҪ������ֵѿ�����
	public void fun2(){
		//3 ���session
		Session session = HebernateUtils.openSession();	
		session.beginTransaction();
		//-------------------
		Query query = session.getNamedQuery("abc");
		List<Object> list = query.list();
		for(Object objs: list){
			System.out.println(objs);
		}
		
		//------------------
		session.getTransaction().commit();
		session.close();
	}
}
