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
	 * 冒泡排序：
	 * 1.返回值类型，void
	 * 2.参数列表，int[] arr
	 * 
	 * 第一次：arr[0]与arr[1],arr[1]-arr[2],arr[2]-arr[3],arr[3]-arr[4],比较4次
	 * 第二次：arr[0]与arr[1],arr[1]-arr[2],arr[2]-arr[3]比较3次
	 * 第三次：arr[0]与arr[1],arr[1]-arr[2]比较2次
	 * 第四次：arr[0]与arr[1]比较1次
	 */
	public static int[] bubleSort(int[] arr){
		if(arr.length<=1){
			return arr;
		}
		for(int i=0;i<arr.length-1;i++){							//外循环只需要比较arr.length次数就可以了
			for(int j=0;j<arr.length-i-1;j++){						////-1为了防止索引越界,-i为了提高效率
				if(arr[j]>arr[j+1]){
					swap(arr,j,j+1);
				}
			}
		}
		return arr;
	}
	
	
	/*
	 * 选择排序
	 * 1,返回值类型void
	 * 2,参数列表int[] arr
	 * 
	 * 	第一次:arr[0]分别与arr[1-4]比较,比较4次
		第二次:arr[1]分别与arr[2-4]比较,比较3次
		第三次:arr[2]分别与arr[3-4]比较,比较2次
		第四次:arr[3]与arr[4]比较,比较1次
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
