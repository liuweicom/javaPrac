package com.itheima.dao;

import java.util.List;

import com.itheima.domain.User;

public interface IUserDao {
	/**
	 * 更据用户的登录名和密码查询用户
	 * @param logonName
	 * @param logonPwd
	 * @return
	 */
	User selectUserByInfo(String logonName, String logonPwd);
	/**
	 * 添加用户
	 */
	int addUser(User user);
	/**
	 * 更新用户信息
	 */
	int updateUser(User user);
	/**
	 * 更据用户id，删除用户信息
	 */
	int deleteUser(Integer userID);
	/**
	 * 更据用户id，删除用户信息
	 */
	User selectUserById(Integer userID);
	/**
	 * 查询所有用户信息
	 * 
	 */
	List<User> selectAllUser();
	/**
	 * 更据指定条件获取用户信息
	 */
	List<User> selectUserByCondition(String userName,String gender,String education,String isUpload);
	
}
