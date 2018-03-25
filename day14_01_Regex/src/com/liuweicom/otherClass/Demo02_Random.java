package com.liuweicom.otherClass;

import java.util.Random;

public class Demo02_Random {

	/**
	 * * A:Random类的概述
			* 此类用于产生随机数如果用相同的种子创建两个 Random 实例，
			* 则对每个实例进行相同的方法调用序列，它们将生成并返回相同的数字序列。
		* B:构造方法
			* public Random()
			* public Random(long seed)
		* C:成员方法
			* public int nextInt()
			* public int nextInt(int n)(重点掌握)
	 */
	public static void main(String[] args) {
		Random r = new Random();
		for(int i =0; i<10;i++){
//			System.out.println(r.nextInt(100));
//			95
//			69
//			71
//			94
//			57
//			34
//			82
//			84
//			87
//			44
			System.out.println(r.nextInt());
			
//			264853078
//			579617736
//			-1168585317
//			42788234
//			835349989
//			689825238
//			-1817699265
//			241215540
//			482977071
//			1599599089
		}
		
		System.out.println("--------------");
		Random r2 = new Random(1001);
		int a = r2.nextInt();
		int b = r2.nextInt();
		
		/*
		 * 
			给你举个例子:Random r=new Random(100);int a=r.nextInt();int b=r.nextInt();
			ab的值会不同，但是你运行两遍，ab的值不会发生改变，因为ab都是利用种子算出来的，每调用一次nextInt就算一次
			，重复调用值是一样的
		 */
		System.out.println(a);
		System.out.println(b);
//		-1245131070
//		-2078988849
	}
}
