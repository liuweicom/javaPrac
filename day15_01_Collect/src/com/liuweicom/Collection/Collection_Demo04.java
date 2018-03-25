package com.liuweicom.Collection;

import java.util.ArrayList;
import java.util.Collection;

public class Collection_Demo04 {
	/**
	 * * A:������ʾ
		* 
				��All�Ĺ�����ʾ
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
		
		boolean b = c1.retainAll(c2); //�жϵ��õļ����Ƿ��������
		System.out.println(b);
		System.out.println(c1); //��������
		System.out.println(c2);
//		true
//		[c, d]
//		[e, f, c, d]
//		
		System.out.println("----------");
		c1.add(c2);				//��c2����һ��������ӵ�c1��[c, d, [e, f, c, d]]
		System.out.println(c1);
		c1.addAll(c2);			//��c2�е�ÿһ��Ԫ����ӵ�c1��[c, d, [e, f, c, d], e, f, c, d]
		System.out.println(c1);
		System.out.println(c2);//[e, f, c, d]
//		[c, d, [e, f, c, d]]
//				[c, d, [e, f, c, d], e, f, c, d]
//				[e, f, c, d]
		
		
		
		System.out.println("---------");
		Boolean b2 =c1.removeAll(c2);   //ɾ���Ľ���
		System.out.println(b2);//true
		System.out.println(c1);//[[e, f, c, d]]
		
		
//		true
//		[[e, f, c, d]]
	}
}
