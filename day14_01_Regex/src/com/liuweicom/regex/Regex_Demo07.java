package com.liuweicom.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex_Demo07 {
	/**
	 * Pattern p = Pattern.compile("a*b");
	 *Matcher m = p.matcher("aaaaaab");
	 *boolean b =m.matches();
	 * @param args
	 * 
	 * A:正则表达式的获取功能
			* Pattern和Matcher的结合使用
		* B:案例演示
			* 需求：把一个字符串中的手机号码获取出来
	 */
	public static void main(String[] args) {
//		String a="我的手机是18988888888,我曾用过18987654321,还用过18812345678";
//		Pattern p = Pattern.compile("1[3578]\\d{9}");
//		Matcher m = p.matcher(a);
//		
//		boolean b = m.find();
//		System.out.println(b);
//		System.out.println(m.group());
//		
//		boolean b2 = m.find();
//		System.out.println(b2);
//		System.out.println(m.group());
		
//		true
//		18988888888
//		true
//		18987654321
		
		demo01();
	}
	
	public static void demo01(){
		Pattern p =Pattern.compile("a*b");  //获取正则表达式
		Matcher m = p.matcher("aaaaaab"); //获取匹配器
		boolean b = m.matches();          //看是否匹配，匹配就返回true
		
		System.out.println(b);
		System.out.println("aaaaaab".matches("a*b"));
		
//		true
//		true
	}
}
