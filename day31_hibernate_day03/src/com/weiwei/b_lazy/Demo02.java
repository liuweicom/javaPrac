package com.weiwei.b_lazy;

import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import com.weiwei.domain.Customer;
import com.weiwei.domain.Order;
import com.weiwei.utils.HebernateUtils;
/**
 * lazy:�Ƿ��set����ʹ��������
 * 		true��Ĭ��ֵ���Լ���ʹ�òż���
 * 		false�����Ͻ��ᱻ���̼���
 * 		extra���������裬���ʹ�ü���ʱ��������size������ѯ������hibernate�ᷢ��count��䣬ֻ��ѯ�����������ؼ���������
 * fetch:�������ؼ���ʹ�õ�sql�������
 * 		select��Ĭ�ϣ���ͨselect���
 * 		join������������ѯ��������
 * 		subselect��ʹ���Ӳ�ѯ��һ�μ��ض��Customer�Ķ�������
 * @author ����
 * 
 * fetch     lazy
 * select    true:Ĭ��ֵ����ʹ�ü����Ǽ��أ���ͨselect���
 * select	 false:��ѯ����ʱ����ʹ��select�����ؼ�������
 * select 	 extra:����ʹ�ü���ʱ���أ���ͨselect��䣬���ֻ�ǻ�ü��ϵĳ��ȣ��ᷢ��count����ѯ
 * join      true:��ѯʱ��ʹ�ñ����Ӳ�ѯ�������̼��ؼ�������
 * join      false:��ѯʱ��ʹ�ñ����Ӳ�ѯ�������̼��ؼ�������
 * join      extra:��ѯʱ��ʹ�ñ����Ӳ�ѯ�������̼��ؼ�������
 * subselect true:����ʹ�ü���ʱ�������Ӳ�ѯ���
 * subselect false:���ڲ�ѯ�û�ʱ������ʹ���Ӳ�ѯ���ؿͻ��Ķ���
 * subselect extra:����ʹ�ü���ʱ���Ӳ�ѯ��䣬���ֻ�ǻ�ü��ϵĳ��ȣ��ᷢ��count����ѯ
 *
 */
public class Demo02 {

	/**
	 * ��������������
	 * Ĭ�ϣ����ҹ��������ݣ���ʹ���ǲŻ����
	 */
	@Test
	public void fun8(){
		//3 ���session
				Session session = HebernateUtils.openSession();	
				session.beginTransaction();
				//-------------------
				Customer c =(Customer) session.get(Customer.class, 1);
				for(Order o: c.getOrders()){
					System.out.println(o.getName());
				}
				//------------------
				session.getTransaction().commit();
				session.close();
	}
	
	/**
	 * ��������������
	 * lazy��false
	 */
	@Test
	public void fun1(){
		//3 ���session
				Session session = HebernateUtils.openSession();	
				session.beginTransaction();
				//-------------------
				Customer c =(Customer) session.get(Customer.class, 1);
				for(Order o: c.getOrders()){
					System.out.println(o.getName());
				}
				
				//------------------
				session.getTransaction().commit();
				session.close();
	}
	
