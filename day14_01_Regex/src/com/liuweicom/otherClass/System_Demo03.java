package com.liuweicom.otherClass;

public class System_Demo03 {
	/**
	 * System类的概述
	 * System类包含一些有用的类字段和方法，他不能被实例化
	 * 成员方法：
	 * public static void gc()
	 * public static void exit(int status);
	 * public static void long currenTimeMillis()
	 * public static void arraycopy(Object src, int srcPos,Object dest,int destPos, int length)
	 * 演示案例
	 * Syetem 类的成员方法使用
	 */
	
	public static void main(String[] args) {
		
//		demo01();
//		demo02();
		demo03();//10
		System.out.println("-------------");
		int[] src={11,22,33,44,55};
		int[] dest = new int[8];
		for(int i =0;i<dest.length;i++){
			System.out.println(dest[i]);
//			0
//			0
//			0
//			0
//			0
//			0
//			0
//			0
		}
		
		System.out.println("-------------------");
		System.arraycopy(src, 0, dest, 0, src.length);
		for(int i =0;i<dest.length;i++){
			System.out.println(dest[i]);
//			11
//			22
//			33
//			44
//			55
//			0
//			0
//			0
		}
	}
	
	public static void demo01(){
		for(int i=0;i<10;i++){
			new Demo();
			System.gc();//运行垃圾回收器，相当于唤醒回收机制
		}
	}
	
	public static void demo02(){
		System.exit(1);                 //非0状态是异常终止，推出jvm
		System.out.println("11111111");
	}
	
	public static void demo03(){
			long start = System.currentTimeMillis();       //1秒等于1000毫秒
			for(int i=0;i<1000;i++){
				System.out.println("*");
			}
			long end = System.currentTimeMillis();
			System.out.println(end-start);
	}
	
	public static void demo04(){
		
	}
	
	
}

class Demo{//在一个源文件中不允许定义两个public修饰的类
	@Override
	public void finalize(){
		System.out.println("垃圾被清理了");
	}
}
