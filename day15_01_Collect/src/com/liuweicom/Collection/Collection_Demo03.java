package com.liuweicom.Collection;

import java.util.ArrayList;
import java.util.Collection;

import com.liuweicom.bean.Student;

public class Collection_Demo03 {
	/**
	 * ���ϵı���
	 * ��ʵ�������λ�ȡ����е�ÿһ��Ԫ��
	 * 
	 * 
	 * �ȰѼ���ת�����飬����ʵ�ּ��ϵı���
	 */
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add(new Student("����",23));
		c.add(new Student("123��",25));
		c.add(new Student("��456��",24));
		c.add(new Student("����789",26));
		c.add(new Student("����aaaa",27));
		
		Object[] arr = c.toArray();
		for(int i=0;i<arr.length;i++){
			Student s =(Student) arr[i];
			System.out.println(s.toString());
		}
		
//		Student [age=23, name=����]
//				Student [age=25, name=123��]
//				Student [age=24, name=��456��]
//				Student [age=26, name=����789]
//				Student [age=27, name=����aaaa]

		
	}
}
