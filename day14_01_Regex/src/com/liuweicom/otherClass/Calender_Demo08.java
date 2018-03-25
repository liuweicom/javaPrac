package com.liuweicom.otherClass;

import java.util.Calendar;

/**
 * Calender 类的概述
 * Calender类是一个抽象类，他为特定瞬间与一组诸如YEAR，MONTH,DAY_OF_MONTH,HOUR等日历字段之间的转换提供了一些字段，并未操作日历字段，提供了一些方法
 * public static Calendar getInstance()
 * public int get(int field);
 * 
 *  public final void set(int year, int month, int date)
 *  public void add(int field,int amount)
 * @author 工号
 *
 */
public class Calender_Demo08 {

	public static void demo1(){
		Calendar c =Calendar.getInstance(); 
		System.out.println(c.get(Calendar.YEAR));
		System.out.println(c.get(Calendar.MONTH));//从0开始
		System.out.println(c.get(Calendar.DAY_OF_MONTH));//一个月的第几天
		System.out.println(c.get(Calendar.DAY_OF_WEEK));//周日是第一天，周六是最后一天
		//2018
//		2
//		14
//		4周三
		
	}
	public static void main(String[] args) {
//		demo1();
		Calendar c = Calendar.getInstance();//父类引用指向子类对象
		c.add(Calendar.YEAR, -1);//对指定的字段进行向前减或向后加
		c.set(Calendar.YEAR, 2000);
		c.set(2001,7,8);
		System.out.println(c.get(Calendar.YEAR)+"年"+getNum(c.get(Calendar.MONTH))+"月"+getNum(c.get(Calendar.DAY_OF_MONTH))+"日"+getWeek(c.get(Calendar.DAY_OF_WEEK)));
		
	}
	
	public static String getWeek(int week){
		String[] arr ={"","星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
		return arr[week];
	}
	
	public static String getNum(int num){
		if(num>9){
			return ""+num;
		}
		return "0"+num;
		
		
	}
}
