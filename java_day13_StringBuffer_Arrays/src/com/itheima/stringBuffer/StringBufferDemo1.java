package com.itheima.stringBuffer;

public class StringBufferDemo1 {
	/**
	 * A:StringBuffer的构造方法
	 * 	public StringBuffer():无参数构造方法
	 * 	public StringBuffer(int capacity):指定容量的字符串缓冲区对象
	 * 	public StringBuffer(String str);指定字符串内容的字符串缓冲区对象
	 * 
	 * B:StringBuffer()
	 * 		public int capacity()返回当前容量，理论值
	 * 		public int length()返回长度，实际值
	 */
	public static void main(String[] args){
		StringBuffer sb=new StringBuffer();
		System.out.println(sb.capacity());//容器中的初始化容量，理论值----16
		System.out.println(sb.length());//容器中肥肉字符串个数，实际值--0
		
		StringBuffer sb2=new StringBuffer(10);
		System.out.println(sb2.capacity());//--10
		System.out.println(sb2.length());//--0
		
		StringBuffer sb3=new StringBuffer("StringBuffer");
		System.out.println(sb3.length());//实际字符的个数---12
		System.out.println(sb3.capacity());//字符串的length+初始容量----28
	}
}
