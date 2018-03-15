package com.liuweicom.wrapClass;

public class IntegerDemo02 {
	/**
	 * JDK的新特：
	 * 自动装箱：把基本类型转换为包装类型
	 * 自动拆箱：把包装类型转换成基本类型
	 * 
	 * 注意事项：
	 * 在使用时，Integer x = null;代码就会使用NUllPointException
	 * 建议先判断是否为null，然后再使用
	 */
	public static void main(String[] args) {
		int x=100;
		Integer y=new Integer(x);//将基本数据类型包装成对象,装箱
		
		int z=y.intValue();//将对象转换为基本数据类型,拆箱
		
		Integer i2 = 100;//自动装箱,把基本数据类型转换成对象
		int i3=i2+200;//自动拆箱,把对象转换为基本数据类型
		System.out.println(i3);
		
//		Integer i4 = null;
//		int a = i4 + 100;						//底层用i3调用intValue,但是i3是null,null调用方法就会出现
//		System.out.println(a);					//空指针异常java.lang.NullPointerException
		
	}
}
