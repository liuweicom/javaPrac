package com.liuweicom.regex;

public class Regex_Demo01 {
	/**
	 * [abc]a,b��c
	 * [a-zA-Z]a-z��A-Z
	 * [a-d[m-p]]a-d��m-p
	 * [a-z&&[def]]d��e��f
	 * [a-z&&[^bc]]a �� z������ b �� c��[ad-z]����ȥ��
	 * [a-z&&[^m-p]]a �� z������ m �� p
	 */
	private static void demo1(){
		String regex = "[abc]";
		System.out.println("a".matches(regex));
		System.out.println("b".matches(regex));
		System.out.println("c".matches(regex));
		System.out.println("d".matches(regex));
		System.out.println("l".matches(regex));
		System.out.println("%".matches(regex));
//		true
//		true
//		true
//		false
//		false
//		false

	}
	
	private static void demo2(){
		String regex = "[^abc]";
		System.out.println("a".matches(regex));
		System.out.println("b".matches(regex));
		System.out.println("c".matches(regex));
		System.out.println("d".matches(regex));
		System.out.println("1".matches(regex));
		System.out.println("%".matches(regex));
		System.out.println("10".matches(regex));
//		false
//		false
//		false
//		true
//		true
//		true
//		false
	}
	
	private static void demo3(){
		String regex = "[a-zA-Z]";
		System.out.println("a".matches(regex));
		System.out.println("A".matches(regex));
		System.out.println("z".matches(regex));
		System.out.println("Z".matches(regex));
		System.out.println("l".matches(regex));
		System.out.println("%".matches(regex));
//		true
//		true
//		true
//		true
//		true
//		false
	}
	
	
	private static void demo4(){
		String regex = "[a-d[m-p]]";
		System.out.println("a".matches(regex));
		System.out.println("m".matches(regex));
		System.out.println("n".matches(regex));
//		true
//		true
//		true

	}
	
	private static void demo5(){
		String regex = "[a-z&&[def]]";
		System.out.println("a".matches(regex));
		System.out.println("d".matches(regex));
		System.out.println("e".matches(regex));
//		false
//		true
//		true
	}
	
	private static void demo6(){
		String regex = "[a-z&&[^bc]]";
		System.out.println("a".matches(regex));
		System.out.println("b".matches(regex));
		System.out.println("l".matches(regex));
//		true
//		false
//		true
	}
	
	public static void main(String[] args) {
		//true
				//false
				//true
				//false
//		String regex ="[a-z&&[^m-p]]";
//		System.out.println("a".matches(regex));
//		System.out.println("m".matches(regex));
//		System.out.println("z".matches(regex));
//		System.out.println("n".matches(regex));
		
//		demo6();
//		demo5();
//		demo4();
//		demo3();
//		demo2();
		demo1();
	}
}
