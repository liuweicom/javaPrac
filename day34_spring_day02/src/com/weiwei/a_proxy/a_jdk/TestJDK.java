package com.weiwei.a_proxy.a_jdk;

public class TestJDK {
	public static void main(String[] args) {
		UserService userService = MyBeanFactory.createService();
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
