package com.liuweicom.otherClass;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormat_Demo07 {
/**
 * DataFormat类的概述
 * DateFormat是日期、时间格式化子类的抽象类，它可以与语言无关的方式格式话并解析日期或时间，
 * 是抽象类，所以使用其子类SimpleDataFormat
 * SimpleDateFormat够着方法
 * public SimpleDateFormat（）
 * public SimpleDateFormat（String pattern）
 * 
 * 成员方法
 * public final String format(Date Date);
 * public Date parse(String source)
 * ;
 * @throws Exception 
 */
	public static void main(String[] args) throws Exception {
		String str = "2000年08月08日  08:08:08";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");
		Date d = sdf.parse(str); //将时间字符串转换成日期对象
		System.out.println(d); //Tue Aug 08 08:08:08 CST 2000
		System.out.println("-----------");
		Date d1 = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");
		SimpleDateFormat sdf2 = new SimpleDateFormat();
		String s = sdf1.format(d1);
		System.out.println(s);
		System.out.println(sdf2.format(d1));
//		2018年03月14日  18:28:28
//		18-3-14 下午6:28
		System.out.println("----------");
		//实例化
		//DateFormat是抽象类,不允许实例化
		
		DateFormat df1 = new SimpleDateFormat();
		//相当于父类引用指向子类对象,右边的方法返回一个子类对象
		DateFormat df2 = DateFormat.getDateInstance();
		
	}
}
