package com.liuweicom.otherClass;

public class Demo01_Math {
	/**
	 * @param args
	 * * A:Math类概述
		* Math 类包含用于执行基本数学运算的方法，如初等指数、对数、平方根和三角函数。 
	* B:成员方法
		* public static int abs(int a)
		* public static double ceil(double a)
		* public static double floor(double a)
		* public static int max(int a,int b) min自学
		* public static double pow(double a,double b)
		* public static double random()
		* public static int round(float a) 参数为double的自学
		* public static double sqrt(double a)
	 */
	public static void main(String[] args) {
		System.out.println(Math.PI);
		System.out.println(Math.abs(-10));
		
		System.out.println(Math.ceil(12.3));
		
		System.out.println(Math.ceil(12.99));
		
		System.out.println(Math.floor(12.99));
		System.out.println(Math.floor(12.3));
		
		System.out.println(Math.pow(2,3));
		
		System.out.println(Math.max(12,13));
		
		System.out.println(Math.random());
		
		System.out.println(Math.round(12.3));
		System.out.println(Math.round(12.3));
		
		System.out.println(Math.sqrt(4));
		System.out.println(Math.sqrt(9));
		System.out.println(Math.sqrt(1));
		
		
//		3.141592653589793
//		10
//		13.0
//		13.0
//		12.0
//		12.0
//		8.0
//		13
//		0.2169630340841192
//		12
//		12
//		2.0
//		3.0
//		1.0
		
	}
}
