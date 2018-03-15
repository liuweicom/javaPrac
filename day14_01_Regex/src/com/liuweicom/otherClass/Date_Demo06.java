package com.liuweicom.otherClass;

import java.util.Date;

public class Date_Demo06 {
	/**
	 * Date类的概述是在util包下的，不能导入sql包的
	 *  
	 *  public Date();
	 *  public Date(long date);
	 *  
	 *  public long getTime();
	 *  public void setTime(lone time);
	 */
	public static void demo1(){
		
	}
	
	public static void demo2(){
			
	}
	
	public static void main(String[] args) {
		//如果没有传参数代表的是当前时间
		Date d = new Date();
		System.out.println(d);
		
		//如果够着方法中参数传为0代表的是1970年1月1日
				//通过毫秒值创建时间对象
		Date d1 = new Date(0);
		System.out.println(d1);
		
		System.out.println(d.getTime());
		System.out.println(System.currentTimeMillis());
		
		d1.setTime(1000);
		System.out.println(d1);
		
		
//		
//		Wed Mar 14 17:46:54 CST 2018
//		Thu Jan 01 08:00:00 CST 1970
//		1521020814950
//		1521020814970
//		Thu Jan 01 08:00:01 CST 1970

	}
}
