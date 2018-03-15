package com.liuweicom.otherClass;

import java.util.Calendar;

/**
 * Calender ��ĸ���
 * Calender����һ�������࣬��Ϊ�ض�˲����һ������YEAR��MONTH,DAY_OF_MONTH,HOUR�������ֶ�֮���ת���ṩ��һЩ�ֶΣ���δ���������ֶΣ��ṩ��һЩ����
 * public static Calendar getInstance()
 * public int get(int field);
 * 
 *  public final void set(int year, int month, int date)
 *  public void add(int field,int amount)
 * @author ����
 *
 */
public class Calender_Demo08 {

	public static void demo1(){
		Calendar c =Calendar.getInstance(); 
		System.out.println(c.get(Calendar.YEAR));
		System.out.println(c.get(Calendar.MONTH));//��0��ʼ
		System.out.println(c.get(Calendar.DAY_OF_MONTH));//һ���µĵڼ���
		System.out.println(c.get(Calendar.DAY_OF_WEEK));//�����ǵ�һ�죬���������һ��
		//2018
//		2
//		14
//		4����
		
	}
	public static void main(String[] args) {
//		demo1();
		Calendar c = Calendar.getInstance();//��������ָ���������
		c.add(Calendar.YEAR, -1);//��ָ�����ֶν�����ǰ��������
		c.set(Calendar.YEAR, 2000);
		c.set(2001,7,8);
		System.out.println(c.get(Calendar.YEAR)+"��"+getNum(c.get(Calendar.MONTH))+"��"+getNum(c.get(Calendar.DAY_OF_MONTH))+"��"+getWeek(c.get(Calendar.DAY_OF_WEEK)));
		
	}
	
	public static String getWeek(int week){
		String[] arr ={"","������","����һ","���ڶ�","������","������","������","������"};
		return arr[week];
	}
	
	public static String getNum(int num){
		if(num>9){
			return ""+num;
		}
		return "0"+num;
		
		
	}
}
