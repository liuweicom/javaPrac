package com.liuweicom.otherClass;

import java.math.BigDecimal;

/**
 * BigDecimal的概述
 * 由于在运算的时候，float类型和double很容易丢失精度，演示按例 
 * 所以，为了能够精确的表示，计算浮点数，java提供了BigDecimal
 * 不可变，任意精度的有符号10进制数
 * 构造方法
 * public BigDecimal(String val)
 * 成员方法
 * public BigDecimal add(BigDecimal augend)
 * public BigDecimal subtract(BigDecimal subtrahend);
 * public BigCecimal multiply(BigDecimal multiplicand)
 * public BigDecimal divide(BigDecimal divisor)
 * 
 * 
 * 十进制表示1/3
		0.3333333333333333333333333333333333333333 
 * @author 工号
 *
 */
public class BigDecimal_Demo05 {
	public static void main(String[] args) {
		System.out.println(2.0-1.1);
		BigDecimal bl = new BigDecimal(2.0);//这种方式在开发中不推荐,因为不够精确
		BigDecimal b2 = new BigDecimal(1.1);
		
		System.out.println(bl.subtract(b2));
		System.out.println("-----------");
		BigDecimal bdl = new BigDecimal("2.0");//通过构造中传入字符串的方式,开发时推荐
		BigDecimal bd2 = new BigDecimal("1.1");
		
		BigDecimal b11 = BigDecimal.valueOf(2.0);  //这种方式在开发中也是推荐的
		BigDecimal b22 = BigDecimal.valueOf(1.1);
		System.out.println(b11.subtract(b22));
		
//		0.8999999999999999
//		0.899999999999999911182158029987476766109466552734375
//		-----------
//		0.9
	}
}
