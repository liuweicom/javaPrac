package com.weiwei.e_api;

import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.junit.Test;

import com.weiwei.domain.Customer;
import com.weiwei.utils.HebernateUtils;

/**
 * ��������Ĭ����Ϊһ���ᷢ�ͱ���Ҫ�޸���ʹ�õ����ݣ����ҾͿ���Ϊ�Ҷ�ȡ�����ݼ���
 * ����/������=�������ɱ������߳�����������Ƕ�ȡ�Ļ���Ҷ����ԣ����Ȿ����ȡ���ݣ�����������
 * 	select * from table lock in share mode
 * д��/��������
 * д�����ܹ���,ֻҪ����Ϊ���ݼ�����д��,�����˾Ͳ���Ϊ���ݼ��κ���.
				select * from table for update ��д������������
 * @author ����
 *
 */
public class Demo02 {
	@Test
	//��֤c3p0���ӳ�
	public void fun1(){
		//3 ���session
		Session session = HebernateUtils.openSession();	
		session.beginTransaction();
		//
//		Customer c=(Customer)session.get(Customer.class, 2, LockOptions.UPGRADE);
//		System.out.println(c);
		//
		session.getTransaction().commit();
		session.close(); // ����״̬
	}
	
	@Test
	//������
	//����
	//�����������ͬʱ�����ö���ʱ����ʱ�����ݲ������޸ģ�һ�����ö���ʱ���ǿ����޸ĵ�
	public void fun2(){
		Session session = HebernateUtils.openSession();
		session.beginTransaction();
		//------------------------------------------------
		Customer c
		 = (Customer) session.get(Customer.class, 1, LockOptions.READ);
		
		System.out.println(c);
		//------------------------------------------------
		session.getTransaction().commit();
		session.close(); // ����״̬
	}
}
