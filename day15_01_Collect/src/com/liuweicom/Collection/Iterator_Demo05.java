package com.liuweicom.Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.liuweicom.bean.Student;

public class Iterator_Demo05 {
	/**
	 * 迭代
	 * * A:迭代器概述
	 * 集合是用来存储元素,存储的元素需要查看,那么就需要迭代(遍历) 
	 */
	
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add(new Student("張三",23));
		c.add(new Student("123三",25));
		c.add(new Student("張456三",24));
		c.add(new Student("張三789",26));
		c.add(new Student("張三aaaa",27));
		
		Iterator it = c.iterator();
		while(it.hasNext()){
			Student s =(Student) it.next();  //向下转型
			System.out.println(s);
		}
		
//		Student [age=23, name=張三]
//				Student [age=25, name=123三]
//				Student [age=24, name=張456三]
//				Student [age=26, name=張三789]
//				Student [age=27, name=張三aaaa]

	}
}
