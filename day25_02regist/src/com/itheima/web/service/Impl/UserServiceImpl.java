package com.itheima.web.service.Impl;

import com.itheima.web.dao.UserDao;
import com.itheima.web.dao.Impl.UserDaoImpl;
import com.itheima.web.domain.User;
import com.itheima.web.service.UserServer;

public class UserServiceImpl implements UserServer {
	private UserDao dao=new UserDaoImpl();
	
	@Override
	public User findUserByUsername(String username) {
		// TODO Auto-generated method stub
		System.out.println("aa");
		return dao.selectUserByUsername(username);
	}

	@Override
	public int register(User user) {
		// TODO Auto-generated method stub
		return dao.addUser(user);
	}
	
}
