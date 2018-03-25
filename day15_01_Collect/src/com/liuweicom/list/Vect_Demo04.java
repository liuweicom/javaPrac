package com.liuweicom.list;

import java.util.Enumeration;
import java.util.Vector;

public class Vect_Demo04 {

	/**
	 * Vector类特有功能
	* public void addElement(E obj)
	* public E elementAt(int index)
	* public Enumeration elements()
	 */
	public static void main(String[] args) {
		Vector v =new Vector();
		v.addElement("a");
		v.addElement("b");
		v.addElement("c");
		v.addElement("d");
		
		Enumeration en =v.elements();  //获得枚举
		while(en.hasMoreElements()){	//判断集合中是否有元素
			System.out.println(en.nextElement());//获取集合中的元素
		}
//		a
//		b
//		c
//		d
	}
	
}
