package com.liuweicom.a_state;

import org.hibernate.Session;
import org.junit.Test;

import com.liuweicom.domain.User;
import com.liuweicom.utils.hibernateUtils;

public class Demo01 {
	@Test
	public void fun1(){
		//演示了三种状态
		Session session  = hibernateUtils.openSession();
		session.beginTransaction();
		
		User u =new User();//瞬时状态
		u.setName("tom"); //瞬时状态
		u.setPassword("1234");//瞬时状态
		
		session.save(u);//持久状态
						//问题：调用完save方法，数据库中有没有对应记录？没有对应记录，但是最终会被同步到数据库中，任然是持久状态
						
		
		session.getTransaction().commit();//持久状态
		session.close();//游离状态
			
	}
	
	//三种状态之间的转换
	//++++++++++++++++瞬时===》持久
	@Test
	public void fun2(){
		Session session = hibernateUtils.openSession();
		session.beginTransaction();
		
		User u=new User();//瞬时状态
		u.setName("tom"); //瞬时状态
		u.setPassword("234");//瞬时状态
		
		session.save(u);//持久状态， save方法会使用主键生成策略，为User指定id=》
		//主键自增=》打印insert 语句
		//increment =》select max（id）
		//assign =》需要主动指定主键，不指定将会报错
		
	
		session.getTransaction().commit();//持久状态
											//事务提交时，会把持久化状态对象同步到数据库中
		
		session.close();//游离状态
	}
	//瞬时=》游离
	//瞬时:没有关联，没有id
	//游离：没有关联，有，id（与数据中对应的id）
	@Test
	public void fun3(){
		Session session = hibernateUtils.openSession();
		session.beginTransaction();
		
		User u =new User();//瞬时状态
		u.setId(1);//有利状态
		
		session.getTransaction().commit();//持久状态，事务提交时，会把持久化状态的对象同步提交到数据库中
		session.close();//游离状态
	}
	
	//持久==》瞬时
	//持久：有关联，有id
	//瞬时： 无关联，无id
	@Test
	public void fun4(){
		Session session = hibernateUtils.openSession();
		session.beginTransaction();
		
		//通过get对象方法，得到持久化对象
		User u = (User) session.get(User.class, 1);//持久状态
		
		session.getTransaction().commit();//持久状态，事务提交时，会把持久化状态的对象同步提交到数据库中
		session.close();//游离状态
		u.setId(null);//瞬时状态
	}
	
	
	//持久==》瞬时
		//持久：有关联，有id
		//瞬时： 无关联，无id
		@Test
		public void fun5(){
			Session session = hibernateUtils.openSession();
			session.beginTransaction();
			
			//通过get对象方法，得到持久化对象
			User u = (User) session.get(User.class, 1);//持久状态
			session.evict(u);//将User对象与session的关联移除,游离
			u.setId(null);//瞬时状态
			
			session.getTransaction().commit();//持久状态，事务提交时，会把持久化状态的对象同步提交到数据库中
			session.close();//游离状态
		}
	
		
		//持久==》游离
		//只需要把session的关联取消
		@Test
		public void fun6(){
			Session session = hibernateUtils.openSession();
			session.beginTransaction();
			
			//通过get对象方法，得到持久化对象
			User u = (User) session.get(User.class, 1);//持久状态
			session.evict(u);//游离
			
			session.getTransaction().commit();//持久状态，事务提交时，会把持久化状态的对象同步提交到数据库中
			session.close();//游离状态
		}
		
		//游离===》瞬时
		//移除Id
		@Test
		public void fun7(){
			Session session = hibernateUtils.openSession();
			session.beginTransaction();
			
			//通过get对象方法，得到持久化对象
			User u = (User) session.get(User.class, 1);//持久状态
			session.evict(u);//游离
			u.setId(null);//瞬时
			
			session.getTransaction().commit();//持久状态，事务提交时，会把持久化状态的对象同步提交到数据库中
			session.close();//游离状态
		}
		
		
		
		//游离===》持久
		//是否与session关联
		@Test
		public void fun8(){
			Session session = hibernateUtils.openSession();
			session.beginTransaction();
			
			//通过get对象方法，得到持久化对象
			User u = (User) session.get(User.class, 1);//持久状态
			session.evict(u);//游离
			session.update(u);//持久
			
			
			session.getTransaction().commit();//持久状态，事务提交时，会把持久化状态的对象同步提交到数据库中
			session.close();//游离状态
		}
		
		//三种状态有什么用？
		//持久状态，我们使用hibernate，主要是为了我们持久化数据
		//对于对象的状态，我们期望我们需要同步到数据库的数据，都被装换成持久状态
		@Test
		public void fun9(){
			Session session = hibernateUtils.openSession();
			session.beginTransaction();
			
			//通过get对象方法，得到持久化对象
			User u = (User) session.get(User.class, 1);//持久状态
			//u.setId(3);//不能修改会报错，session建立关联的对象的iD，不允许修改
			u.setName("hahha");
//			session.update(u);//多余，可以不用写，因为hibernate会自动将持久化状态的对象的变化同步到数据库中
			session.getTransaction().commit();//持久状态，打印update语句
			session.close();//游离状态
		}
		
	
}
