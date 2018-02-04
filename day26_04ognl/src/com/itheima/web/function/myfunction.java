package com.itheima.web.function;

/**
 * EL表达式的自定义方法：
 * 1.编写一个普通的类，提供一个实现功能的静态方法
 * 2.在web_INF目录下，创建一个拓展名为。tld的xml文件，不能放在classes和lib目录下
 * 3.在jsp页面中，使用tablib指令引入外部的标签库、方法库
 * EL表达式只能支持静态方法调用
 * @author Administrator
 *
 */
public class myfunction {
	public static String toUppercase(String str){
		return str.toUpperCase();
	}
}
