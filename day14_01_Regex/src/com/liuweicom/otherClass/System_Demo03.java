package com.liuweicom.otherClass;

public class System_Demo03 {
	/**
	 * System��ĸ���
	 * System�����һЩ���õ����ֶκͷ����������ܱ�ʵ����
	 * ��Ա������
	 * public static void gc()
	 * public static void exit(int status);
	 * public static void long currenTimeMillis()
	 * public static void arraycopy(Object src, int srcPos,Object dest,int destPos, int length)
	 * ��ʾ����
	 * Syetem ��ĳ�Ա����ʹ��
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
			System.gc();//�����������������൱�ڻ��ѻ��ջ���
		}
	}
	
	public static void demo02(){
		System.exit(1);                 //��0״̬���쳣��ֹ���Ƴ�jvm
		System.out.println("11111111");
	}
	
	public static void demo03(){
			long start = System.currentTimeMillis();       //1�����1000����
			for(int i=0;i<1000;i++){
				System.out.println("*");
			}
			long end = System.currentTimeMillis();
			System.out.println(end-start);
	}
	
	public static void demo04(){
		
	}
	
	
}

class Demo{//��һ��Դ�ļ��в�����������public���ε���
	@Override
	public void finalize(){
		System.out.println("������������");
	}
}
