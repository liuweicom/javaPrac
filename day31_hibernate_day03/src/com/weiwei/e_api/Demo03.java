package com.weiwei.e_api;

import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.junit.Test;

import com.weiwei.domain.Customer;
import com.weiwei.utils.HebernateUtils;

public class Demo03 {
	//乐观锁
	//1.在实体中添加属性verion
	//hbm配置文件中，配置version
	@Test
	public void fun1(){
		//3 获得session
		Session session = HebernateUtils.openSession();	
		session.beginTransaction();
		//
		Customer c=(Customer)session.get(Customer.class, 2);
		c.setName("jskd");
		
		System.out.println(c);
		//
		session.getTransaction().commit();
		session.close(); // 游离状态
	}
}
