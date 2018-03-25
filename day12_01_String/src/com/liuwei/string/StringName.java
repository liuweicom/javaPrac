package com.liuwei.string;
import java.lang.*;

public class StringName {
	public static void main(String[] args) {
		
		/**
		 * 字符串字面量“abc”也可以看成是一个字符串的对象
		 * 字符串是常量，一旦被赋值，就不能改变：指的是字符串值不能改变，字符串直接复制的方法是先到字符串常量池中去找，如果有就直接返回，没有就创建并返回
		 * 
		 */
		String s1 = new String("abc");
		String s2 = "abc";
		System.out.println(s1==s2);//false  他们指向的地址不同，s1指向new String（），再由对象指向字符串常量池,s2指向字符串常量池
		System.out.println(s1.equals(s2));//true  内容相等
		//s1会创建两个对象，s2创建一个对象
	
		String s3="hello";
		String s4 = "world";
		String s5 = "helloworld";
		System.out.println(s5 == s3 + s4);//false 字符串如果是变量相加，先开空间，在拼接
		System.out.println(s5.equals(s1+s2));//true
		System.out.println(s5=="hello"+"world");//true字符串如果是常量相加，先相加然后再常量池中找，如果有就直接返回，否者创建
		System.out.println(s5.equals("hello"+"world"));//true
		
		
		
		
	}
}
