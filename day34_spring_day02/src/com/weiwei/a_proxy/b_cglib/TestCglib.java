package com.weiwei.a_proxy.b_cglib;

public class TestCglib {
	public static void main(String[] args) {
		UserServiceImpl userService = MyBeanFactory.createService();
		userService.addUser();
		userService.updateUser();
		userService.deleteUser();
		
//		ǰ
//		a_jdk_addUser
//		��
//		ǰ
//		a_jdk_updateUser
//		��
//		ǰ
//		a_jdk_deleteUser
//		��

	}
}
