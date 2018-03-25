package com.liuweicom.list;

import java.util.ArrayList;
import java.util.List;

public class List_Demo01 {
	/**
	 * void add(int index,E element);
	 * E remove(int index);
	 * E get(int index)
	 * E set(int index,E element)
	 */
	public static void main(String[] args) {
		List list =new ArrayList();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add(11);
		list.add("12");
		
		list.add(1,"o");//index<=size并且index>=0都不会报异常
//		list.add(10,"ff");//java.lang.IndexOutOfBoundsException,当存储时使用不存在的索引时
		System.out.println(list);
		
//		[a, o, b, c, d]
		System.out.println("------------");
		
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		
//		a
//		o
//		b
//		c
//		d
		System.out.println("----------");
		
		Object obj = list.remove(0);
//		Boolean obj = list.remove("a"); //true
//		Object  obj = list.remove(11);//java.lang.IndexOutOfBoundsException,不会解析自动装箱成元素11，把它当成index
//		Object obj = list.remove("12");//true
		System.out.println(obj);
		System.out.println(list);
		
		
//		a
//		[o, b, c, d]
		System.out.println("----------");
	}
}
