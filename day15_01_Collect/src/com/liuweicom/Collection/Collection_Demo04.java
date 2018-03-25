package com.liuweicom.Collection;

import java.util.ArrayList;
import java.util.Collection;

public class Collection_Demo04 {
	/**
	 * * A:案例演示
		* 
				带All的功能演示
				boolean addAll(Collection c)
				boolean removeAll(Collection c)
				boolean containsAll(Collection c)
				boolean retainAll(Collection c)
	 */
	
	public static void main(String[] args) {
		Collection c1 =new ArrayList();
		c1.add("a");
		c1.add("b");
		c1.add("c");
		c1.add("d");
		
		Collection c2 =new ArrayList();
		c2.add("e");
		c2.add("f");
		c2.add("c");
		c2.add("d");
		
		boolean b = c1.retainAll(c2); //判断调用的集合是否包含交集
		System.out.println(b);
		System.out.println(c1); //交集部分
		System.out.println(c2);
//		true
//		[c, d]
//		[e, f, c, d]
//		
		System.out.println("----------");
		c1.add(c2);				//将c2看成一个对象添加到c1中[c, d, [e, f, c, d]]
		System.out.println(c1);
		c1.addAll(c2);			//将c2中的每一个元素添加到c1中[c, d, [e, f, c, d], e, f, c, d]
		System.out.println(c1);
		System.out.println(c2);//[e, f, c, d]
//		[c, d, [e, f, c, d]]
//				[c, d, [e, f, c, d], e, f, c, d]
//				[e, f, c, d]
		
		
		
		System.out.println("---------");
		Boolean b2 =c1.removeAll(c2);   //删除的交集
		System.out.println(b2);//true
		System.out.println(c1);//[[e, f, c, d]]
		
		
//		true
//		[[e, f, c, d]]
	}
}
