package com.liuweicom.wrapClass;

public class IntegerDemo03 {
	/**
	 * -128��127��byte��ȡֵ��Χ����������ȡֵ��Χ�ڣ��Զ�װ��Ͳ�������´������󣬶��ǴӲ������л�ȡ
	 * ���������byteȡֵ��Χ�ͻ����´�������
	 * 
	 * public static Integer valueOf(int i){
	 * 		assert IntegerCache.high >= 127;
	 * 		  if (i >= IntegerCache.low && i <= IntegerCache.high)			//i>= -128 && i <= 127
		            return IntegerCache.cache[i + (-IntegerCache.low)];
		        return new Integer(i);
	 * }
	 */
	public static void main(String[] args) {
		Integer i1=new Integer(97);
		Integer i2=new Integer(97);
		System.out.println(i1==i2);
		System.out.println(i1.equals(i2));
		System.out.println("----------");
		
		Integer i3 = new Integer(127);
		Integer i4=new Integer(127);
		System.out.println(i3==i4);
		System.out.println(i3.equals(i4));
		System.out.println("----------");
		
		Integer i5 = 127;
		Integer i6 = 127;
		System.out.println(i5==i6);
		System.out.println(i5.equals(i6));
		System.out.println("----------");
		
		Integer i7=128;
		Integer i8=128;
		System.out.println(i7==i8);
		System.out.println(i7.equals(i8));
		/**
		 * �𰸽��
		 * false
			true
			----------
			false
			true
			----------
			true
			true
			----------
			false
			true
		 */
	}
	
	
}
