package com.liuweicom.c_question;

import org.hibernate.Session;
import org.junit.Test;

import com.liuweicom.domain.User;
import com.liuweicom.utils.hibernateUtils;

public class Demo01 {
	@Test
	public void fun1(){
		Session session = hibernateUtils.openSession();
		session.beginTransaction();
		
		User u = new User();
		u.setId(99);
		session.persist(u);//���ֵ��ǳ־û���persist�ṩ�������ǽ����������ĳ־û����־û����������Ǹ���id
		//�ڱ���֮��������id����ô�ͻὫ���õ�id����insert�����ǣ����������������ݿ���ά���ģ����Բ�����ì�ܣ��ܳ��쳣
		
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void fun2(){
		Session session = hibernateUtils.openSession();
		session.beginTransaction();
		
		User u = new User();
		u.setId(99);
		session.save(u);//save��������������ڶ���֮ǰ������id����ôid����Ϊ����Ч��id����Ȼ�ᰴ���������ɲ�������id
		
		session.getTransaction().commit();
		session.close();
	}
	
}
