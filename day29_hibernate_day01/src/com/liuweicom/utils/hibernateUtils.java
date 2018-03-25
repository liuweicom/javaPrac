package com.liuweicom.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

/**
 * 完成hibernate工具类
 * 封装配置文件读取操作
 * 封装sessionfactory创建操作
 * 封装session获得操作
 * @author 工号
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
				System.out.println("虚拟机关闭!释放资源");
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
