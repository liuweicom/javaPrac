package com.weiwei.d_qbc;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.weiwei.domain.Customer;
import com.weiwei.utils.HebernateUtils;

public class Demo1 {
	@Test
	public void fun1(){
		//д��service��
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		dc.add(Restrictions.eq("id",1));
		//3 ���session
		Session session = HebernateUtils.openSession();	
		session.beginTransaction();
		//
		Criteria c = dc.getExecutableCriteria(session);
		
		System.out.println(c.list());
		//
		session.getTransaction().commit();
		session.close(); // ����״̬
	}
}
