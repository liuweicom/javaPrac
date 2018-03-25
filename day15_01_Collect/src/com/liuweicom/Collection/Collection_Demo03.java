package com.liuweicom.Collection;

import java.util.ArrayList;
import java.util.Collection;

import com.liuweicom.bean.Student;

public class Collection_Demo03 {
	/**
	 * 集合的遍历
	 * 其实就是依次获取结合中的每一个元素
	 * 
	 * 
	 * 先把集合转成数组，可以实现集合的遍历
	 */
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add(new Student("張三",23));
		c.add(new Student("123三",25));
		c.add(new Student("張456三",24));
		c.add(new Student("張三789",26));
		c.add(new Student("張三aaaa",27));
		
		Object[] arr = c.toArray();
		for(int i=0;i<arr.length;i++){
			Student s =(Student) arr[i];
			System.out.println(s.toString());
		}
		
//		Student [age=23, name=張三]
//				Student [age=25, name=123三]
//				Student [age=24, name=張456三]
//				Student [age=26, name=張三789]
//				Student [age=27, name=張三aaaa]

		
	}
}
