package com.liuweicom.list;

import java.util.Enumeration;
import java.util.Vector;

public class Vect_Demo04 {

	/**
	 * Vector�����й���
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
		
		Enumeration en =v.elements();  //���ö��
		while(en.hasMoreElements()){	//�жϼ������Ƿ���Ԫ��
			System.out.println(en.nextElement());//��ȡ�����е�Ԫ��
		}
//		a
//		b
//		c
//		d
	}
	
}
