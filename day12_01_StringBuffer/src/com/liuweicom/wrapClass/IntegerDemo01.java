package com.liuweicom.wrapClass;

public class IntegerDemo01 {
	/**
	 * Ϊʲô���л�����װ���װ��
	 * 	�������������ͷ�װ�ɶ���ĺô����ڿ����ڶ����ж������Ĺ��ܷ������������ݡ�
	 * ���ö���
	 * 	���õĲ���֮һ�����ڻ��������������ַ���֮���ת��
	 * �������ͺͰ�װ��Ķ�Ӧ
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
	 * Interger�����
	 * 		ͨ���ṩ��API
	 * Integer ���ڶ����а�װ��һ���������͵�int����
	 * �����ṩ�˶������������int���ͺ�String����֮��Ļ���ת��
	 * ���ṩ�˴���int����ʱ���ǳ����õ�����һЩ�����ͷ���
	 * 
	 * ���캯��
	 * public Integer(int value)
	 * public Integer(String s)
	 */
	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		
		Integer i1 = new Integer(100);
		System.out.println(i1);
		
		Integer i3 = new Integer("100");		//����ַ������Ǳ�ʾ���ֵ��ַ�����ת���лᱨ��java.lang.NumberFormatException
		System.out.println(i3);
		
		/**
		 * int------String
		 * 1.int+""����ƴ��
		 * 2��public static String valueOf(int i);
		 * 3.int ----Integer------String
		 * 		public static String toString(int i)(Integer�ľ�̬����)
		 */
		
		
		/**
		 * String---int
		 * 1.String----Integer-----int
		 * 		public static int parseInt(String s);
		 * �����������Ͱ������а��У������������ֶ���parse***�ķ��������Խ����������ֵ��ַ���������ʽת���ɻ�����������
		 */
		
		String s1="true";
		boolean b =Boolean.parseBoolean(s1);
		System.out.println(b);
		
		//char�İ�װ��û��Character��û��parseXXX�ķ���
		//�ַ������ַ���ת��ͨ��toCharArray()�Ϳ��԰��ַ���ת�����ַ�����
		int i = 100;
		String s2=i+"";
		String s3=Integer.toString(i);
		
		Integer i2 = new Integer(i);
		String s4 = i2.toString();
		
		//String --- int String ת��int
		String s="200";
		Integer i4 = new Integer(s);
		int i5 = i4.intValue();//��Integerת����int��
		
		int i6 = Integer.parseInt(s);
	}
	
}
