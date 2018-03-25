package com.liuweicom.d_api;

import org.hibernate.Session;
import org.junit.Test;

import com.liuweicom.domain.User;
import com.liuweicom.utils.hibernateUtils;

public class Demo01 {
	@Test
	/**evict�������еĶ����Ƴ�
	 * clear���һ������
	 */
	public void fun1(){
		Session session = hibernateUtils.openSession();
		session.beginTransaction();
		
		User u=(User) session.get(User.class, 1);
		session.clear();
		User u2 =(User) session.get(User.class, 1);//��ջ����������ԣ����������select���
		
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	/**
	 * refreshˢ�� ==��ǿ��ˢ�»����еĶ�������������������ݿⲻͬ�������⣩
	 */
	public void fun2(){
		Session session = hibernateUtils.openSession();
		session.beginTransaction();
		
		User u=(User) session.get(User.class, 1);
		session.refresh(u);//������Σ��������еĶ������������ݿ��е�ͬ�������ٷ���һ��SQL���
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	/**
	 * flush �Աȿ��գ����ύ�������
	 */
	public void fun3(){
		Session session = hibernateUtils.openSession();
		session.beginTransaction();
		
		User u=(User) session.get(User.class, 1);
//		u.setName("babay");
		session.flush();// ���User����û�иı䣬��ô����Ҫ�ύ���Σ���������ղ�ͬ�������ύsession�еĶ��󣬵����ݿ���
		
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	/**
	 * ��������Ϊnativeʱ
	 * saveOrUpdate����������ͬʱ��ɱ������µĲ���
	 * ������Ϊ��ʱ��==��save
	 * ��������ֵʱ==��update
	 */
	public void fun4(){
		Session session = hibernateUtils.openSession();
		session.beginTransaction();
		
		User u = new User();
		u.setName("boy0");
		u.setPassword("9809");
		session.saveOrUpdate(u);//��ʱ�൱��save�Ķ���
		
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	/**
	 * ��Ȼ����==��assign
	 * update��saveOrUpdate����
	 * ������Ϊ��ʱ����ʱ����ָ�����������Իᱨ��
	 * ������ֵ�����ȸ���������ѯ���ݿ�
	 * ���ݿ����==��ִ��update
	 * ���ݿⲻ���� ==��ִ��save
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
	 * ������ʹ��hibernateʱ����ҪҪ������֣�������ͬ��id���󣬷��뻺���У��ᱨ��
	 */
	public void fun6(){
		Session session = hibernateUtils.openSession();
		session.beginTransaction();

		User u =(User) session.get(User.class, 1);
		session.evict(u);
		User u2 =(User) session.get(User.class, 1);
		session.update(u);//�ᱨ���Ѿ�����һ��id=1�Ķ��󻺴棬һ�������в���ͬʱ��������ͬ�Ļ��棬����һ����MAP�ṹ�Ĵ洢��һidΪ��������Ϊֵ
		
		session.getTransaction().commit();
		session.close();
	}
}
