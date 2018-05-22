package com.weiwei.e_api;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.weiwei.domain.Customer;
import com.weiwei.utils.HebernateUtils;

public class Demo1 {
	@Test
	//验证c3p0连接池
	public void fun1(){
		//3 获得session
		Session session = HebernateUtils.openSession();	
		session.beginTransaction();
		//
		System.out.println(session);
		//
		session.getTransaction().commit();
		session.close(); // 游离状态
	}
}
