package com.liuweicom.test;

public class TestDemo01 {
	public static void main(String[] args) {
		int[] arr = {1,2,3};
		System.out.println(arrayToString(arr));
	}
	/**
	 * * ���󣺰������е����ݰ���ָ������ʽƴ�ӳ�һ���ַ���
	* 
			������
				int[] arr = {1,2,3};	
			��������
				"[1, 2, 3]"
				
			��StringBuffer�Ĺ���ʵ��
	 */
	
	public static String arrayToString(int[] arr){
		StringBuffer sb=new StringBuffer();
		if(arr.length == 0){
			sb.append("[]");
		}
		sb.append("[");
		for(int i=0;i<arr.length;i++){
			if(i == arr.length - 1){
				sb.append(arr[i]).append("]");
			}else{
				sb.append(arr[i]).append(", ");
			}
		}
		return sb.toString();
	}
}
