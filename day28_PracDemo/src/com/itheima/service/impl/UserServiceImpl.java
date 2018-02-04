package com.itheima.service.impl;

import java.util.List;

import com.itheima.dao.IUserDao;
import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.domain.User;
import com.itheima.service.UserService;

public class UserServiceImpl implements UserService{
	private IUserDao dao=new UserDaoImpl();
	@Override
	public User login(String logoName, String logonPwd) {
		// TODO Auto-generated method stub
		return dao.selectUserByInfo(logoName, logonPwd);
	}

	@Override
	public int saveUser(User user) {
		// TODO Auto-generated method stub
		return dao.addUser(user);
	}

	@Override
	public int modifyUser(User user) {
		// TODO Auto-generated method stub
		return dao.updateUser(user);
	}

	@Override
	public int removeUser(Integer userID) {
		// TODO Auto-generated method stub
		return dao.deleteUser(userID);
	}

	@Override
	public User findUserById(Integer userID) {
		// TODO Auto-generated method stub
		return dao.selectUserById(userID);
	}

	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return dao.selectAllUser();
	}

	@Override
	public List<User> findUserByCondition(String userName, String gender,
			String education, String isupload) {
		// TODO Auto-generated method stub
		return dao.selectUserByCondition(userName, gender, education, isupload);
	}
}
