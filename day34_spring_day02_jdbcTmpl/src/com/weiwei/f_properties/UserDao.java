package com.weiwei.f_properties;

import java.util.List;

import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.weiwei.domain.User;

public class UserDao extends JdbcDaoSupport{
	public void update(User user){
		String sql ="update users set username=?,password=? where id=?";
		Object[] args = {user.getUsername(),user.getPassword(),user.getId()};
		this.getJdbcTemplate().update(sql,args);
	}
	
	public List<User> findAll(){
		return this.getJdbcTemplate().query("select * from users",ParameterizedBeanPropertyRowMapper.newInstance(User.class) );
	}
	
	public User getById(int id){
		return (User) this.getJdbcTemplate().query("select * from users where id=?", ParameterizedBeanPropertyRowMapper.newInstance(User.class),id);
	}
}
