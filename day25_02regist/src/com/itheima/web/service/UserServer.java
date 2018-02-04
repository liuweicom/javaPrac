package com.itheima.web.service;

import com.itheima.web.domain.User;

public interface UserServer {
	User findUserByUsername(String username);
	
	int register(User user);
}
