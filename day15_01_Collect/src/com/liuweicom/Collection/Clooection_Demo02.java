package com.liuweicom.Collection;

import java.util.ArrayList;
import java.util.Collection;

import com.liuweicom.bean.Student;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class Clooection_Demo02 {
	/**
	 * ����������ʾ
	 * 
	 * boolean add(E e)
	 * boolean remove(Object o)
	 * void clear()
	 * boolean contains(Object 0)
	 * int size()
	 * 
	 * B:ע��:
		* 
				collectionXxx.javaʹ����δ�����򲻰�ȫ�Ĳ���.
				ע��:Ҫ�˽���ϸ��Ϣ,��ʹ�� -Xlint:unchecked���±���.
				java��������Ϊ�ó�����ڰ�ȫ����
				��ܰ��ʾ:�ⲻ�Ǳ���ʧ��,�����Ȳ������,��ѧ�˷������֪����
		add���������List����һֱ������true,��ΪList�������ǿ��Դ洢�ظ�Ԫ�ص�
		�����Set���ϵ��洢�ظ�Ԫ�ص�ʱ��,�ͻ᷵��false
		
		add��������List���Ͽ��Դ洢�ظ�Ԫ��
		Set���ϣ����ܴ洢�ظ�Ԫ��
		ArrayList�ĸ���ĸ�����д��toString���������������ڴ�ӡ��������õ�ʱ�򣬴�ӡ�Ĳ����������͵ĵ�ַ
	 */
	public static void main(String[] args) {
		Collection c =new ArrayList();
		c.add("a");
		c.add("b");
		c.add("c");
		c.add("d");
		
		c.remove("a");
		c.clear();
		
		
		System.out.println(c.contains("b"));
		System.out.println(c.isEmpty());
		System.out.println(c.size());
		System.out.println(c);
//		false
//		true
//		0
//		[]
		System.out.println("------------");
		Collection c1 = new ArrayList();
		Boolean b1 = c1.add("abc");
		System.out.println(b1);
		Boolean b2 = c1.add(true);
		System.out.println(b2);
		Boolean b3 = c1.add(100);
		System.out.println(b3);
		Boolean b4 = c1.add(new Student("aaa",24));
		System.out.println(b4);
		Boolean b5 = c1.add(100);
		System.out.println(b5);  
		System.out.println(c1.toString());
//		true
//		true
//		true
//		true
		//true
//		[abc, true, 100, Student [age=24, name=aaa]]
	}
}
