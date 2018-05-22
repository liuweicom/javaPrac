package com.weiwei.a_api;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestApi {
	public static void main(String[] args) {
		//创建数据源
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/day06");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		//创建模版
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		
		jdbcTemplate.update("insert into users(username,password) values(?,?);", "tom","998");
	}
}
