package com.liuweicom.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * * A:������ʾ
 * ������һ��������������������?
 * ����:
 * 1,�������ַ����ͽ����ַ�������String���͵ı�����
 * 2,�������ڸ�ʽ������
 * 3,�������ַ���ת�������ڶ���
 * 4,ͨ�����ڶ������ʱ�����ֵ
 * 5,������ʱ�����ֵ�������1000,�ٳ���60,�ٳ���60,�ٳ���24�õ���
 * @throws ParseException 
 */
public class Test02 {
	public static void main(String[] args) throws Exception {
		//1,�������ַ����ͽ����ַ�������String���͵ı�����
		String d1="1994��08��08��";
		String d2="2018��03��15��";
		//2,�������ڸ�ʽ������
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��");
		//3,�������ַ���ת�������ڶ���
		Date d3 = sdf.parse(d1);
		Date d4 = sdf.parse(d2);
		//4,ͨ�����ڶ������ʱ�����ֵ
		long time = d4.getTime()-d3.getTime();
		//5,������ʱ�����ֵ�������1000,�ٳ���60,�ٳ���60,�ٳ���24�õ���
		System.out.println(time/(24*60*60*1000));
	}
}
