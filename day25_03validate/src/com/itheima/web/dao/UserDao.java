package com.itheima.web.dao;

import com.itheima.web.domain.User;

public interface UserDao {
	/**
	 * 更据用户名称查询用户
	 */
	User selectUserByUsername(String username);
	
	/**
	 * 保存用户信息
	 */
	int addUser(User user);
}
