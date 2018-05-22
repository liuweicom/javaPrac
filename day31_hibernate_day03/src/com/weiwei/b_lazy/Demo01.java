package com.weiwei.b_lazy;

import org.hibernate.Session;
import org.junit.Test;

import com.weiwei.domain.Customer;
import com.weiwei.utils.HebernateUtils;

public class Demo01 {

	/**
	 * �༶��������
	 * load����
	 * class��lazy����
	 * Ĭ��ֵΪtrue��load���ʱ���᷵�ش�����󣬲���ѯ���ݿ⣬ʹ��ʱ�Ų�ѯ
	 */
	@Test
	public void fun1(){
		//3 ���session
				Session session = HebernateUtils.openSession();	
				session.beginTransaction();
				//-------------------
				Customer c = (Customer) session.load(Customer.class, 1);
				System.out.println(c.getName());//֪��������һ���ſ�ʼ��ѯcustomer�����
				
				//------------------
				session.getTransaction().commit();
				session.close();
	}
	
	
	/**
	 * �༶��������
	 * load����
	 * class��lazy����
	 * lazy:false��load����ִ�оͻᷢ��sql��䣬��get����һ��
	 */
	@Test
	public void fun2(){
		//3 ���session
				Session session = HebernateUtils.openSession();	
				session.beginTransaction();
				//-------------------
				Customer c = (Customer) session.load(Customer.class, 1);
				//lazy��falseʱΪ�����أ��ڲ�ѯ�ǣ��ͻ��ѯCustomer
				System.out.println(c.getName());
				
				//------------------
				session.getTransaction().commit();
				session.close();
	}
	
	@Test
	public void fun3(){
		//3 ���session
				Session session = HebernateUtils.openSession();	
				session.beginTransaction();
				//-------------------
				
				
				//------------------
				session.getTransaction().commit();
				session.close();
	}
}
