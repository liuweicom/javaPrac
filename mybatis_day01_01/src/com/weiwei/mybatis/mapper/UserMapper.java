package com.weiwei.mybatis.mapper;

import java.util.List;

import com.weiwei.mybatis.pojo.User;
import com.weiwei.mybatis.pojo.UserCustomer;
import com.weiwei.mybatis.pojo.UserQueryVo;

public interface UserMapper {
	//用户信息综合查询
	public List<UserCustomer> findUserList(UserQueryVo UserQueryVo) throws Exception;
	//用户信息综合查询总数
	public int findUserCount(UserQueryVo userQueryVo) throws Exception;
	
	//根据id查询用户信息
	public User findUserById(int id) throws Exception;
	
	//根据id查询用户信息，使用resultMap输出
	public User findUserByIdResultMap(int id) throws Exception;
	
	//根据用户名列查询用户列表
	public List<User> findUserByName(String name) throws Exception;
	
	//插入用户
	public void insertUser(User user) throws Exception;
	
	//删除用户
	public void deleteUser(int id) throws Exception;
}
