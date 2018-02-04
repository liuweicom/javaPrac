package com.itheima.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import org.junit.Test;



public class demo {
	
	@Test
	public void test1 () throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/day06","root","root");
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from users");
		
		while(rs.next()){
			System.out.println(rs.getObject(1));
		}
		rs.close();
		stmt.close();
		con.close();
	}
	
	@Test
	public void test2 () throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Properties info=new Properties();
		info.setProperty("user", "root");
		info.setProperty("password", "root");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/day06", info);
//		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/day06","root","root");
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from users");
		
		while(rs.next()){
			System.out.println(rs.getObject(1));
		}
		rs.close();
		stmt.close();
		con.close();
	}
	
	@Test
	public void test3 () throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/day06?user=root&password=root");
//		Properties info=new Properties();
//		info.setProperty("user", "root");
//		info.setProperty("password", "root");
//		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/day06", info);
		
//		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/day06","root","root");
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from users");
		
		while(rs.next()){
			System.out.println(rs.getObject(1));
		}
		rs.close();
		stmt.close();
		con.close();
	}
	
	@Test
	public void test4 () throws Exception{
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/day06?user=root&password=root");
//			Properties info=new Properties();
//			info.setProperty("user", "root");
//			info.setProperty("password", "root");
//			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/day06", info);
			
//			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/day06","root","root");
			stmt=con.createStatement();
			rs=stmt.executeQuery("select * from users");
			
			while(rs.next()){
				System.out.println(rs.getObject(1));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(rs!=null){
				try{
					rs.close();
				}catch(Exception e){
					e.printStackTrace();
				}
				rs=null;
			}
			if(stmt!=null){
				try{
					stmt.close();
				}catch(Exception e){
					e.printStackTrace();
				}
				stmt=null;
			}
			if(con!=null){
				try{
					con.close();
				}catch(Exception e){
					e.printStackTrace();
				}
				con=null;
			}
		}
	}
}
