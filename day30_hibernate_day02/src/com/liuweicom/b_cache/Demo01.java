package com.liuweicom.b_cache;

import org.hibernate.Session;
import org.junit.Test;

import com.liuweicom.domain.User;
import com.liuweicom.utils.hibernateUtils;

public class Demo01 {
	//证明缓存的存在
	@Test
	public void fun1(){
		Session session = hibernateUtils.openSession();
		session.beginTransaction();
		
		User u1 = (User) session.get(User.class, 1);//发送select语句，从数据库取出记录，并封装成对象，持久化状态对象 =》存到缓存
		User u2 = (User) session.get(User.class, 1);//再吃查询是，会从缓存中查找，不会select
		User u3 = (User) session.get(User.class, 1);//再吃查询是，会从缓存中查找，不会select
		
		System.out.println(u1 == u2);//true
		
		System.out.println(u1 == u2);//true
		
		session.getTransaction().commit();
		session.close();
	}
	
	//证明session缓存的快照
		@Test
		public void fun4(){
			Session session = hibernateUtils.openSession();
			session.beginTransaction();
			
			User u1 = (User) session.get(User.class, 1);//发送select语句，从数据库取出记录，并封装成对象
			session.update(u1);
			
			session.getTransaction().commit();
			session.close();//游离状态
		}
		
		//证明缓存的存在
		@Test
		public void fun2(){
			Session session = hibernateUtils.openSession();
			session.beginTransaction();
			
			User u1 = new User();
			u1.setId(1);
			u1.setName("hahha");
			u1.setPassword("1234");
			
			session.update(u1);//虽然u1中的数据和数据库中存储的数据一样，
//			更新也只是更新到session的缓存中，与session快照为空，
//			与session不同，所以人要同步到数据库中
			session.getTransaction().commit();
			session.close();
		}
		
		//感受一级缓存效率的提高
		@Test
		public void fun3(){
			Session session = hibernateUtils.openSession();
			session.beginTransaction();
			
			User u1 = (User) session.get(User.class, 1);//发送select语句，从数据库取出记录，并封装成对象，持久化状态对象 =》存到缓存
			u1.setName("tom");
			session.update(u1);
			u1.setName("k=jsck");
			session.update(u1);
			u1.setName("hahha");
			session.update(u1);//这里即使多次设置name，但是在commit提交的时候最后一次session缓存中的数据，和session中快快照的数据时一样的，所以不用更新
			session.getTransaction().commit();
			session.close();
		}
		
		//*****持久化的本质
		//本质就是存在缓存中的对象，就是持久化状态，缓存中的数据，如果不和快照中的数据一样，就会自动更新到数据库中
}