	/**
	 * ��������������
	 * lazy��false/true
	 * fetch:join
	 */
	@Test
	public void fun2(){
		//3 ���session
				Session session = HebernateUtils.openSession();	
				session.beginTransaction();
				//-------------------
					Customer c = (Customer)session.get(Customer.class,1);
					//��ѯ���
//					Hibernate: 
//					    select
//					        customer0_.id as id3_1_,
//					        customer0_.name as name3_1_,
//					        orders1_.cid as cid3_3_,
//					        orders1_.id as id3_,
//					        orders1_.id as id4_0_,
//					        orders1_.name as name4_0_,
//					        orders1_.cid as cid4_0_ 
//					    from
//					        t_customer customer0_ 
//					    left outer join
//					        t_order orders1_ 
//					            on customer0_.id=orders1_.cid 
//					    where
//					        customer0_.id=?
					for(Order o: c.getOrders()){
						System.out.println(o.getName());
					}
				
				//------------------
				session.getTransaction().commit();
				session.close();
	}
	//��������������
	//lazy��true
	//fetch:subselect
	@Test
	public void fun3(){
		//3 ���session
				Session session = HebernateUtils.openSession();	
				session.beginTransaction();
				//-------------------
				List<Customer> list = session.createQuery("from Customer").list();
//				Hibernate: 
//			    select
//			        customer0_.id as id3_,
//			        customer0_.name as name3_ 
//			    from
//			        t_customer customer0_
				for(Customer c:list){
					System.out.println(c.getName()+"�µ���"+c.getOrders().size());
				}
//				Hibernate: 
//			    select
//			        orders0_.cid as cid3_1_,
//			        orders0_.id as id1_,
//			        orders0_.id as id4_0_,
//			        orders0_.name as name4_0_,
//			        orders0_.cid as cid4_0_ 
//			    from
//			        t_order orders0_ 
//			    where
//			        orders0_.cid in (
//			            select
//			                customer0_.id 
//			            from
//			                t_customer customer0_
//			        )
				


				//------------------
				session.getTransaction().commit();
				session.close();
	}
	
	//��������������
	//lazy��false
	//fetch:subselect
	@Test
	public void fun4(){
		//3 ���session
				Session session = HebernateUtils.openSession();	
				session.beginTransaction();
				//-------------------
				List<Customer> list = session.createQuery("from Customer").list();
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
//				            select
//				                customer0_.id 
//				            from
//				                t_customer customer0_
//				        )
				for(Customer c:list){
					System.out.println(c.getName()+"�µ���");
				}
				

				        
				//------------------
				session.getTransaction().commit();
				session.close();
	}
	
	/**
	 * ��������������
	 * lazy��extra
	 * fetch:select
	 */
	@Test
	public void fun5(){
		//3 ���session
				Session session = HebernateUtils.openSession();	
				session.beginTransaction();
				//-------------------
				Customer c =(Customer) session.get(Customer.class, 1);
				System.out.println(c.getOrders().size());
				
				for(Order o:c.getOrders()){
					System.out.println(o.getName());
				}
				//------------------
				session.getTransaction().commit();
				session.close();
				
//				Hibernate: 
//				    select
//				        customer0_.id as id3_0_,
//				        customer0_.name as name3_0_ 
//				    from
//				        t_customer customer0_ 
//				    where
//				        customer0_.id=?
//				Hibernate: 
//				    select
//				        count(id) 
//				    from
//				        t_order 
//				    where
//				        cid =?
//				2
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
//				        orders0_.cid=?
//				ե��
//				�ϲ�
	}
	
	/**
	 * ��������������
	 * lazy��extra
	 * fetch:subselect
	 */
	@Test
	public void fun6(){
		//3 ���session
				Session session = HebernateUtils.openSession();	
				session.beginTransaction();
				//-------------------
				List<Customer> list = session.createQuery("from Customer").list();
				for(Customer o: list){
					System.out.println(o.getName()+"xiandan"+o.getOrders().size());
				}
				
				for(Customer c: list){
					for(Order o:c.getOrders()){
						System.out.println(c.getName()+"xiazai"+o.getName());
					}
				}
				
				
//				Hibernate: 
//				    select
//				        customer0_.id as id3_,
//				        customer0_.name as name3_ 
//				    from
//				        t_customer customer0_
//				Hibernate: 
//				    select
//				        count(id) 
//				    from
//				        t_order 
//				    where
//				        cid =?
//				tomxiandan2
//				Hibernate: 
//				    select
//				        count(id) 
//				    from
//				        t_order 
//				    where
//				        cid =?
//				jerryxiandan2
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
//				            select
//				                customer0_.id 
//				            from
//				                t_customer customer0_
//				        )
//				tomxiazaiե��
//				tomxiazai�ϲ�
//				jerryxiazai�ǹ�
//				jerryxiazai����
				//------------------
				session.getTransaction().commit();
				session.close();
	}
	
	@Test
	public void fun7(){
		//3 ���session
				Session session = HebernateUtils.openSession();	
				session.beginTransaction();
				//-------------------
				
				
				//------------------
				session.getTransaction().commit();
				session.close();
	}
}
