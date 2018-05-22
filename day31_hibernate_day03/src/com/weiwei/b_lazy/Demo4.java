package com.weiwei.b_lazy;

import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import com.weiwei.domain.Customer;
import com.weiwei.utils.HebernateUtils;

public class Demo4 {
	/**
	 * 查询所有客户
	 * 遍历客户，打印客户下的订单信息
	 */
	@Test
	public void fun1(){
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
//				            ?, ?
//				        )
				for(Customer c:list){
					System.out.println(c.getOrders().size());
				}
				//------------------
				session.getTransaction().commit();
				session.close();
	}
}
