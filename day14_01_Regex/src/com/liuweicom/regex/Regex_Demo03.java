package com.liuweicom.regex;

public class Regex_Demo03 {
	/**
	 * Greedy ������ 
		X? X��һ�λ�һ��Ҳû�� 
		X* X����λ��� 
		X+ X��һ�λ��� 
		X{n} X��ǡ�� n �� 
		X{n,} X������ n �� 
		X{n,m} X������ n �Σ����ǲ����� m �� 
	 */
	
	public static void demo1() {
		String regex = "[abc]?";
		System.out.println("a".matches(regex));
		System.out.println("b".matches(regex));
		System.out.println("c".matches(regex));
		System.out.println("d".matches(regex));
		System.out.println("".matches(regex));
//		true
//		true
//		true
//		false
//		true

	}
	
	public static void demo2() {
		String regex = "[abc]*";
		System.out.println("".matches(regex));
		System.out.println("abc".matches(regex));
		System.out.println("c".matches(regex));
		System.out.println("d".matches(regex));
//		true
//		true
//		true
//		false
	}
	
	public static void demo3() {
		String regex = "[abc]+";
		System.out.println("".matches(regex));
		System.out.println("a".matches(regex));
		System.out.println("abccccccccccccc".matches(regex));
//		false
//		true
//		true

	}
	
	public static void demo4() {
		String regex = "[abc]{5}";
		System.out.println("abcab".matches(regex));
		System.out.println("b".matches(regex));
		System.out.println("abbbbbbbbcc".matches(regex));
		System.out.println("abcb".matches(regex));
		System.out.println("".matches(regex));
//		true
//		false
//		false
//		false
//		false

	}
	
	public static void demo8() {
		String regex = "[abc]{5,}";
		System.out.println("abcba".matches(regex));
		System.out.println("abbbbbbbbbbbbbbbcccc".matches(regex));
		System.out.println("cbca".matches(regex));
		System.out.println("abcbcabc".matches(regex));
//		true
//		true
//		false
//		true
	}
	
	public static void demo5() {
		String regex = "[abc]?";
		System.out.println("a".matches(regex));
		System.out.println("b".matches(regex));
		System.out.println("c".matches(regex));
		System.out.println("d".matches(regex));
		System.out.println("".matches(regex));
//		true
//		true
//		true
//		false
//		true
	}
	
	public static void demo6() {
		String regex = "[abc]{5,15}";
		System.out.println("ac".matches(regex));
		System.out.println("bccccccccc".matches(regex));
		System.out.println("abcc".matches(regex));
		
//		false
//		true
//		false
	}
	
	public static void main(String[] args) {
//		demo1();
//		demo2();
//		demo3();
//		demo4();
//		demo8();
//		demo5();
		demo6();
	}
}
