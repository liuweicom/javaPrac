package com.itheima.stringBuffer;

public class StrinhBufferDemo2 {
	/**
	 * StringBuffer添加功能
	 * public StringBuffer append(String str);
	 * 	可以把任意类型数据添加到字符串缓冲区里面，并返回字符串缓冲区本身
	 * public StringBuffer insert(int offset,String str);
	 * 	在指定位置把任意类型的数据插入到字符串缓冲区里面，并返回字符串缓冲区本身
	 * StringBuffer是字符串缓冲区，当new的时候是在堆内存创建一个对象，底层是一个长度为16的字符串数组，当调用添加的方法时，不会再重新创建
	 * 对象，而使在不断想原缓冲区添加字符串
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
