package com.liuweicom.one_to_many;

import org.hibernate.Session;
import org.junit.Test;

import com.liuweicom.domain.Customer;
import com.liuweicom.domain.Order;
import com.liuweicom.utils.hibernateUtils;

public class Demo01 {
	@Test
	/**
	 * 1.����1�Զ��ϵ�У��������
	 * ����ӡ5�����
	 * ǰ����insert ==���������ά�����
	 * ��������ӡupdate ==��ά�����
	 * ���==������ָ����ϵ������һ����ά������һ����ά����ϵ
	 * Customer inverse���ԣ�true
	 * ֻ��ӡ3����� =�������order�Լ���ά��
	 */
	public void fun1(){
		Session session = hibernateUtils.openSession();
		session.beginTransaction();
		
		Customer c =new Customer();
		c.setName("tom");
		
		Order o1 = new Order();
		o1.setName("banrui");
		
		Order o2 = new Order();
		o1.setName("yuwenhu");
		
		o1.setCustomer(c);
		o2.setCustomer(c);

		c.getOrders().add(o1);
		c.setOrders(orders);
		
		session.save(c);
		session.save(o1);
		session.save(o2);
		
		session.getTransaction().commit();
		session.close();
	}
}
