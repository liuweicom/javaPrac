package com.itheima.stringBuffer;

public class StringBufferDemo1 {
	/**
	 * A:StringBuffer�Ĺ��췽��
	 * 	public StringBuffer():�޲������췽��
	 * 	public StringBuffer(int capacity):ָ���������ַ�������������
	 * 	public StringBuffer(String str);ָ���ַ������ݵ��ַ�������������
	 * 
	 * B:StringBuffer()
	 * 		public int capacity()���ص�ǰ����������ֵ
	 * 		public int length()���س��ȣ�ʵ��ֵ
	 */
	public static void main(String[] args){
		StringBuffer sb=new StringBuffer();
		System.out.println(sb.capacity());//�����еĳ�ʼ������������ֵ----16
		System.out.println(sb.length());//�����з����ַ���������ʵ��ֵ--0
		
		StringBuffer sb2=new StringBuffer(10);
		System.out.println(sb2.capacity());//--10
		System.out.println(sb2.length());//--0
		
		StringBuffer sb3=new StringBuffer("StringBuffer");
		System.out.println(sb3.length());//ʵ���ַ��ĸ���---12
		System.out.println(sb3.capacity());//�ַ�����length+��ʼ����----28
	}
}
