package com.liuweicom.d_api;

import org.hibernate.Session;
import org.junit.Test;

import com.liuweicom.domain.User;
import com.liuweicom.utils.hibernateUtils;

public class Demo01 {
	@Test
	/**evict将缓存中的对象移除
	 * clear清空一级缓存
	 */
	public void fun1(){
		Session session = hibernateUtils.openSession();
		session.beginTransaction();
		
		User u=(User) session.get(User.class, 1);
		session.clear();
		User u2 =(User) session.get(User.class, 1);//清空缓存区，所以，会从新生成select语句
		
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	/**
	 * refresh刷新 ==》强制刷新缓存中的对象（用来解决缓存与数据库不同步的问题）
	 */
	public void fun2(){
		Session session = hibernateUtils.openSession();
		session.beginTransaction();
		
		User u=(User) session.get(User.class, 1);
		session.refresh(u);//会差两次，将缓存中的对象立即与数据库中的同步，会再发送一个SQL语句
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	/**
	 * flush 对比快照，并提交缓存对象
	 */
	public void fun3(){
		Session session = hibernateUtils.openSession();
		session.beginTransaction();
		
		User u=(User) session.get(User.class, 1);
//		u.setName("babay");
		session.flush();// 如果User对象，没有改变，那么不需要提交两次，缓存与快照不同，立即提交session中的对象，到数据库中
		
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	/**
	 * 代理主键为native时
	 * saveOrUpdate方法，可以同时完成保存或更新的操作
	 * 当主键为空时，==》save
	 * 当主键有值时==》update
	 */
	public void fun4(){
		Session session = hibernateUtils.openSession();
		session.beginTransaction();
		
		User u = new User();
		u.setName("boy0");
		u.setPassword("9809");
		session.saveOrUpdate(u);//此时相当于save的动作
		
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	/**
	 * 自然主键==》assign
	 * update与saveOrUpdate方法
	 * 在主键为空时，此时必须指定主键，所以会报错
	 * 主键有值，会先更据主键查询数据库
	 * 数据库存在==》执行update
	 * 数据库不存在 ==》执行save
	 */
	public void fun5(){
		Session session = hibernateUtils.openSession();
		session.beginTransaction();
		
		User u = new User();
		u.setId(99);
		u.setName("jachioas");
		u.setPassword("123");
		session.saveOrUpdate(u);
		
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	/**
	 * 在我们使用hibernate时候，主要要避免出现，两个相同的id对象，放入缓存中，会报错
	 */
	public void fun6(){
		Session session = hibernateUtils.openSession();
		session.beginTransaction();

		User u =(User) session.get(User.class, 1);
		session.evict(u);
		User u2 =(User) session.get(User.class, 1);
		session.update(u);//会报错，已经存在一个id=1的对象缓存，一个缓存中不能同时又两个相同的缓存，这是一个《MAP结构的存储，一id为键，对象为值
		
		session.getTransaction().commit();
		session.close();
	}
}
