package com.liuweicom.wrapClass;

public class IntegerDemo02 {
	/**
	 * JDK�����أ�
	 * �Զ�װ�䣺�ѻ�������ת��Ϊ��װ����
	 * �Զ����䣺�Ѱ�װ����ת���ɻ�������
	 * 
	 * ע�����
	 * ��ʹ��ʱ��Integer x = null;����ͻ�ʹ��NUllPointException
	 * �������ж��Ƿ�Ϊnull��Ȼ����ʹ��
	 */
	public static void main(String[] args) {
		int x=100;
		Integer y=new Integer(x);//�������������Ͱ�װ�ɶ���,װ��
		
		int z=y.intValue();//������ת��Ϊ������������,����
		
		Integer i2 = 100;//�Զ�װ��,�ѻ�����������ת���ɶ���
		int i3=i2+200;//�Զ�����,�Ѷ���ת��Ϊ������������
		System.out.println(i3);
		
//		Integer i4 = null;
//		int a = i4 + 100;						//�ײ���i3����intValue,����i3��null,null���÷����ͻ����
//		System.out.println(a);					//��ָ���쳣java.lang.NullPointerException
		
	}
}
