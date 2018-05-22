package com.weiwei.a_api;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestApi {
	public static void main(String[] args) {
		//��������Դ
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/day06");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		//����ģ��
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		
		jdbcTemplate.update("insert into users(username,password) values(?,?);", "tom","998");
	}
}
