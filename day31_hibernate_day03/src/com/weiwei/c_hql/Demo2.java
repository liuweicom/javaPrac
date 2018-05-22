package com.weiwei.c_hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import com.weiwei.utils.HebernateUtils;

//HQL ������

public class Demo2 {
	@Test
	//��������=���ѿ���
	//����ʱҪ������ֵѿ�����
	public void fun1(){
		//3 ���session
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
	//������
	//��ʽ������=���ڵѿ������Ļ����Ϲ�����Ч����
	public void fun2(){
		//3 ���session
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
	//������֮��ʾ���ӣ������У�=��inner join
	//List<Object[]>
	//���еľ���Object[] => [Customer,Order]
	public void fun3(){
		//3 ���session
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
	//������֮��ʾ���ӣ����У�=��inner join
		//List<Customer>
		//�������ӽ���װ�縸�У���װ��һ������
	public void fun4(){
		//3 ���session
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
	//��������
	//left [outer] join
	public void fun5(){
		//3 ���session
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
	//��������   ����
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
		
		
//		Customer [id=1, name=tom, orders=[Order [id=2, name=�ϲ�], Order [id=1, name=ե��]]]
//				Customer [id=1, name=tom, orders=[Order [id=2, name=�ϲ�], Order [id=1, name=ե��]]]
//				Customer [id=2, name=jerry, orders=[Order [id=3, name=�ǹ�], Order [id=4, name=����]]]
//				Customer [id=2, name=jerry, orders=[Order [id=3, name=�ǹ�], Order [id=4, name=����]]]
//				Customer [id=3, name=rouse, orders=[]]
		//------------------
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	//��������
	//right [outer] join
	public void fun7(){
		//3 ���session
		Session session = HebernateUtils.openSession();	
		session.beginTransaction();
		//-------------------
		Query query = session.createQuery("from Customer c right outer join c.orders");
		List<Object[]> list = query.list();
		for(Object[] objs: list){
			System.out.println(Arrays.toString(objs));
		}
		
//		[Customer [id=1, name=tom, orders=[Order [id=1, name=ե��], Order [id=2, name=�ϲ�]]], Order [id=1, name=ե��]]
//				[Customer [id=1, name=tom, orders=[Order [id=1, name=ե��], Order [id=2, name=�ϲ�]]], Order [id=2, name=�ϲ�]]
//				[Customer [id=2, name=jerry, orders=[Order [id=4, name=����], Order [id=3, name=�ǹ�]]], Order [id=3, name=�ǹ�]]
//				[Customer [id=2, name=jerry, orders=[Order [id=4, name=����], Order [id=3, name=�ǹ�]]], Order [id=4, name=����]]
//				[null, Order [id=5, name=����]]
		//�������ӣ��ұߵı����Ϊ�յģ���ߵı�Ϊ�ջᶪ��
		
		//------------------
		session.getTransaction().commit();
		session.close();
	}
	
	
	@Test
	//��������   ����
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
		
		
//		Customer [id=1, name=tom, orders=[Order [id=2, name=�ϲ�], Order [id=1, name=ե��]]]
//				Customer [id=1, name=tom, orders=[Order [id=2, name=�ϲ�], Order [id=1, name=ե��]]]
//				Customer [id=2, name=jerry, orders=[Order [id=3, name=�ǹ�], Order [id=4, name=����]]]
//				Customer [id=2, name=jerry, orders=[Order [id=3, name=�ǹ�], Order [id=4, name=����]]]
//				null
		//------------------
		session.getTransaction().commit();
		session.close();
	}
}
