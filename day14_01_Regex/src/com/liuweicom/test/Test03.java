package com.liuweicom.test;

import java.util.Calendar;
import java.util.Scanner;

/**
 * * A:������ʾ
 * ���󣺼���¼������һ����ݣ��жϸ��������껹��ƽ��
 * Calendar c = Calendar.getInstance();
 * 
 * ����:
 * 1,����¼����Scanner
 * 2,����Calendar c = Calendar.getInstance();
 * 3,ͨ��set��������Ϊ��һ���3��1��
 * 4,������ǰ��ȥ1
 * 5,�ж����Ƕ�����,�����29�췵��true���򷵻�false
 */
public class Test03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("���������,�жϸ���������껹��ƽ��:");
		
		String line = sc.nextLine();
		
		Calendar c =Calendar.getInstance();
		c.set(Integer.parseInt(line),2,1);
		c.add(Calendar.DAY_OF_MONTH,-1);
		boolean isTrue = c.get(Calendar.DAY_OF_MONTH) == 29;
		System.out.println(isTrue);
		System.out.println();
	}
}
