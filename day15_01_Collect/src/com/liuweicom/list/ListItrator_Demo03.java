package com.liuweicom.list;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListItrator_Demo03 {
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("a");									//Object obj = new String();
		list.add("b");
		list.add("world");
		list.add("c");
		list.add("d");
		list.add("e");
		
		ListIterator lit = list.listIterator();//��ȡ������
		while(lit.hasNext()){
			System.out.println(lit.next());//��ȡԪ�ز���ָ������ƶ�
		}
//		a
//		b
//		world
//		c
//		d
//		e
		System.out.println("----------");
		while(lit.hasPrevious()){
			System.out.println(lit.previous());
		}
		
//		e
//		d
//		c
//		world
//		b
//		a

	}
}
