package com.liuweicom.one_to_many;

import org.hibernate.Session;
import org.junit.Test;

import com.liuweicom.domain.Customer;
import com.liuweicom.domain.Order;
import com.liuweicom.utils.hibernateUtils;

public class Demo01 {
	@Test
	/**
	 * 1.测试1对多关系中，保存操作
	 * 功打印5条语句
	 * 前三条insert ==》保存对象，维护外键
	 * 后两条打印update ==》维护外键
	 * 解决==》单纯指定关系由其中一方来维护，另一方不维护关系
	 * Customer inverse属性：true
	 * 只打印3条语句 =》外键由order自己来维护
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
