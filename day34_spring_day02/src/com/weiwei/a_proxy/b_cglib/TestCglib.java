package com.weiwei.a_proxy.b_cglib;

public class TestCglib {
	public static void main(String[] args) {
		UserServiceImpl userService = MyBeanFactory.createService();
		userService.addUser();
		userService.updateUser();
		userService.deleteUser();
		
//		前
//		a_jdk_addUser
//		后
//		前
//		a_jdk_updateUser
//		后
//		前
//		a_jdk_deleteUser
//		后

	}
}
