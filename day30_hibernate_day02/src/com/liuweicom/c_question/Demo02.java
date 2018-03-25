package com.liuweicom.c_question;

import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import com.liuweicom.domain.User;
import com.liuweicom.utils.hibernateUtils;

public class Demo02 {
	@Test
	public void fun1(){
		Session session = hibernateUtils.openSession();
		session.beginTransaction();
		//------------------------------------------------
		List<User> list1 = session.createQuery("from User").list(); // 发送sql
		
		List<User> list2 = session.createQuery("from User").list();// 发送sql
		
		System.out.println(list1.get(0)==list2.get(0));//true =>
		/**
		 * 问题，为什么每次生成了select语句，但是，还是会相等了：因为每次调用createQuery，都会去后台查询数据库
		 * ，但会的结果，先去session缓存中查看是否存在保存，
		 * 如果已经存在，那么不会再次存入，直接从缓存中取出来，所以地址还是一样的
		 */
		//------------------------------------------------
		session.getTransaction().commit();
		session.close(); // 游离状态
	}
	
	/**
	 * 缓存中的数据如果与数据库中的不同步，会怎么样？
	 * 会优先使用缓存中的，解决办法，最好还是使用JDBC
	 * 在一级缓存中出现的问题的几率比较小
	 * 因为一级缓存从openSession，生命周期开始，带session。close（），一级缓存生命周期结束
	 */
}
