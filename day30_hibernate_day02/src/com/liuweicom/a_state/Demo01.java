package com.liuweicom.a_state;

import org.hibernate.Session;
import org.junit.Test;

import com.liuweicom.domain.User;
import com.liuweicom.utils.hibernateUtils;

public class Demo01 {
	@Test
	public void fun1(){
		//��ʾ������״̬
		Session session  = hibernateUtils.openSession();
		session.beginTransaction();
		
		User u =new User();//˲ʱ״̬
		u.setName("tom"); //˲ʱ״̬
		u.setPassword("1234");//˲ʱ״̬
		
		session.save(u);//�־�״̬
						//���⣺������save���������ݿ�����û�ж�Ӧ��¼��û�ж�Ӧ��¼���������ջᱻͬ�������ݿ��У���Ȼ�ǳ־�״̬
						
		
		session.getTransaction().commit();//�־�״̬
		session.close();//����״̬
			
	}
	
	//����״̬֮���ת��
	//++++++++++++++++˲ʱ===���־�
	@Test
	public void fun2(){
		Session session = hibernateUtils.openSession();
		session.beginTransaction();
		
		User u=new User();//˲ʱ״̬
		u.setName("tom"); //˲ʱ״̬
		u.setPassword("234");//˲ʱ״̬
		
		session.save(u);//�־�״̬�� save������ʹ���������ɲ��ԣ�ΪUserָ��id=��
		//��������=����ӡinsert ���
		//increment =��select max��id��
		//assign =����Ҫ����ָ����������ָ�����ᱨ��
		
	
		session.getTransaction().commit();//�־�״̬
											//�����ύʱ����ѳ־û�״̬����ͬ�������ݿ���
		
		session.close();//����״̬
	}
	//˲ʱ=������
	//˲ʱ:û�й�����û��id
	//���룺û�й������У�id���������ж�Ӧ��id��
	@Test
	public void fun3(){
		Session session = hibernateUtils.openSession();
		session.beginTransaction();
		
		User u =new User();//˲ʱ״̬
		u.setId(1);//����״̬
		
		session.getTransaction().commit();//�־�״̬�������ύʱ����ѳ־û�״̬�Ķ���ͬ���ύ�����ݿ���
		session.close();//����״̬
	}
	
	//�־�==��˲ʱ
	//�־ã��й�������id
	//˲ʱ�� �޹�������id
	@Test
	public void fun4(){
		Session session = hibernateUtils.openSession();
		session.beginTransaction();
		
		//ͨ��get���󷽷����õ��־û�����
		User u = (User) session.get(User.class, 1);//�־�״̬
		
		session.getTransaction().commit();//�־�״̬�������ύʱ����ѳ־û�״̬�Ķ���ͬ���ύ�����ݿ���
		session.close();//����״̬
		u.setId(null);//˲ʱ״̬
	}
	
	
	//�־�==��˲ʱ
		//�־ã��й�������id
		//˲ʱ�� �޹�������id
		@Test
		public void fun5(){
			Session session = hibernateUtils.openSession();
			session.beginTransaction();
			
			//ͨ��get���󷽷����õ��־û�����
			User u = (User) session.get(User.class, 1);//�־�״̬
			session.evict(u);//��User������session�Ĺ����Ƴ�,����
			u.setId(null);//˲ʱ״̬
			
			session.getTransaction().commit();//�־�״̬�������ύʱ����ѳ־û�״̬�Ķ���ͬ���ύ�����ݿ���
			session.close();//����״̬
		}
	
		
		//�־�==������
		//ֻ��Ҫ��session�Ĺ���ȡ��
		@Test
		public void fun6(){
			Session session = hibernateUtils.openSession();
			session.beginTransaction();
			
			//ͨ��get���󷽷����õ��־û�����
			User u = (User) session.get(User.class, 1);//�־�״̬
			session.evict(u);//����
			
			session.getTransaction().commit();//�־�״̬�������ύʱ����ѳ־û�״̬�Ķ���ͬ���ύ�����ݿ���
			session.close();//����״̬
		}
		
		//����===��˲ʱ
		//�Ƴ�Id
		@Test
		public void fun7(){
			Session session = hibernateUtils.openSession();
			session.beginTransaction();
			
			//ͨ��get���󷽷����õ��־û�����
			User u = (User) session.get(User.class, 1);//�־�״̬
			session.evict(u);//����
			u.setId(null);//˲ʱ
			
			session.getTransaction().commit();//�־�״̬�������ύʱ����ѳ־û�״̬�Ķ���ͬ���ύ�����ݿ���
			session.close();//����״̬
		}
		
		
		
		//����===���־�
		//�Ƿ���session����
		@Test
		public void fun8(){
			Session session = hibernateUtils.openSession();
			session.beginTransaction();
			
			//ͨ��get���󷽷����õ��־û�����
			User u = (User) session.get(User.class, 1);//�־�״̬
			session.evict(u);//����
			session.update(u);//�־�
			
			
			session.getTransaction().commit();//�־�״̬�������ύʱ����ѳ־û�״̬�Ķ���ͬ���ύ�����ݿ���
			session.close();//����״̬
		}
		
		//����״̬��ʲô�ã�
		//�־�״̬������ʹ��hibernate����Ҫ��Ϊ�����ǳ־û�����
		//���ڶ����״̬����������������Ҫͬ�������ݿ�����ݣ�����װ���ɳ־�״̬
		@Test
		public void fun9(){
			Session session = hibernateUtils.openSession();
			session.beginTransaction();
			
			//ͨ��get���󷽷����õ��־û�����
			User u = (User) session.get(User.class, 1);//�־�״̬
			//u.setId(3);//�����޸Ļᱨ��session���������Ķ����iD���������޸�
			u.setName("hahha");
//			session.update(u);//���࣬���Բ���д����Ϊhibernate���Զ����־û�״̬�Ķ���ı仯ͬ�������ݿ���
			session.getTransaction().commit();//�־�״̬����ӡupdate���
			session.close();//����״̬
		}
		
	
}
