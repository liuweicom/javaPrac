package com.weiwei.a_proxy.a_jdk;

public class TestJDK {
	public static void main(String[] args) {
		UserService userService = MyBeanFactory.createService();
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
