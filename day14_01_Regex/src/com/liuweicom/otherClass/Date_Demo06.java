package com.liuweicom.otherClass;

import java.util.Date;

public class Date_Demo06 {
	/**
	 * Date��ĸ�������util���µģ����ܵ���sql����
	 *  
	 *  public Date();
	 *  public Date(long date);
	 *  
	 *  public long getTime();
	 *  public void setTime(lone time);
	 */
	public static void demo1(){
		
	}
	
	public static void demo2(){
			
	}
	
	public static void main(String[] args) {
		//���û�д�����������ǵ�ǰʱ��
		Date d = new Date();
		System.out.println(d);
		
		//������ŷ����в�����Ϊ0�������1970��1��1��
				//ͨ������ֵ����ʱ�����
		Date d1 = new Date(0);
		System.out.println(d1);
		
		System.out.println(d.getTime());
		System.out.println(System.currentTimeMillis());
		
		d1.setTime(1000);
		System.out.println(d1);
		
		
//		
//		Wed Mar 14 17:46:54 CST 2018
//		Thu Jan 01 08:00:00 CST 1970
//		1521020814950
//		1521020814970
//		Thu Jan 01 08:00:01 CST 1970

	}
}
