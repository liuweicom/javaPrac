package com.weiwei.e_api;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.weiwei.domain.Customer;
import com.weiwei.utils.HebernateUtils;

public class Demo1 {
	@Test
	//��֤c3p0���ӳ�
	public void fun1(){
		//3 ���session
		Session session = HebernateUtils.openSession();	
		session.beginTransaction();
		//
		System.out.println(session);
		//
		session.getTransaction().commit();
		session.close(); // ����״̬
	}
}
