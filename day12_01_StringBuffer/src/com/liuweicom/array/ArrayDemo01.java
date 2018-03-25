package com.liuweicom.array;

import java.lang.reflect.Array;

public class ArrayDemo01 {
	public static void main(String[] args) {
		int[] arr={24, 69, 80, 57, 13};
//		int[] b =bubleSort(arr);
//		printSort(b);
		int[] c=selectSort(arr);
		printSort(c);
		
	}
	/**
	 * ð������
	 * 1.����ֵ���ͣ�void
	 * 2.�����б�int[] arr
	 * 
	 * ��һ�Σ�arr[0]��arr[1],arr[1]-arr[2],arr[2]-arr[3],arr[3]-arr[4],�Ƚ�4��
	 * �ڶ��Σ�arr[0]��arr[1],arr[1]-arr[2],arr[2]-arr[3]�Ƚ�3��
	 * �����Σ�arr[0]��arr[1],arr[1]-arr[2]�Ƚ�2��
	 * ���ĴΣ�arr[0]��arr[1]�Ƚ�1��
	 */
	public static int[] bubleSort(int[] arr){
		if(arr.length<=1){
			return arr;
		}
		for(int i=0;i<arr.length-1;i++){							//��ѭ��ֻ��Ҫ�Ƚ�arr.length�����Ϳ�����
			for(int j=0;j<arr.length-i-1;j++){						////-1Ϊ�˷�ֹ����Խ��,-iΪ�����Ч��
				if(arr[j]>arr[j+1]){
					swap(arr,j,j+1);
				}
			}
		}
		return arr;
	}
	
	
	/*
	 * ѡ������
	 * 1,����ֵ����void
	 * 2,�����б�int[] arr
	 * 
	 * 	��һ��:arr[0]�ֱ���arr[1-4]�Ƚ�,�Ƚ�4��
		�ڶ���:arr[1]�ֱ���arr[2-4]�Ƚ�,�Ƚ�3��
		������:arr[2]�ֱ���arr[3-4]�Ƚ�,�Ƚ�2��
		���Ĵ�:arr[3]��arr[4]�Ƚ�,�Ƚ�1��
	 */
	public static int[] selectSort(int[] arr){
			for(int i=0;i<arr.length-1;i++){
				for(int j=i+1;j<arr.length;j++){
					if(arr[i]<arr[j]){
						swap(arr,i,j);
					}
				}
			}
		return arr;
	}
	
	public static void swap(int[] arr,int a,int b){
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	};
	
	public static void printSort(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]);
		}
	} 
}
