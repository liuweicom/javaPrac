package com.liuweicom.regex;

public class Regex_Demo01 {
	/**
	 * [abc]a,b或c
	 * [a-zA-Z]a-z或A-Z
	 * [a-d[m-p]]a-d或m-p
	 * [a-z&&[def]]d或e或f
	 * [a-z&&[^bc]]a 到 z，除了 b 和 c：[ad-z]（减去）
	 * [a-z&&[^m-p]]a 到 z，而非 m 到 p
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
