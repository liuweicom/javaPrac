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
	 * A:������ʽ�Ļ�ȡ����
			* Pattern��Matcher�Ľ��ʹ��
		* B:������ʾ
			* ���󣺰�һ���ַ����е��ֻ������ȡ����
	 */
	public static void main(String[] args) {
//		String a="�ҵ��ֻ���18988888888,�����ù�18987654321,���ù�18812345678";
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
		Pattern p =Pattern.compile("a*b");  //��ȡ������ʽ
		Matcher m = p.matcher("aaaaaab"); //��ȡƥ����
		boolean b = m.matches();          //���Ƿ�ƥ�䣬ƥ��ͷ���true
		
		System.out.println(b);
		System.out.println("aaaaaab".matches("a*b"));
		
//		true
//		true
	}
}
