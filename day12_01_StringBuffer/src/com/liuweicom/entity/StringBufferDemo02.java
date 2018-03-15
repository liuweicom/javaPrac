package com.liuweicom.entity;

public class StringBufferDemo02 {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		System.out.println(sb.length());
		System.out.println(sb.capacity());
		
		StringBuffer sb2 = new StringBuffer(10);
		System.out.println(sb2.length());
		System.out.println(sb2.capacity());
		
		StringBuffer sb3 = new StringBuffer("hello");
		System.out.println(sb3.length());
		System.out.println(sb3.capacity());
		System.out.println("---------");
		sb3.insert(4, "world");
		System.out.println(sb3);//hellworldo
		System.out.println("-----------");
		StringBuffer sb4 = new StringBuffer();
		StringBuffer sb5 = sb4.append(true);
		StringBuffer sb6 = sb4.append("liuwei");
		StringBuffer sb7 = sb4.append(100);
		
		System.out.println(sb4);//trueliuwei100
		System.out.println(sb5);//trueliuwei100
		System.out.println(sb6);//trueliuwei100
		System.out.println(sb7);//trueliuwei100
		System.out.println("-------------------");
		sb4.deleteCharAt(12);
		sb4.delete(0, 2);
		System.out.println(sb4);
		sb4.delete(0, sb4.length());
		System.out.println(sb4);
		System.out.println("-----------");
		
		sb3.replace(0,2,"haha");
		System.out.println(sb3);
		sb3.reverse();
		System.out.println(sb3);
		
		System.out.println("----------");
		String str = sb3.substring(0, sb3.length());
		System.out.println(str);
		System.out.println("-----------");
		
		StringBuffer sb8 = new StringBuffer("hello");
		String s1=new String(sb8);
		System.out.println(s1);
		
		String s2 = sb8.toString();
		System.out.println(s2);
		
		String s3 = sb8.substring(0, sb8.length());
		System.out.println(s3);
		
		StringBuffer sb9 = new StringBuffer("hahhaha");
		System.out.println(sb9);
		
		StringBuffer sb10 = new StringBuffer();
		sb10.append("well");
		System.out.println(sb10);
		
		System.out.println("-----------");
		
//½á¹û		
//		0
//		16
//		0
//		10
//		5
//		21
//		---------
//		hellworldo
//		-----------
//		trueliuwei100
//		trueliuwei100
//		trueliuwei100
//		trueliuwei100
//		-------------------
//		ueliuwei10
//
//		-----------
//		hahallworldo
//		odlrowllahah
//		----------
//		odlrowllahah
//		-----------
//		hello
//		hello
//		hello
//		hahhaha
//		well
//		-----------
	}
}
