package com.liuwei.string;
import java.lang.*;

public class StringName {
	public static void main(String[] args) {
		
		/**
		 * �ַ�����������abc��Ҳ���Կ�����һ���ַ����Ķ���
		 * �ַ����ǳ�����һ������ֵ���Ͳ��ܸı䣺ָ�����ַ���ֵ���ܸı䣬�ַ���ֱ�Ӹ��Ƶķ������ȵ��ַ�����������ȥ�ң�����о�ֱ�ӷ��أ�û�оʹ���������
		 * 
		 */
		String s1 = new String("abc");
		String s2 = "abc";
		System.out.println(s1==s2);//false  ����ָ��ĵ�ַ��ͬ��s1ָ��new String���������ɶ���ָ���ַ���������,s2ָ���ַ���������
		System.out.println(s1.equals(s2));//true  �������
		//s1�ᴴ����������s2����һ������
	
		String s3="hello";
		String s4 = "world";
		String s5 = "helloworld";
		System.out.println(s5 == s3 + s4);//false �ַ�������Ǳ�����ӣ��ȿ��ռ䣬��ƴ��
		System.out.println(s5.equals(s1+s2));//true
		System.out.println(s5=="hello"+"world");//true�ַ�������ǳ�����ӣ������Ȼ���ٳ��������ң�����о�ֱ�ӷ��أ����ߴ���
		System.out.println(s5.equals("hello"+"world"));//true
		
		
		
		
	}
}
