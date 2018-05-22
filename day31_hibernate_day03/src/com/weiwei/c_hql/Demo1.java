package com.weiwei.c_hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import com.weiwei.domain.Customer;
import com.weiwei.utils.HebernateUtils;
//HQL详解
public class Demo1 {
	
	@Test
	//HQL查询所有
	public void fun1(){
				//3 获得session
				Session session = HebernateUtils.openSession();	
				session.beginTransaction();
				//-------------------
				//存在这三种查询所有Customer语句的形式
//				Query query = session.createQuery("from Customer");
//				Query quer1 = session.createQuery("from Customer c");
				Query quer2 = session.createQuery("select c from Customer c");
				
				List<Customer> list = quer2.list();
				System.out.println(list);
				
//				Hibernate: 
//				    select
//				        customer0_.id as id3_,
//				        customer0_.name as name3_ 
//				    from
//				        t_customer customer0_
//				Hibernate: 
//				    select
//				        orders0_.cid as cid3_1_,
//				        orders0_.id as id1_,
//				        orders0_.id as id4_0_,
//				        orders0_.name as name4_0_,
//				        orders0_.cid as cid4_0_ 
//				    from
//				        t_order orders0_ 
//				    where
//				        orders0_.cid in (
//				            ?, ?
//				        )
				
				//------------------
				session.getTransaction().commit();
				session.close();
	}
	//HQL查询对象的某几个属性
	@Test
	public void fun2(){
				//3 获得session
				Session session = HebernateUtils.openSession();	
				session.beginTransaction();
				//-------------------
				Query query = session.createQuery("select c.id,c.name from Customer c");
				
				List<Object[]> list = query.list();
				for(Object[] o:list){
					System.out.println(Arrays.toString(o));
				}
				//------------------
				session.getTransaction().commit();
				session.close();
	}
	
	//投影查询
	//选择查询的基础上，想把查询结果封装到对象中
	@Test
	public void fun3(){
				//3 获得session
				Session session = HebernateUtils.openSession();	
				session.beginTransaction();
				//-------------------
				//此时必须保证Customer类中有Customer（Integer ID，String name）的方法
				Query query = session.createQuery("select new Customer(c.id,c.name) from Customer c");
				List<Customer> list = query.list();
				System.out.println(list);
				
//				[Customer [id=1, name=tom, orders=[]], Customer [id=2, name=jerry, orders=[]]]
				
				//------------------
				session.getTransaction().commit();
				session.close();
	}
	
	//排序
	@Test
	public void fun4(){
				//3 获得session
				Session session = HebernateUtils.openSession();	
				session.beginTransaction();
				//-------------------
				Query query = session.createQuery("from Customer c order by c.id desc");
				List<Customer> list = query.list();
				System.out.println(list);//此时只查询了Customer。并没有触发相关联的表查询成功，此时Customer的tostring方法，不要包含Order属性，不然会报错
				
//				 select
//			        customer0_.id as id3_,
//			        customer0_.name as name3_ 
//			    from
//			        t_customer customer0_ 
//			    order by
//			        customer0_.id desc
				//[Customer [id=2, name=jerry], Customer [id=1, name=tom]]
				//------------------
				session.getTransaction().commit();
				session.close();
	}
	
	//分页
	@Test
	public void fun5(){
				//3 获得session
				Session session = HebernateUtils.openSession();	
				session.beginTransaction();
				//-------------------
				Query query = session.createQuery("from Customer c order by c.id asc");
				//setFirstResult:(当前页数-1)*每页最大记录数
				//
				query.setFirstResult(0);//从哪个索引开始取数据，包裹索引本身的记录
				query.setMaxResults(2);//查询出多少条数据
				List<Customer> list = query.list();
				
				//[Customer [id=1, name=tom], Customer [id=2, name=jerry]]
				System.out.println(list);
				
				//------------------
				session.getTransaction().commit();
				session.close();
	}
	//绑定参数
	@Test
	public void fun6(){
				//3 获得session
				Session session = HebernateUtils.openSession();	
				session.beginTransaction();
				//-------------------
//				Query query = session.createQuery("from Customer c where c.id=?");
//				//参数1：？占位符的所以位置，第二个为ID=2
//				query.setInteger(0,2);//这个是更具id的类型选择的Integer类型选的setInteger
				Query query = session.createQuery("from Customer c where c.id=:haha");
				//参数1：参数占位符的名称，第二个为ID=2
				query.setInteger("haha",2);
				
				Customer c = (Customer)query.uniqueResult();
				System.out.println(c);
				//
				//
				//------------------
				session.getTransaction().commit();
				session.close();
	}
	//聚合函数
	@Test
	public void fun7(){
				//3 获得session
				Session session = HebernateUtils.openSession();	
				session.beginTransaction();
				//-------------------
				Query query = session.createQuery("select count(*) from Customer c ");
				Query query1 = session.createQuery("select avg(c.id) from Customer c ");
				Query query2 = session.createQuery("select sum(c.id) from Customer c ");
				Query query3 = session.createQuery("select max(c.id) from Customer c ");
				Query query4 = session.createQuery("select min(c.id) from Customer c ");
				
				Object count = query.uniqueResult();
				System.out.println(count);
				//------------------
				session.getTransaction().commit();
				session.close();
	}
	
	//group by ..having
	@Test
	public void fun8(){
				//3 获得session
				Session session = HebernateUtils.openSession();	
				session.beginTransaction();
				//-------------------
				Query query = session.createQuery("select o.customer, count(o) from Order o group by o.customer having count(o)>1");
				List<Object[]> list = query.list();
				for(Object[] objs: list){
					System.out.println(Arrays.toString(objs));
				}
				
				//------------------
				session.getTransaction().commit();
				session.close();
	}
	
}
