package com.weiwei.c_hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import com.weiwei.utils.HebernateUtils;

//HQL 表连接

public class Demo2 {
	@Test
	//交叉连接=》笛卡尔
	//开发时要避免出现笛卡尔基
	public void fun1(){
		//3 获得session
		Session session = HebernateUtils.openSession();	
		session.beginTransaction();
		//-------------------
		Query query = session.createQuery("from Customer,Order o");
		List<Object[]> list = query.list();
		for(Object[] objs: list){
			System.out.println(Arrays.toString(objs));
		}
		
		//------------------
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	//内连接
	//隐式内连接=》在笛卡尔基的基础上过滤无效数据
	public void fun2(){
		//3 获得session
		Session session = HebernateUtils.openSession();	
		session.beginTransaction();
		//-------------------
		Query query = session.createQuery("from Customer c,Order o where o.customer = c");
		List<Object[]> list = query.list();
		for(Object[] objs: list){
			System.out.println(Arrays.toString(objs));
		}
		
		//------------------
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	//内链接之显示连接（非迫切）=》inner join
	//List<Object[]>
	//迫切的就是Object[] => [Customer,Order]
	public void fun3(){
		//3 获得session
		Session session = HebernateUtils.openSession();	
		session.beginTransaction();
		//-------------------
		Query query = session.createQuery("from Customer c inner join  c.orders");
		List<Object[]> list = query.list();
		for(Object[] objs: list){
			System.out.println(Arrays.toString(objs));
		}
		
		//------------------
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	//内链接之显示连接（迫切）=》inner join
		//List<Customer>
		//迫切连接将子装如父中，组装成一个对象
	public void fun4(){
		//3 获得session
		Session session = HebernateUtils.openSession();	
		session.beginTransaction();
		//-------------------
		Query query = session.createQuery("from Customer c inner join fetch c.orders");
		List<Object> list = query.list();
		for(Object objs: list){
			System.out.println(objs);
		}
		
		//------------------
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	//左外连接
	//left [outer] join
	public void fun5(){
		//3 获得session
		Session session = HebernateUtils.openSession();	
		session.beginTransaction();
		//-------------------
		Query query = session.createQuery("from Customer c left outer join c.orders");
		List<Object[]> list = query.list();
		for(Object[] objs: list){
			System.out.println(Arrays.toString(objs));
		}
		
		//------------------
		session.getTransaction().commit();
		session.close();
	}
	
	
	@Test
	//左外连接   迫切
		//left [outer] join fetch
	public void fun6(){
		Session session = HebernateUtils.openSession();	
		session.beginTransaction();
		//-------------------
		Query query = session.createQuery("from Customer c left outer join fetch c.orders");
		List<Object> list = query.list();
		for(Object objs: list){
			System.out.println(objs);
		}
		
		
//		Customer [id=1, name=tom, orders=[Order [id=2, name=紫菜], Order [id=1, name=榨菜]]]
//				Customer [id=1, name=tom, orders=[Order [id=2, name=紫菜], Order [id=1, name=榨菜]]]
//				Customer [id=2, name=jerry, orders=[Order [id=3, name=糖果], Order [id=4, name=酸奶]]]
//				Customer [id=2, name=jerry, orders=[Order [id=3, name=糖果], Order [id=4, name=酸奶]]]
//				Customer [id=3, name=rouse, orders=[]]
		//------------------
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	//右外连接
	//right [outer] join
	public void fun7(){
		//3 获得session
		Session session = HebernateUtils.openSession();	
		session.beginTransaction();
		//-------------------
		Query query = session.createQuery("from Customer c right outer join c.orders");
		List<Object[]> list = query.list();
		for(Object[] objs: list){
			System.out.println(Arrays.toString(objs));
		}
		
//		[Customer [id=1, name=tom, orders=[Order [id=1, name=榨菜], Order [id=2, name=紫菜]]], Order [id=1, name=榨菜]]
//				[Customer [id=1, name=tom, orders=[Order [id=1, name=榨菜], Order [id=2, name=紫菜]]], Order [id=2, name=紫菜]]
//				[Customer [id=2, name=jerry, orders=[Order [id=4, name=酸奶], Order [id=3, name=糖果]]], Order [id=3, name=糖果]]
//				[Customer [id=2, name=jerry, orders=[Order [id=4, name=酸奶], Order [id=3, name=糖果]]], Order [id=4, name=酸奶]]
//				[null, Order [id=5, name=桔子]]
		//右外连接，右边的表可以为空的，左边的表为空会丢弃
		
		//------------------
		session.getTransaction().commit();
		session.close();
	}
	
	
	@Test
	//右外连接   迫切
		//right [outer] join
	public void fun8(){
		Session session = HebernateUtils.openSession();	
		session.beginTransaction();
		//-------------------
		Query query = session.createQuery("from Customer c right outer join fetch c.orders");
		List<Object> list = query.list();
		for(Object objs: list){
			System.out.println(objs);
		}
		
		
//		Customer [id=1, name=tom, orders=[Order [id=2, name=紫菜], Order [id=1, name=榨菜]]]
//				Customer [id=1, name=tom, orders=[Order [id=2, name=紫菜], Order [id=1, name=榨菜]]]
//				Customer [id=2, name=jerry, orders=[Order [id=3, name=糖果], Order [id=4, name=酸奶]]]
//				Customer [id=2, name=jerry, orders=[Order [id=3, name=糖果], Order [id=4, name=酸奶]]]
//				null
		//------------------
		session.getTransaction().commit();
		session.close();
	}
}
