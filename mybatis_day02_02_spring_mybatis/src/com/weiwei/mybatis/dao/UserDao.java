package com.weiwei.mybatis.dao;

import java.util.List;

import com.weiwei.mybatis.pojo.User;


/**
 * 
 * <p>Title: UserDao</p>
 * <p>Description: dao鎺ュ彛锛岀敤鎴风鐞�/p>
 * <p>Company: www.itcast.com</p> 
 * @author	浼犳櫤.鐕曢潚
 * @date	2015-4-22涓嬪崍2:45:12
 * @version 1.0
 */
public interface UserDao {
	
	//鏍规嵁id鏌ヨ鐢ㄦ埛淇℃伅
	public User findUserById(int id) throws Exception;
	

}
