package com.liuweicom.otherClass;

import java.math.BigInteger;

public class BigInteger_Demo04 {
	/**
	 * BigInteger�ĸ���
	 * �����ó���Integer��Χ�����ݽ�������
	 * public BigInteger(String val);
	 * ��Ա����
	 * public BigInteger add(BigInteger val); => +
	 * public BigInteger subtract(BigInteger val) => -
	 * public BigInteger multiply(BigInteger val); => *
	 * public BigInteger divide(BigInteger val) =>/
	 * public BigInteger[] divideAndRemainder(BigInteger val);ȥ����������
	 */

	public static void main(String[] args) {
		BigInteger b1 = new BigInteger("100");
		BigInteger b2 = new BigInteger("100");
		
		System.out.println(b1.add(b2));
		System.out.println(b1.subtract(b2));
		System.out.println(b1.multiply(b2));
		System.out.println(b1.divide(b2));
		
		System.out.println("------------");
		BigInteger[] arr = b1.divideAndRemainder(b2);
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		
//		200
//		0
//		10000
//		1
//		------------
//		1
//		0

	}
}
