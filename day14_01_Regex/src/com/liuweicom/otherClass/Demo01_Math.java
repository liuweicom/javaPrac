package com.liuweicom.otherClass;

public class Demo01_Math {
	/**
	 * @param args
	 * * A:Math�����
		* Math ���������ִ�л�����ѧ����ķ����������ָ����������ƽ���������Ǻ����� 
	* B:��Ա����
		* public static int abs(int a)
		* public static double ceil(double a)
		* public static double floor(double a)
		* public static int max(int a,int b) min��ѧ
		* public static double pow(double a,double b)
		* public static double random()
		* public static int round(float a) ����Ϊdouble����ѧ
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
