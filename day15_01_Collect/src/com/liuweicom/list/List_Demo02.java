package com.liuweicom.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class List_Demo02 {
	
	/**
	 ** A:������ʾ
	 * ��������һ�����ϣ����ʣ������ж�������û��"world"���Ԫ�أ�����У��Ҿ����һ��"javaee"Ԫ�أ���д����ʵ�֡�
	 */
	//�����ӿ��޸�
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("a");
		list.add("b");
		list.add("world");
		list.add("c");
		list.add("d");
		
		Iterator it =list.iterator();
		while(it.hasNext()){
			String str =(String) it.next();
			if("world".equals(str)){
				list.add("javaee");
			}
		}
		
		ListIterator lt1 =list.listIterator();
		while(lt1.hasNext()){
			String str =(String) lt1.next();
			if("world".equals(str)){
				list.add("javaee");
			}
		}
	}
	
}
