package com.liuweicom.regex;

public class Regex_Demo02 {
	/**
	 * 
	 * .�κ��ַ�
	 * \d���顾0-9��
	 * \D������[^0-9]
	 * \s�հ��ַ�[\t\n\x0b\f\r]
	 * \S�ǿհ��ַ�[^\s]
	 * \w�����ַ�[a-zA-z_0-9]
	 * \W�ǵ����ַ�[^\w]
	 */
	public static void demo1(){
		String regex="..";
		System.out.println("a".matches(regex));
		System.out.println("ab".matches(regex));
		
//		false
//		true
	}
	
	public static void demo2(){
		String regex="\\d";
		System.out.println("a".matches(regex));
		System.out.println("1".matches(regex));
		System.out.println("9".matches(regex));
		
//		false
//		true
//		true
	}
	
	public static void demo3(){
		String regex="\\D";
		System.out.println("a".matches(regex));
		System.out.println("0".matches(regex));
		System.out.println("9".matches(regex));
//		true
//		false
//		false

	}
	
	public static void demo4(){
		String regex="\\s";
		System.out.println(" ".matches(regex));
		System.out.println("     ".matches(regex));//����ո�
		System.out.println("	".matches(regex));
//		true
//		false
//		true
	}
	
	public static void demo5(){
		String regex="\\S";
		System.out.println("a".matches(regex));
		System.out.println(" ".matches(regex));
		System.out.println("  ".matches(regex));
//		true
//		false
//		false
	}
	
	public static void demo6(){
		String regex="\\w";
		System.out.println("a".matches(regex));
		System.out.println("0".matches(regex));
		System.out.println("_".matches(regex));
		System.out.println("%".matches(regex));
//		true
//		true
//		true
//		false
	}
	
	public static void demo7(){
		String regex="\\W";
		System.out.println("a".matches(regex));
		System.out.println("0".matches(regex));
		System.out.println("_".matches(regex));
		System.out.println("%".matches(regex));
//		false
//		false
//		false
//		true
	}
	
	public static void main(String[] args) {
//		demo1();
//		demo2();
//		demo3();
//		demo4();
//		demo5();
//		demo6();
		demo7();
	}
}

