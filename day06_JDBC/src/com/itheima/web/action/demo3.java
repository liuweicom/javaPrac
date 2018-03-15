package com.itheima.web.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.itheima.web.entity.user;

public class demo3 {
	@Test
	//注：测试方法要求：不能有返回值，不能有参数
	public void testSelect() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/day06","root","root");
		
		Statement stmt=con.createStatement();
		
		ResultSet rs=stmt.executeQuery("select password,email,birthday,id,name from users");
		
		List<user> list=new ArrayList<user>();
		
		while(rs.next()){
			user u=new user();
			u.setId(rs.getInt("id"));
			u.setName(rs.getString("name"));
			u.setPassword(rs.getString("password"));
			u.setEmail(rs.getString("email"));
			u.setBirthday(rs.getDate("birthday"));
			list.add(u);
		}
		rs.close();
		stmt.close();
		con.close();
		
		for(user u:list){
			System.out.println(u);
		}
	}
	
	@Test
	public void testSelect1() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/day06","root","root");
		
		Statement stmt=con.createStatement();
		
		ResultSet rs=stmt.executeQuery("select password,email,birthday,id,name from users");
		
		List<user> list=new ArrayList<user>();
		
		rs.afterLast();
		rs.previous();
			user u=new user();
			u.setId(rs.getInt("id"));
			u.setName(rs.getString("name"));
			u.setPassword(rs.getString("password"));
			u.setEmail(rs.getString("email"));
			u.setBirthday(rs.getDate("birthday"));
			list.add(u);
		rs.close();
		stmt.close();
		con.close();
		
			System.out.println(u);
	}
	
	@Test
	public void testInsert() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/day06","root","root");
		
		Statement stmt=con.createStatement();
		
		int rs=stmt.executeUpdate("INSERT INTO users VALUES(4,'tom','123','tom@163.com','2015-08-10')");
		
		if(rs>0){
			System.out.println("添加成功");
		}
		
		stmt.close();
		con.close();
	}
	

	@Test
	public void testDelete() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/day06","root","root");
		
		Statement stmt=con.createStatement();
		
		int rs=stmt.executeUpdate("DELETE FROM users WHERE id=2");
		
		if(rs>0){
			System.out.println("success");
		}
		
		stmt.close();
		con.close();
	}
	

	@Test
	public void testUpdate() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/day06","root","root");
		
		Statement stmt=con.createStatement();
		
		int rs=stmt.executeUpdate("UPDATE users SET name='tom',password='333',email='jerry@163.com' WHERE id=3");
		
		
		if(rs>0){
			System.out.println("success alert"+rs+"line");
		}else{
			System.out.println("alert"+rs+"line");
		}
		
		stmt.close();
		con.close();
	}
}
