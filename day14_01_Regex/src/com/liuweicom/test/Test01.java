package com.liuweicom.test;

import java.util.Arrays;


/**
 * @param args
 * * A:������ʾ
 * ������������һ���ַ���:��91 27 46 38 50������д����ʵ�������������ǣ���27 38 46 50 91��
 * 100
 * 80
 * ����:
 * 1,���ַ����и���ַ�������
 * 2,���ַ���ת�������ֲ�����洢��һ���ȳ��ȵ�int������
 * 3,����
 * 4,�������Ľ��������ƴ�ӳ�һ���ַ���
 */
public class Test01 {
	public static void main(String[] args) {
		String s = "91 27 46 38 50";
		String[] str = s.split(" ");
		int[] arr = new int[str.length];
		for(int i=0;i<arr.length;i++){
			arr[i]=Integer.parseInt(str[i]);
		}
		Arrays.sort(arr);
		
//		String str2 = "";
//		for(int i=0;i<arr.length;i++){
//			if(i==arr.length-1){
//				str2 = str2 + arr[i];
//			}else{
//				str2 = str2+arr[i]+" ";
//			}
//		}
//		System.out.println(str2);
		
		StringBuilder sb =new StringBuilder();
		for(int i=0;i<arr.length;i++){
			if(i == arr.length -1){
				sb.append(arr[i]);
			}else{
				sb.append(arr[i]+" ");
			}
		}
		System.out.println(sb);
	}
}
