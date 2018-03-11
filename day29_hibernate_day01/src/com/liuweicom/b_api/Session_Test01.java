package com.liuweicom.b_api;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

import com.liuweicom.a_hello.User;

public class Session_Test01 {
	@Test
	//session 对象用于操作数据库
	//增
	public void fun1(){
		/**
		 * 1.加载配置
		 * 2.根据configuration配置信息创建sessionFactory
		 * 3.获得session
		 * 4.进行数据库操作
		 * 5.关闭资源
		 */
		Configuration configure = new Configuration().configure();
		SessionFactory buildSessionFactory = configure.buildSessionFactory();
		Session openSession = buildSessionFactory.openSession();
		
		User u=new User();
		u.setName("jerry");
		u.setPassword("2345");
		
		openSession.save(u);
		
		openSession.close();
		buildSessionFactory.close();
	}
	
	@Test
	//改
	public void func2(){
		/**
		 * 1.加载配置
		 * 2.根据configuration配置信息创建sessionFactory
		 * 3.获得session
		 * 4.打开事物(有关查询的，都要打开事物)
		 * 5.查询你要修改的对象（*****）
		 * 6.在查询结果上，进行修改
		 * 7。提价事物
		 * 8.关闭资源
		 */
		Configuration configure = new Configuration().configure();
		SessionFactory buildSessionFactory = configure.buildSessionFactory();
		Session openSession = buildSessionFactory.openSession();
		
		Transaction beginTransaction = openSession.beginTransaction();
		
		User user=(User) openSession.get(User.class, 1);
		user.setName("baobao");
		
		openSession.update(user);
		
		beginTransaction.commit();
		
		openSession.close();
		buildSessionFactory.close();
	}
	
	@Test
	//删
	public void fun3(){
		/**
		 * 1.加载配置
		 * 2.根据configuration配置信息创建sessionFactory
		 * 3.获得session
		 * 4.打开事物
		 * 5.查询出你要修改的对象
		 * 6.更据Id删除
		 * 7.提交事物
		 * 8.关闭资源
		 */
		
		Configuration configure = new Configuration().configure();
		SessionFactory buildSessionFactory = configure.buildSessionFactory();
		Session openSession = buildSessionFactory.openSession();
		
		Transaction beginTransaction = openSession.beginTransaction();
		User user =(User) openSession.get(User.class,2);
		openSession.delete(user);
		
		beginTransaction.commit();
		openSession.close();
		buildSessionFactory.close();
	}
	
	@Test
	//查询----get
	public void fun4(){
		/**
		 * 1.加载配置
		 * 2.根据configuration配置信息创建sessionFactory
		 * 3.获得session
		 * 4.打开事物
		 * 5.查询出你要修改的对象
		 * 7.提交事物
		 * 8.关闭资源
		 */
		Configuration configure = new Configuration().configure();
		SessionFactory buildSessionFactory = configure.buildSessionFactory();
		Session openSession = buildSessionFactory.openSession();
		Transaction beginTransaction = openSession.beginTransaction();
		
		User user =(User) openSession.get(User.class,3);
		System.out.println(user.toString());
		beginTransaction.commit();
		
		openSession.close();
		buildSessionFactory.close();
		
	}
	
	@Test
	//查询----load
	/**
	 * get:方法被调用时立刻，发送sql语句查询
	 * load： 调用时并没有查询数据库，当我们需要使用该对象的时候，才去查询数据
	 */
	public void fun5(){
		Configuration configure = new Configuration().configure();
		SessionFactory buildSessionFactory = configure.buildSessionFactory();
		Session openSession = buildSessionFactory.openSession();
		Transaction beginTransaction = openSession.beginTransaction();
		
		User user = (User) openSession.load(User.class, 3);
		System.out.println(user);
		beginTransaction.commit();
		openSession.close();
		buildSessionFactory.close();
		
	}
	
	
	@Test
	//查询
	//查询所有User
	public void fun6(){
		/**
		 * 1.加载配置
		 * 2.根据configuration配置信息创建sessionFactory
		 * 3.获得session
		 * 4.打开事物
		 * 5,//HQL语言 => Hibernate Query Language
		 * //createQuery 传入hql语句查询与//select * from t_user;等价
		 * //list 将语句执行,并返回结果
		 * //提交事务
		 * //关闭资源
		 */
		Configuration configure = new Configuration().configure();
		SessionFactory buildSessionFactory = configure.buildSessionFactory();
		Session openSession = buildSessionFactory.openSession();
		Transaction beginTransaction = openSession.beginTransaction();
		
		Query query = openSession.createQuery("from com.liuweicom.a_hello.User");
		List<User> list = query.list();
		
		System.out.println(list);
		beginTransaction.commit();
		openSession.close();
		buildSessionFactory.close();
		
		
	}
	
	@Test
	//查询----load
	public void fun7(){
		/**
		 * 1.加载配置
		 * 2.根据configuration配置信息创建sessionFactory
		 * 3.获得session
		 * 4.打开事物
		 * 5,//Criteria 查询 => Hibernate独创的面向对象的查询=> 无语句
		 * //提交事务
		 * //关闭资源
		 */
		Configuration configure = new Configuration().configure();
		SessionFactory buildSessionFactory = configure.buildSessionFactory();
		Session openSession = buildSessionFactory.openSession();
		Transaction beginTransaction = openSession.beginTransaction();
		
		Criteria createCriteria = openSession.createCriteria(User.class);
		//select * from t_user;
		List<User> list = createCriteria.list();
		
		System.out.println(list);
		
		beginTransaction.commit();
		openSession.close();
		buildSessionFactory.close();
		
		
	}
	
	@Test
	//查询----load
	public void fun8(){
		/**
		 * 1.加载配置
		 * 2.根据configuration配置信息创建sessionFactory
		 * 3.获得session
		 * 4.打开事物
		 * 5,原生SQL查询
		 * 6.addEntity 将查询结果封装到指定对象
		 * //提交事务
		 * //关闭资源
		 */
		Configuration configure = new Configuration().configure();
		SessionFactory buildSessionFactory = configure.buildSessionFactory();
		Session openSession = buildSessionFactory.openSession();
		Transaction beginTransaction = openSession.beginTransaction();
		
		SQLQuery query = openSession.createSQLQuery("select * from t_user");
		query.addEntity(User.class);
		List<User> list = query.list();
		
		System.out.println(list);
		
		beginTransaction.commit();
		openSession.close();
		buildSessionFactory.close();
		
	}
	/**
	 * //1 load方法.返回一个代理对象,获得其内容时,会查询数据库,是每次访问属性都会查询数据库吗?
	*答:不是每次都查.代理对象中有一个标识是否被初始化的boolean型变量. 记录是否被初始化过.
	*2 代理都是要基于接口的,用load方法返回的代理,就没有实现任何接口?
	*答: java中的动态代理是基于接口.  而 Hibernate 是使用javassist-3.12.0.GA.jar 产生代理对象的.
	*该代理与被代理对象之间的关系是继承关系.与我们学的动态代理不是一种.所以不需要接口.
	 */
}
