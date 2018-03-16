package com.liuweicom.Collection;

import java.util.ArrayList;
import java.util.Collection;

import com.liuweicom.bean.Student;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class Clooection_Demo02 {
	/**
	 * 基本功能演示
	 * 
	 * boolean add(E e)
	 * boolean remove(Object o)
	 * void clear()
	 * boolean contains(Object 0)
	 * int size()
	 * 
	 * B:注意:
		* 
				collectionXxx.java使用了未经检查或不安全的操作.
				注意:要了解详细信息,请使用 -Xlint:unchecked重新编译.
				java编译器认为该程序存在安全隐患
				温馨提示:这不是编译失败,所以先不用理会,等学了泛型你就知道了
		add方法如果是List集合一直都返回true,因为List集合中是可以存储重复元素的
		如果是Set集合当存储重复元素的时候,就会返回false
		
		add方法，用List集合可以存储重复元素
		Set集合，不能存储重复元素
		ArrayList的父类的父类重写了toString（）方法，所以在打印对象的引用的时候，打印的不是引用类型的地址
	 */
	public static void main(String[] args) {
		Collection c =new ArrayList();
		c.add("a");
		c.add("b");
		c.add("c");
		c.add("d");
		
		c.remove("a");
		c.clear();
		
		
		System.out.println(c.contains("b"));
		System.out.println(c.isEmpty());
		System.out.println(c.size());
		System.out.println(c);
//		false
//		true
//		0
//		[]
		System.out.println("------------");
		Collection c1 = new ArrayList();
		Boolean b1 = c1.add("abc");
		System.out.println(b1);
		Boolean b2 = c1.add(true);
		System.out.println(b2);
		Boolean b3 = c1.add(100);
		System.out.println(b3);
		Boolean b4 = c1.add(new Student("aaa",24));
		System.out.println(b4);
		Boolean b5 = c1.add(100);
		System.out.println(b5);  
		System.out.println(c1.toString());
//		true
//		true
//		true
//		true
		//true
//		[abc, true, 100, Student [age=24, name=aaa]]
	}
}
