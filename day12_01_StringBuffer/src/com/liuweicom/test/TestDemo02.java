package com.liuweicom.test;

import java.util.Scanner;

public class TestDemo02 {

	/**
	 * * A:������ʾ
	* 
			���󣺰��ַ�����ת
				����������¼��"abc"		
				��������"cba"
				
			��StringBuffer�Ĺ���ʵ��	
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
