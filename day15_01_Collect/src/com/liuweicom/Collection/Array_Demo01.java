package com.liuweicom.Collection;

import com.liuweicom.bean.Student;

public class Array_Demo01 {
	/**
	 * * A:������ʾ
			* ��������5��ѧ����������5��ѧ������Ϣ�洢�������У����������飬��ȡ�õ�ÿһ��ѧ����Ϣ��
		* 
				Student[] arr = new Student[5];					//�洢ѧ������
				arr[0] = new Student("����", 23);
				arr[1] = new Student("����", 24);
				arr[2] = new Student("����", 25);
				arr[3] = new Student("����", 26);
				arr[4] = new Student("���", 20);
				
				for (int i = 0; i < arr.length; i++) {
					System.out.println(arr[i]);
				}
				
		* B:��ͼ��ʾ
			* ��ѧ������İ�����ͼ����
			* ����ͼ��ϴ洢������������,��Ķ��ǵ�ֵַ
	 */
	
	public static void main(String[] args) {
		int[] arr = new int[5];         //��������������������
		Student[] arr2 = new Student[5];   //��������������������
		arr2[0] = new Student("����",23);
		arr2[1] = new Student("123��",25);
		arr2[2] = new Student("��456��",24);
		arr2[3] = new Student("����789",26);
		arr2[4] = new Student("����aaaa",27);
		
		
		 for(int i =0; i<arr2.length;i++){
			 System.out.println(arr2[i]);
		 }
	}
}
