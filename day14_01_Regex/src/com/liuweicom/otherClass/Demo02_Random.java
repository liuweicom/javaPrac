package com.liuweicom.otherClass;

import java.util.Random;

public class Demo02_Random {

	/**
	 * * A:Random��ĸ���
			* �������ڲ���������������ͬ�����Ӵ������� Random ʵ����
			* ���ÿ��ʵ��������ͬ�ķ����������У����ǽ����ɲ�������ͬ���������С�
		* B:���췽��
			* public Random()
			* public Random(long seed)
		* C:��Ա����
			* public int nextInt()
			* public int nextInt(int n)(�ص�����)
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
			����ٸ�����:Random r=new Random(100);int a=r.nextInt();int b=r.nextInt();
			ab��ֵ�᲻ͬ���������������飬ab��ֵ���ᷢ���ı䣬��Ϊab������������������ģ�ÿ����һ��nextInt����һ��
			���ظ�����ֵ��һ����
		 */
		System.out.println(a);
		System.out.println(b);
//		-1245131070
//		-2078988849
	}
}
