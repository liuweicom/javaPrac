package com.liuweicom.test;

public class TestDemo01 {
	public static void main(String[] args) {
		int[] arr = {1,2,3};
		System.out.println(arrayToString(arr));
	}
	/**
	 * * 需求：把数组中的数据按照指定个格式拼接成一个字符串
	* 
			举例：
				int[] arr = {1,2,3};	
			输出结果：
				"[1, 2, 3]"
				
			用StringBuffer的功能实现
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
