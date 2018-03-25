package com.liuweicom.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * * A:案例演示
 * 需求：算一下你来到这个世界多少天?
 * 分析:
 * 1,将生日字符串和今天字符串存在String类型的变量中
 * 2,定义日期格式化对象
 * 3,将日期字符串转换成日期对象
 * 4,通过日期对象后期时间毫秒值
 * 5,将两个时间毫秒值相减除以1000,再除以60,再除以60,再除以24得到天
 * @throws ParseException 
 */
public class Test02 {
	public static void main(String[] args) throws Exception {
		//1,将生日字符串和今天字符串存在String类型的变量中
		String d1="1994年08月08日";
		String d2="2018年03月15日";
		//2,定义日期格式化对象
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		//3,将日期字符串转换成日期对象
		Date d3 = sdf.parse(d1);
		Date d4 = sdf.parse(d2);
		//4,通过日期对象后期时间毫秒值
		long time = d4.getTime()-d3.getTime();
		//5,将两个时间毫秒值相减除以1000,再除以60,再除以60,再除以24得到天
		System.out.println(time/(24*60*60*1000));
	}
}
