package com.liuweicom.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class List_Demo02 {
	
	/**
	 ** A:案例演示
	 * 需求：我有一个集合，请问，我想判断里面有没有"world"这个元素，如果有，我就添加一个"javaee"元素，请写代码实现。
	 */
	//遍历加可修改
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
