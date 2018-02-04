package com.itheima.service;

import java.util.List;

import com.itheima.domain.User;

public interface UserService {
	/**
	 * 用户登录
	 */
	User login(String logoName,String logonPwd);
	
	/**
	 * 保存用户
	 */
	int saveUser(User user);
	/**
	 * 修改用户
	 */
	int modifyUser(User user);
	/**
	 * 根据用户id，删除用户
	 * @param userID
	 * @return
	 */
	int removeUser(Integer userID);
	/**
	 * 根据用户id，获取用户信息
	 * @param userID
	 * @return
	 */
	User findUserById(Integer userID);
	/**
	 * 查询所有用户
	 * @return
	 */
	List<User> findAllUser();
	/**
	 * 根据条件查询用户信息
	 * @param userName
	 * @param gender
	 * @param education
	 * @param isUpload
	 * @return
	 */
	List<User> findUserByCondition(String userName,String gender,String education,String isupload);
}
