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
		List<User> list1 = session.createQuery("from User").list(); // ����sql
		
		List<User> list2 = session.createQuery("from User").list();// ����sql
		
		System.out.println(list1.get(0)==list2.get(0));//true =>
		/**
		 * ���⣬Ϊʲôÿ��������select��䣬���ǣ����ǻ�����ˣ���Ϊÿ�ε���createQuery������ȥ��̨��ѯ���ݿ�
		 * ������Ľ������ȥsession�����в鿴�Ƿ���ڱ��棬
		 * ����Ѿ����ڣ���ô�����ٴδ��룬ֱ�Ӵӻ�����ȡ���������Ե�ַ����һ����
		 */
		//------------------------------------------------
		session.getTransaction().commit();
		session.close(); // ����״̬
	}
	
	/**
	 * �����е�������������ݿ��еĲ�ͬ��������ô����
	 * ������ʹ�û����еģ�����취����û���ʹ��JDBC
	 * ��һ�������г��ֵ�����ļ��ʱȽ�С
	 * ��Ϊһ�������openSession���������ڿ�ʼ����session��close������һ�������������ڽ���
	 */
}
