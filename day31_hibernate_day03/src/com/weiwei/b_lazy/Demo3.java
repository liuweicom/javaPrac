package com.weiwei.b_lazy;

import org.hibernate.Session;
import org.junit.Test;

import com.weiwei.domain.Customer;
import com.weiwei.domain.Order;
import com.weiwei.utils.HebernateUtils;



/**
 * fetch	lazy	
 * -----------------------------
 * select   false:���ض���ʱ���������ؿͻ����ݣ���ͨselect�����ؿͻ�
 * select	proxy:����ز���Ϊlazy = falseͬ��
 * 							lazy = true �����ض����ǣ��Ȳ����ؿͻ����ݣ�ʹ�ÿͻ������ǲż���
 * join		false:			ʹ�ñ�����ʱ��ѯ��������Ӧ�ͻ���Ϣ��lazy������Ч
 * join		proxy:			ʹ�ñ�����ʱ��ѯ��������Ӧ�ͻ���Ϣ��lazy������Ч
 * @author ����
 *
 */
//���һ��������
public class Demo3 {
	/**
	 * fetch: select
	 * lazy: false
	 */
	@Test
	public void fun1(){
		//3 ���session
				Session session = HebernateUtils.openSession();	
				session.beginTransaction();
				//-------------------
				Order o = (Order) session.get(Order.class, 1);
				
//				Hibernate: 
//				    select
//				        order0_.id as id4_0_,
//				        order0_.name as name4_0_,
//				        order0_.cid as cid4_0_ 
//				    from
//				        t_order order0_ 
//				    where
//				        order0_.id=?
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
//				        orders0_.cid as cid3_1_,
//				        orders0_.id as id1_,
//				        orders0_.id as id4_0_,
//				        orders0_.name as name4_0_,
//				        orders0_.cid as cid4_0_ 
//				    from
//				        t_order orders0_ 
//				    where
//				        orders0_.cid=?
				
				System.out.println(o.getCustomer().getName());
				
				//------------------
				session.getTransaction().commit();
				session.close();
	}
	
	/**
	 * fetch:select
	 * lazy:proxy
	 * customer lazy:false ����class�ϵ�
	 */
	@Test
	public void fun2(){
		//3 ���session
				Session session = HebernateUtils.openSession();	
				session.beginTransaction();
				//-------------------
				Order o = (Order) session.get(Order.class, 2);
				
//				Hibernate: 
//				    select
//				        order0_.id as id4_0_,
//				        order0_.name as name4_0_,
//				        order0_.cid as cid4_0_ 
//				    from
//				        t_order order0_ 
//				    where
//				        order0_.id=?
//				Hibernate: 
//				    select
//				        customer0_.id as id3_0_,
//				        customer0_.name as name3_0_ 
//				    from
//				        t_customer customer0_ 
//				    where
//				        customer0_.id=?
				
				System.out.println(o.getCustomer().getName());
				
				//------------------
				session.getTransaction().commit();
				session.close();
	}
	
	
	/**
	 * fetch:select
	 * lazy:proxy
	 * customer lazy:true ����class�ϵ�
	 */
	@Test
	public void fun3(){
		//3 ���session
				Session session = HebernateUtils.openSession();	
				session.beginTransaction();
				//-------------------
				Order o = (Order) session.get(Order.class, 2);
				
//				Hibernate: 
//				    select
//				        order0_.id as id4_0_,
//				        order0_.name as name4_0_,
//				        order0_.cid as cid4_0_ 
//				    from
//				        t_order order0_ 
//				    where
//				        order0_.id=?
				
				
				System.out.println(o.getCustomer().getName());
				
//				Hibernate: 
//				    select
//				        customer0_.id as id3_0_,
//				        customer0_.name as name3_0_ 
//				    from
//				        t_customer customer0_ 
//				    where
//				        customer0_.id=?
//				tom
				//------------------
				session.getTransaction().commit();
				session.close();
	}
	
	
	//fetch: join
		//lazy: proxy|false
	@Test
	public void fun4(){
		//3 ���session
				Session session = HebernateUtils.openSession();	
				session.beginTransaction();
				//-------------------
				Order o = (Order) session.get(Order.class, 2);
				
//				Hibernate: 
//				    select
//				        order0_.id as id4_1_,
//				        order0_.name as name4_1_,
//				        order0_.cid as cid4_1_,
//				        customer1_.id as id3_0_,
//				        customer1_.name as name3_0_ 
//				    from
//				        t_order order0_ 
//				    left outer join
//				        t_customer customer1_ 
//				            on order0_.cid=customer1_.id 
//				    where
//				        order0_.id=?
				        		
				System.out.println(o.getCustomer().getName());
//				tom
				//------------------
				session.getTransaction().commit();
				session.close();
	}
}
