package com.weiwei.e_api;

import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.junit.Test;

import com.weiwei.domain.Customer;
import com.weiwei.utils.HebernateUtils;

public class Demo03 {
	//�ֹ���
	//1.��ʵ�����������verion
	//hbm�����ļ��У�����version
	@Test
	public void fun1(){
		//3 ���session
		Session session = HebernateUtils.openSession();	
		session.beginTransaction();
		//
		Customer c=(Customer)session.get(Customer.class, 2);
		c.setName("jskd");
		
		System.out.println(c);
		//
		session.getTransaction().commit();
		session.close(); // ����״̬
	}
}
