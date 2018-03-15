package com.liuwei.string;

public class StringDemo1 {
	public static void main(String[] args) {
		/**
		 * 构造方法：
		 * public String();
		 * public String(byte[] bytes);把字符串数组转成字符串
		 * public String(byte[] byte, int index,int length);把字节数组的一部分转成字符串
		 * public String(char[] valu);
		 * public String(char[] value,int index,int count);
		 * public String(String original);
		 */
		
		
		/**
		 * String 方法中判断功能
		 * boolean equals(Object obj);比较字符串的内容是否相同，区分大小写
		 * boolean equalsIgnoreCase(String str);忽略大小写
		 * boolean contains(String str);判断大串中包含小窜
		 * boolean startsWith(String str)判断字符串是否以某种指定的字符串开头
		 * boolean endsWith(String str);是否以某种字符串结尾
		 * boolean isEmpty();
		 */
		
		
		/*
		 * byte[] getByte();//把字符串转换成字节的数组
		 * char[] toharArray();把字符串数组，转换成字符数组
		 * static string valueOf(char[] chs);把字符数组转成字符串
		 * static string valueOf(int i);把整数类型的数据转换成字符串
		 * String toLowerCase();把字符串转小写
		 * String toUpperCase();把字符串转大写
		 * String类的valueOf方法，可以把任意类型的数据转成字符串
		 * String concat（String str）;把字符串拼接起来
		 */
		
		
		/**
		 * String类的其他功能：
		 * String replace(char old, char new);替换，将old替换成new字符
		 * String replace(String old,String new );将新的字符串，提花旧的字符
		 * 
		 * String trim();、、字符前后的空格去掉
		 * 
		 * int s1.compareTo(String str);与str的比较，=0；相等，》0，s1>str;<o s1<str;如果str为s1的一部分，则返回的是s1.length-str.length
		 * int compareToIgnoreCase(String str);忽略大小写
		 * 
		 * int length();
		 * char charAt(int index);index位置的字符
		 * int indexOf(char ch);字符ch在字符串中首次的位置，没有则为-1
		 * int indexOf(String str);字符串-----
		 * 
		 * int indexOf(char ch,int fromIndex);从fromIndex位置之后查询，ch字符
		 * int indexOf(String str,int fromIndex);
		 * 
		 * String subString(int start);截取位置，从start位置开始
		 * 
		 * String subString(int start,int end);截取位置，从start位置开始，从end结束，不包括end位置
		 */
	}
}
