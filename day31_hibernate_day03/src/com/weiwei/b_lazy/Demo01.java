package com.weiwei.b_lazy;

import org.hibernate.Session;
import org.junit.Test;

import com.weiwei.domain.Customer;
import com.weiwei.utils.HebernateUtils;

public class Demo01 {

	/**
	 * 类级别懒加载
	 * load方法
	 * class：lazy属性
	 * 默认值为true，load获得时，会返回代理对象，不查询数据库，使用时才查询
	 */
	@Test
	public void fun1(){
		//3 获得session
				Session session = HebernateUtils.openSession();	
				session.beginTransaction();
				//-------------------
				Customer c = (Customer) session.load(Customer.class, 1);
				System.out.println(c.getName());//知道走完这一步才开始查询customer的语句
				
				//------------------
				session.getTransaction().commit();
				session.close();
	}
	
	
	/**
	 * 类级别懒加载
	 * load方法
	 * class：lazy属性
	 * lazy:false，load方法执行就会发送sql语句，与get方法一致
	 */
	@Test
	public void fun2(){
		//3 获得session
				Session session = HebernateUtils.openSession();	
				session.beginTransaction();
				//-------------------
				Customer c = (Customer) session.load(Customer.class, 1);
				//lazy：false时为懒加载，在查询是，就会查询Customer
				System.out.println(c.getName());
				
				//------------------
				session.getTransaction().commit();
				session.close();
	}
	
	@Test
	public void fun3(){
		//3 获得session
				Session session = HebernateUtils.openSession();	
				session.beginTransaction();
				//-------------------
				
				
				//------------------
				session.getTransaction().commit();
				session.close();
	}
}
