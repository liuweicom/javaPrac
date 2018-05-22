package com.weiwei.mybatis.mapper;

import java.util.List;

import com.weiwei.mybatis.pojo.User;
import com.weiwei.mybatis.pojo.UserCustomer;
import com.weiwei.mybatis.pojo.UserQueryVo;

public interface UserMapper {
	//根据id查询用户信息
	public User findUserById(int id) throws Exception;
}
