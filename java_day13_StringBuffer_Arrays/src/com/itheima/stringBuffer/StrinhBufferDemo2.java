package com.itheima.stringBuffer;

public class StrinhBufferDemo2 {
	/**
	 * StringBuffer��ӹ���
	 * public StringBuffer append(String str);
	 * 	���԰���������������ӵ��ַ������������棬�������ַ�������������
	 * public StringBuffer insert(int offset,String str);
	 * 	��ָ��λ�ð��������͵����ݲ��뵽�ַ������������棬�������ַ�������������
	 * StringBuffer���ַ�������������new��ʱ�����ڶ��ڴ洴��һ�����󣬵ײ���һ������Ϊ16���ַ������飬��������ӵķ���ʱ�����������´���
	 * ���󣬶�ʹ�ڲ�����ԭ����������ַ���
	 */
	public static void main(String[] args){
		StringBuffer sb=new StringBuffer("1234");
		sb.insert(3, "hello");
		System.out.println(sb);
		
		StringBuffer sb2=new StringBuffer("hello");
		StringBuffer sb3=sb2.append(true);
		StringBuffer sb4=sb3.append("word");
		StringBuffer sb5=sb4.append(100);
		System.out.println(sb2.toString());//?????
		System.out.println(sb3.toString());
		System.out.println(sb4.toString());
		System.out.println(sb5.toString());
	}
}
