package com.weiwei.e_api;

import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.junit.Test;

import com.weiwei.domain.Customer;
import com.weiwei.utils.HebernateUtils;

/**
 * 悲观锁：默认认为一定会发送别人要修改我使用的数据，那我就可以为我读取的数据枷锁
 * 读锁/共享锁=》读锁可被其他线程锁共享，如果是读取的话大家都可以，用这本锁读取数据，锁都可以用
 * 	select * from table lock in share mode
 * 写锁/排他锁，
 * 写锁不能共享,只要有人为数据加入了写锁,其他人就不能为数据加任何锁.
				select * from table for update （写锁、排它锁）
 * @author 工号
 *
 */
public class Demo02 {
	@Test
	//验证c3p0连接池
	public void fun1(){
		//3 获得session
		Session session = HebernateUtils.openSession();	
		session.beginTransaction();
		//
//		Customer c=(Customer)session.get(Customer.class, 2, LockOptions.UPGRADE);
//		System.out.println(c);
		//
		session.getTransaction().commit();
		session.close(); // 游离状态
	}
	
	@Test
	//悲观锁
	//读锁
	//如果有两个人同时，在用读锁时，此时的数据不允许修改，一个人用读锁时，是可以修改的
	public void fun2(){
		Session session = HebernateUtils.openSession();
		session.beginTransaction();
		//------------------------------------------------
		Customer c
		 = (Customer) session.get(Customer.class, 1, LockOptions.READ);
		
		System.out.println(c);
		//------------------------------------------------
		session.getTransaction().commit();
		session.close(); // 游离状态
	}
}
