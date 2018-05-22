package com.weiwei.d_aspectj;

public class UserServiceImpl implements UserService {

	@Override
	public void addUser() {
		// TODO Auto-generated method stub
		System.out.println("a_aspectj_addUser");
	}

	@Override
	public String updateUser() {
		// TODO Auto-generated method stub
		
		System.out.println("a_aspectj_updateUser");
//		int i = 1/ 0;
		return "hahha";
	}

	@Override
	public void deleteUser() {
		// TODO Auto-generated method stub
		System.out.println("a_aspectj_deleteUser");
	}

}
