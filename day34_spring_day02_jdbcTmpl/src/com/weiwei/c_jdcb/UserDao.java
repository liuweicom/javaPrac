package com.weiwei.c_jdcb;

import org.springframework.jdbc.core.JdbcTemplate;

import com.weiwei.domain.User;

public class UserDao {
	private JdbcTemplate jdbcTemplate;
	public void update(User user){
		String sql ="update users set username=?,password=? where id=?";
		Object[] args = {user.getUsername(),user.getPassword(),user.getId()};
		jdbcTemplate.update(sql,args);
	}
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
