package com.liuweicom.otherClass;

import java.math.BigDecimal;

/**
 * BigDecimal�ĸ���
 * �����������ʱ��float���ͺ�double�����׶�ʧ���ȣ���ʾ���� 
 * ���ԣ�Ϊ���ܹ���ȷ�ı�ʾ�����㸡������java�ṩ��BigDecimal
 * ���ɱ䣬���⾫�ȵ��з���10������
 * ���췽��
 * public BigDecimal(String val)
 * ��Ա����
 * public BigDecimal add(BigDecimal augend)
 * public BigDecimal subtract(BigDecimal subtrahend);
 * public BigCecimal multiply(BigDecimal multiplicand)
 * public BigDecimal divide(BigDecimal divisor)
 * 
 * 
 * ʮ���Ʊ�ʾ1/3
		0.3333333333333333333333333333333333333333 
 * @author ����
 *
 */
public class BigDecimal_Demo05 {
	public static void main(String[] args) {
		System.out.println(2.0-1.1);
		BigDecimal bl = new BigDecimal(2.0);//���ַ�ʽ�ڿ����в��Ƽ�,��Ϊ������ȷ
		BigDecimal b2 = new BigDecimal(1.1);
		
		System.out.println(bl.subtract(b2));
		System.out.println("-----------");
		BigDecimal bdl = new BigDecimal("2.0");//ͨ�������д����ַ����ķ�ʽ,����ʱ�Ƽ�
		BigDecimal bd2 = new BigDecimal("1.1");
		
		BigDecimal b11 = BigDecimal.valueOf(2.0);  //���ַ�ʽ�ڿ�����Ҳ���Ƽ���
		BigDecimal b22 = BigDecimal.valueOf(1.1);
		System.out.println(b11.subtract(b22));
		
//		0.8999999999999999
//		0.899999999999999911182158029987476766109466552734375
//		-----------
//		0.9
	}
}
