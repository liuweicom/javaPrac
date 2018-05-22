package com.weiwei.bonc;

import org.junit.Test;

public class testMavenSecond {
	@Test
	public void testMaven(){
		mavenSecond test01 = new mavenSecond();
		String str = test01.sayHello("dabao");
		System.out.println(str);
	}
}
