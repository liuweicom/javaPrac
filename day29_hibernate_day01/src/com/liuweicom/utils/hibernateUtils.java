package com.liuweicom.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

/**
 * ���hibernate������
 * ��װ�����ļ���ȡ����
 * ��װsessionfactory��������
 * ��װsession��ò���
 * @author ����
 *
 */
public class hibernateUtils {
	private static SessionFactory sf;
	
	static{
		Configuration conf = new Configuration().configure();
		sf = conf.buildSessionFactory();
		
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("������ر�!�ͷ���Դ");
				sf.close();
			}
		}));
	}
	
	public static org.hibernate.Session openSession(){
		Session session = sf.openSession();
		return session;
	}
	
	public static org.hibernate.Session getCurrentSession(){
		Session session = sf.getCurrentSession();
		return session;
	}
}
