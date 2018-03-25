package com.liuweicom.test;

import java.util.Scanner;

public class TestDemo02 {

	/**
	 * * A:案例演示
	* 
			需求：把字符串反转
				举例：键盘录入"abc"		
				输出结果："cba"
				
			用StringBuffer的功能实现	
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		
		System.out.println(revString(line));
	}
	public static String revString(String line){
		StringBuffer sb = new StringBuffer(line);
		sb.reverse();
		return sb.toString();
	}
}
