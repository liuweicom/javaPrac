package com.liuweicom.otherClass;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormat_Demo07 {
/**
 * DataFormat��ĸ���
 * DateFormat�����ڡ�ʱ���ʽ������ĳ����࣬�������������޹صķ�ʽ��ʽ�����������ڻ�ʱ�䣬
 * �ǳ����࣬����ʹ��������SimpleDataFormat
 * SimpleDateFormat���ŷ���
 * public SimpleDateFormat����
 * public SimpleDateFormat��String pattern��
 * 
 * ��Ա����
 * public final String format(Date Date);
 * public Date parse(String source)
 * ;
 * @throws Exception 
 */
	public static void main(String[] args) throws Exception {
		String str = "2000��08��08��  08:08:08";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��  HH:mm:ss");
		Date d = sdf.parse(str); //��ʱ���ַ���ת�������ڶ���
		System.out.println(d); //Tue Aug 08 08:08:08 CST 2000
		System.out.println("-----------");
		Date d1 = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy��MM��dd��  HH:mm:ss");
		SimpleDateFormat sdf2 = new SimpleDateFormat();
		String s = sdf1.format(d1);
		System.out.println(s);
		System.out.println(sdf2.format(d1));
//		2018��03��14��  18:28:28
//		18-3-14 ����6:28
		System.out.println("----------");
		//ʵ����
		//DateFormat�ǳ�����,������ʵ����
		
		DateFormat df1 = new SimpleDateFormat();
		//�൱�ڸ�������ָ���������,�ұߵķ�������һ���������
		DateFormat df2 = DateFormat.getDateInstance();
		
	}
}
