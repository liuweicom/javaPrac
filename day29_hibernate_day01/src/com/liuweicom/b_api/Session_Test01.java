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
	//session �������ڲ������ݿ�
	//��
	public void fun1(){
		/**
		 * 1.��������
		 * 2.����configuration������Ϣ����sessionFactory
		 * 3.���session
		 * 4.�������ݿ����
		 * 5.�ر���Դ
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
	//��
	public void func2(){
		/**
		 * 1.��������
		 * 2.����configuration������Ϣ����sessionFactory
		 * 3.���session
		 * 4.������(�йز�ѯ�ģ���Ҫ������)
		 * 5.��ѯ��Ҫ�޸ĵĶ���*****��
		 * 6.�ڲ�ѯ����ϣ������޸�
		 * 7���������
		 * 8.�ر���Դ
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
	//ɾ
	public void fun3(){
		/**
		 * 1.��������
		 * 2.����configuration������Ϣ����sessionFactory
		 * 3.���session
		 * 4.������
		 * 5.��ѯ����Ҫ�޸ĵĶ���
		 * 6.����Idɾ��
		 * 7.�ύ����
		 * 8.�ر���Դ
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
	//��ѯ----get
	public void fun4(){
		/**
		 * 1.��������
		 * 2.����configuration������Ϣ����sessionFactory
		 * 3.���session
		 * 4.������
		 * 5.��ѯ����Ҫ�޸ĵĶ���
		 * 7.�ύ����
		 * 8.�ر���Դ
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
	//��ѯ----load
	/**
	 * get:����������ʱ���̣�����sql����ѯ
	 * load�� ����ʱ��û�в�ѯ���ݿ⣬��������Ҫʹ�øö����ʱ�򣬲�ȥ��ѯ����
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
	//��ѯ
	//��ѯ����User
	public void fun6(){
		/**
		 * 1.��������
		 * 2.����configuration������Ϣ����sessionFactory
		 * 3.���session
		 * 4.������
		 * 5,//HQL���� => Hibernate Query Language
		 * //createQuery ����hql����ѯ��//select * from t_user;�ȼ�
		 * //list �����ִ��,�����ؽ��
		 * //�ύ����
		 * //�ر���Դ
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
	//��ѯ----load
	public void fun7(){
		/**
		 * 1.��������
		 * 2.����configuration������Ϣ����sessionFactory
		 * 3.���session
		 * 4.������
		 * 5,//Criteria ��ѯ => Hibernate�������������Ĳ�ѯ=> �����
		 * //�ύ����
		 * //�ر���Դ
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
	//��ѯ----load
	public void fun8(){
		/**
		 * 1.��������
		 * 2.����configuration������Ϣ����sessionFactory
		 * 3.���session
		 * 4.������
		 * 5,ԭ��SQL��ѯ
		 * 6.addEntity ����ѯ�����װ��ָ������
		 * //�ύ����
		 * //�ر���Դ
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
	 * //1 load����.����һ���������,���������ʱ,���ѯ���ݿ�,��ÿ�η������Զ����ѯ���ݿ���?
	*��:����ÿ�ζ���.�����������һ����ʶ�Ƿ񱻳�ʼ����boolean�ͱ���. ��¼�Ƿ񱻳�ʼ����.
	*2 ������Ҫ���ڽӿڵ�,��load�������صĴ���,��û��ʵ���κνӿ�?
	*��: java�еĶ�̬�����ǻ��ڽӿ�.  �� Hibernate ��ʹ��javassist-3.12.0.GA.jar ������������.
	*�ô����뱻�������֮��Ĺ�ϵ�Ǽ̳й�ϵ.������ѧ�Ķ�̬������һ��.���Բ���Ҫ�ӿ�.
	 */
}
