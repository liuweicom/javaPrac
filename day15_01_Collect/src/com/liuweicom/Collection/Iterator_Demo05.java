package com.liuweicom.Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.liuweicom.bean.Student;

public class Iterator_Demo05 {
	/**
	 * ����
	 * * A:����������
	 * �����������洢Ԫ��,�洢��Ԫ����Ҫ�鿴,��ô����Ҫ����(����) 
	 */
	
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add(new Student("����",23));
		c.add(new Student("123��",25));
		c.add(new Student("��456��",24));
		c.add(new Student("����789",26));
		c.add(new Student("����aaaa",27));
		
		Iterator it = c.iterator();
		while(it.hasNext()){
			Student s =(Student) it.next();  //����ת��
			System.out.println(s);
		}
		
//		Student [age=23, name=����]
//				Student [age=25, name=123��]
//				Student [age=24, name=��456��]
//				Student [age=26, name=����789]
//				Student [age=27, name=����aaaa]

	}
}
