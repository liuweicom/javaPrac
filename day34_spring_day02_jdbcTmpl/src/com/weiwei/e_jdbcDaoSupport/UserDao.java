package com.weiwei.e_jdbcDaoSupport;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.weiwei.domain.User;

public class UserDao extends JdbcDaoSupport{
	public void update(User user){
		String sql ="update users set username=?,password=? where id=?";
		Object[] args = {user.getUsername(),user.getPassword(),user.getId()};
		this.getJdbcTemplate().update(sql,args);
	}
	
}
