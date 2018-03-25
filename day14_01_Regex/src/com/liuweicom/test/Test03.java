package com.liuweicom.test;

import java.util.Calendar;
import java.util.Scanner;

/**
 * * A:案例演示
 * 需求：键盘录入任意一个年份，判断该年是闰年还是平年
 * Calendar c = Calendar.getInstance();
 * 
 * 分析:
 * 1,键盘录入年Scanner
 * 2,创建Calendar c = Calendar.getInstance();
 * 3,通过set方法设置为那一年的3月1日
 * 4,将日向前减去1
 * 5,判断日是多少天,如果是29天返回true否则返回false
 */
public class Test03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入年份,判断该年份是闰年还是平年:");
		
		String line = sc.nextLine();
		
		Calendar c =Calendar.getInstance();
		c.set(Integer.parseInt(line),2,1);
		c.add(Calendar.DAY_OF_MONTH,-1);
		boolean isTrue = c.get(Calendar.DAY_OF_MONTH) == 29;
		System.out.println(isTrue);
		System.out.println();
	}
}
