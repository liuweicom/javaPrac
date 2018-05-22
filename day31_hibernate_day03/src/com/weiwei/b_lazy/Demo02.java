package com.weiwei.b_lazy;

import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import com.weiwei.domain.Customer;
import com.weiwei.domain.Order;
import com.weiwei.utils.HebernateUtils;
/**
 * lazy:是否对set数据使用懒加载
 * 		true（默认值）对集合使用才加载
 * 		false：集合将会被立刻加载
 * 		extra：及其懒惰，如果使用集合时，调用了size方法查询数量，hibernate会发送count语句，只查询数量，不加载集合内数据
 * fetch:决定加载集合使用的sql语句种类
 * 		select（默认）普通select语句
 * 		join：表链接语句查询集合数据
 * 		subselect：使用子查询，一次加载多个Customer的订单数据
 * @author 工号
 * 
 * fetch     lazy
 * select    true:默认值，会使用集合是加载，普通select语句
 * select	 false:查询属性时立刻使用select语句加载集合数据
 * select 	 extra:会在使用集合时加载，普通select语句，如果只是获得集合的长度，会发送count语句查询
 * join      true:查询时，使用表链接查询，会立刻加载集合数据
 * join      false:查询时，使用表链接查询，会立刻加载集合数据
 * join      extra:查询时，使用表链接查询，会立刻加载集合数据
 * subselect true:会在使用集合时，加载子查询语句
 * subselect false:会在查询用户时，立即使用子查询加载客户的订单
 * subselect extra:会在使用集合时，子查询语句，如果只是获得集合的长度，会发送count语句查询
 *
 */
public class Demo02 {

	/**
	 * 关联级别懒加载
	 * 默认，与我关联的数据，在使用是才会加载
	 */
	@Test
	public void fun8(){
		//3 获得session
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
	 * 关联级别懒加载
	 * lazy：false
	 */
	@Test
	public void fun1(){
		//3 获得session
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
	 * 关联级别懒加载
	 * lazy：false/true
	 * fetch:join
	 */
	@Test
	public void fun2(){
		//3 获得session
				Session session = HebernateUtils.openSession();	
				session.beginTransaction();
				//-------------------
					Customer c = (Customer)session.get(Customer.class,1);
					//查询结果
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
	//关联级别懒加载
	//lazy：true
	//fetch:subselect
	@Test
	public void fun3(){
		//3 获得session
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
					System.out.println(c.getName()+"下单量"+c.getOrders().size());
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
	
	//关联级别懒加载
	//lazy：false
	//fetch:subselect
	@Test
	public void fun4(){
		//3 获得session
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
					System.out.println(c.getName()+"下单量");
				}
				

				        
				//------------------
				session.getTransaction().commit();
				session.close();
	}
	
	/**
	 * 关联级别懒加载
	 * lazy：extra
	 * fetch:select
	 */
	@Test
	public void fun5(){
		//3 获得session
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
//				榨菜
//				紫菜
	}
	
	/**
	 * 关联级别懒加载
	 * lazy：extra
	 * fetch:subselect
	 */
	@Test
	public void fun6(){
		//3 获得session
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
//				tomxiazai榨菜
//				tomxiazai紫菜
//				jerryxiazai糖果
//				jerryxiazai酸奶
				//------------------
				session.getTransaction().commit();
				session.close();
	}
	
	@Test
	public void fun7(){
		//3 获得session
				Session session = HebernateUtils.openSession();	
				session.beginTransaction();
				//-------------------
				
				
				//------------------
				session.getTransaction().commit();
				session.close();
	}
}
