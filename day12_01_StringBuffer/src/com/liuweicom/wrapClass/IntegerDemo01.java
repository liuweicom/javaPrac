package com.liuweicom.wrapClass;

public class IntegerDemo01 {
	/**
	 * 为什么会有基本封装类包装类
	 * 	将基本数据类型封装成对象的好处在于可以在对象中定义更多的功能方法操作该数据。
	 * 常用对象
	 * 	常用的操作之一：基于基本数据类型与字符串之间的转换
	 * 数据类型和包装类的对应
	 * 		byte      Byte
	 * 		short     Short
	 * 		int			Integer
	 * 		long       Long
	 * 		float      Float
	 * 		double     Double
	 * 		char		Char
	 * 		boolean     Boolean
	 */
	
	
	/**
	 * Interger类概述
	 * 		通过提供的API
	 * Integer 类在对象中包装了一个基本类型的int类型
	 * 该类提供了多个方法，能在int类型和String类型之间的互相转换
	 * 还提供了处理int类型时，非常有用的其他一些常量和方法
	 * 
	 * 构造函数
	 * public Integer(int value)
	 * public Integer(String s)
	 */
	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		
		Integer i1 = new Integer(100);
		System.out.println(i1);
		
		Integer i3 = new Integer("100");		//如果字符串不是表示数字的字符串，转换中会报错java.lang.NumberFormatException
		System.out.println(i3);
		
		/**
		 * int------String
		 * 1.int+""进行拼接
		 * 2。public static String valueOf(int i);
		 * 3.int ----Integer------String
		 * 		public static String toString(int i)(Integer的静态方法)
		 */
		
		
		/**
		 * String---int
		 * 1.String----Integer-----int
		 * 		public static int parseInt(String s);
		 * 基本数据类型包括类有八中，其中其中七种都有parse***的方法，可以将其中这七种的字符串表现形式转换成基本数据类型
		 */
		
		String s1="true";
		boolean b =Boolean.parseBoolean(s1);
		System.out.println(b);
		
		//char的包装类没有Character中没有parseXXX的方法
		//字符串到字符的转让通过toCharArray()就可以把字符串转换成字符数组
		int i = 100;
		String s2=i+"";
		String s3=Integer.toString(i);
		
		Integer i2 = new Integer(i);
		String s4 = i2.toString();
		
		//String --- int String 转换int
		String s="200";
		Integer i4 = new Integer(s);
		int i5 = i4.intValue();//将Integer转换成int数
		
		int i6 = Integer.parseInt(s);
	}
	
}
