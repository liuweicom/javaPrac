package com.weiwei.c_hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import com.weiwei.utils.HebernateUtils;

public class Demo3 {
	@Test
	//找到局部配置的HQL语句
	public void fun1(){
		//3 获得session
		Session session = HebernateUtils.openSession();	
		session.beginTransaction();
		//-------------------
		Query query = session.getNamedQuery("com.weiwei.domain.Customer.bcd");
		List<Object> list = query.list();
		for(Object objs: list){
			System.out.println(objs);
		}
		
		//------------------
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	//交叉连接=》笛卡尔
	//开发时要避免出现笛卡尔基
	public void fun2(){
		//3 获得session
		Session session = HebernateUtils.openSession();	
		session.beginTransaction();
		//-------------------
		Query query = session.getNamedQuery("abc");
		List<Object> list = query.list();
		for(Object objs: list){
			System.out.println(objs);
		}
		
		//------------------
		session.getTransaction().commit();
		session.close();
	}
}
