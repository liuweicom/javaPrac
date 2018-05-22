package com.weiwei.c_hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import com.weiwei.domain.Customer;
import com.weiwei.utils.HebernateUtils;
//HQL���
public class Demo1 {
	
	@Test
	//HQL��ѯ����
	public void fun1(){
				//3 ���session
				Session session = HebernateUtils.openSession();	
				session.beginTransaction();
				//-------------------
				//���������ֲ�ѯ����Customer������ʽ
//				Query query = session.createQuery("from Customer");
//				Query quer1 = session.createQuery("from Customer c");
				Query quer2 = session.createQuery("select c from Customer c");
				
				List<Customer> list = quer2.list();
				System.out.println(list);
				
//				Hibernate: 
//				    select
//				        customer0_.id as id3_,
//				        customer0_.name as name3_ 
//				    from
//				        t_customer customer0_
//				Hibernate: 
//				    select
//				        orders0_.cid as cid3_1_,
//				        orders0_.id as id1_,
//				        orders0_.id as id4_0_,
//				        orders0_.name as name4_0_,
//				        orders0_.cid as cid4_0_ 
//				    from
//				        t_order orders0_ 
//				    where
//				        orders0_.cid in (
//				            ?, ?
//				        )
				
				//------------------
				session.getTransaction().commit();
				session.close();
	}
	//HQL��ѯ�����ĳ��������
	@Test
	public void fun2(){
				//3 ���session
				Session session = HebernateUtils.openSession();	
				session.beginTransaction();
				//-------------------
				Query query = session.createQuery("select c.id,c.name from Customer c");
				
				List<Object[]> list = query.list();
				for(Object[] o:list){
					System.out.println(Arrays.toString(o));
				}
				//------------------
				session.getTransaction().commit();
				session.close();
	}
	
	//ͶӰ��ѯ
	//ѡ���ѯ�Ļ����ϣ���Ѳ�ѯ�����װ��������
	@Test
	public void fun3(){
				//3 ���session
				Session session = HebernateUtils.openSession();	
				session.beginTransaction();
				//-------------------
				//��ʱ���뱣֤Customer������Customer��Integer ID��String name���ķ���
				Query query = session.createQuery("select new Customer(c.id,c.name) from Customer c");
				List<Customer> list = query.list();
				System.out.println(list);
				
//				[Customer [id=1, name=tom, orders=[]], Customer [id=2, name=jerry, orders=[]]]
				
				//------------------
				session.getTransaction().commit();
				session.close();
	}
	
	//����
	@Test
	public void fun4(){
				//3 ���session
				Session session = HebernateUtils.openSession();	
				session.beginTransaction();
				//-------------------
				Query query = session.createQuery("from Customer c order by c.id desc");
				List<Customer> list = query.list();
				System.out.println(list);//��ʱֻ��ѯ��Customer����û�д���������ı��ѯ�ɹ�����ʱCustomer��tostring��������Ҫ����Order���ԣ���Ȼ�ᱨ��
				
//				 select
//			        customer0_.id as id3_,
//			        customer0_.name as name3_ 
//			    from
//			        t_customer customer0_ 
//			    order by
//			        customer0_.id desc
				//[Customer [id=2, name=jerry], Customer [id=1, name=tom]]
				//------------------
				session.getTransaction().commit();
				session.close();
	}
	
	//��ҳ
	@Test
	public void fun5(){
				//3 ���session
				Session session = HebernateUtils.openSession();	
				session.beginTransaction();
				//-------------------
				Query query = session.createQuery("from Customer c order by c.id asc");
				//setFirstResult:(��ǰҳ��-1)*ÿҳ����¼��
				//
				query.setFirstResult(0);//���ĸ�������ʼȡ���ݣ�������������ļ�¼
				query.setMaxResults(2);//��ѯ������������
				List<Customer> list = query.list();
				
				//[Customer [id=1, name=tom], Customer [id=2, name=jerry]]
				System.out.println(list);
				
				//------------------
				session.getTransaction().commit();
				session.close();
	}
	//�󶨲���
	@Test
	public void fun6(){
				//3 ���session
				Session session = HebernateUtils.openSession();	
				session.beginTransaction();
				//-------------------
//				Query query = session.createQuery("from Customer c where c.id=?");
//				//����1����ռλ��������λ�ã��ڶ���ΪID=2
//				query.setInteger(0,2);//����Ǹ���id������ѡ���Integer����ѡ��setInteger
				Query query = session.createQuery("from Customer c where c.id=:haha");
				//����1������ռλ�������ƣ��ڶ���ΪID=2
				query.setInteger("haha",2);
				
				Customer c = (Customer)query.uniqueResult();
				System.out.println(c);
				//
				//
				//------------------
				session.getTransaction().commit();
				session.close();
	}
	//�ۺϺ���
	@Test
	public void fun7(){
				//3 ���session
				Session session = HebernateUtils.openSession();	
				session.beginTransaction();
				//-------------------
				Query query = session.createQuery("select count(*) from Customer c ");
				Query query1 = session.createQuery("select avg(c.id) from Customer c ");
				Query query2 = session.createQuery("select sum(c.id) from Customer c ");
				Query query3 = session.createQuery("select max(c.id) from Customer c ");
				Query query4 = session.createQuery("select min(c.id) from Customer c ");
				
				Object count = query.uniqueResult();
				System.out.println(count);
				//------------------
				session.getTransaction().commit();
				session.close();
	}
	
	//group by ..having
	@Test
	public void fun8(){
				//3 ���session
				Session session = HebernateUtils.openSession();	
				session.beginTransaction();
				//-------------------
				Query query = session.createQuery("select o.customer, count(o) from Order o group by o.customer having count(o)>1");
				List<Object[]> list = query.list();
				for(Object[] objs: list){
					System.out.println(Arrays.toString(objs));
				}
				
				//------------------
				session.getTransaction().commit();
				session.close();
	}
	
}
