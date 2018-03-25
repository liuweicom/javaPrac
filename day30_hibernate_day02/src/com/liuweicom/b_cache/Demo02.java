package com.liuweicom.b_cache;

import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import com.liuweicom.domain.User;
import com.liuweicom.utils.hibernateUtils;

public class Demo02 {
	@Test
	/**
	 * 1.保存对象是使用的save方法
	 * 保存对象是使用的persist方法
	 * 区别？没有区别？
	 * persist（持久）方法来源于JPA接口
	 * save（保存）方法来源于Hibernate
	 */
	public void fun1(){
		Session session = hibernateUtils.openSession();
		session.beginTransaction();
		
		User u1 = new User();
		u1.setName("hahha");
		u1.setPassword("1sdr4");
		
		session.save(u1);//两个在用法上没有区别，只有名字叫的不同
		//session.persist(u1);
		
		
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	//HQL查询是否会使用以及缓存？HQL查询时，不会使用以及缓存，但是，查询结果会放入缓存中
	public void fun2(){
		Session session = hibernateUtils.openSession();
		session.beginTransaction();
		
		List <User> list =  session.createQuery("from User").list();
		List <User> list2 =  session.createQuery("from User").list();
		List <User> list3 =  session.createQuery("from User").list();
		
		session.getTransaction().commit();//执行了三次
		session.close();
	}
	
	
	@Test
	public void fun3(){
		Session session = hibernateUtils.openSession();
		session.beginTransaction();
		
		List <User> list =  session.createQuery("from User").list();
		User u=(User) session.get(User.class, 1);//这次拿，直接从缓存里拿，因为HQL，查询时，将结果放入缓存中
		
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	/**
	 * SQL查询，结果会不会放入一级缓存中，
	 * 如果把结果封装到对象中，对象会放入一级缓存中，
	 * 如果不防封装成对象，就不会放入缓存中，所以还要在查询一次
	 */
	public void fun4(){
		Session session = hibernateUtils.openSession();
		session.beginTransaction();
		
		List <User> list =  session.createSQLQuery("select * from t_user").list();
		User u=(User) session.get(User.class, 1);//这里还查询一次，一共会查询两次
		
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void fun5(){
		Session session = hibernateUtils.openSession();
		session.beginTransaction();
		
		List <User> list =  session.createSQLQuery("select * from t_user").addEntity(User.class).list();
		User u=(User) session.get(User.class, 1);//这里，list将结果放入缓存中，所以只要查询一次
		
		session.getTransaction().commit();
		session.close();
	}
	
	/**
	 * criteria=》会将查询结果放入一级缓存中，但是查询不会使用以及缓存，与HQL查询结果一致
	 */
}
