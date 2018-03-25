package com.itheima.web.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

//使用JDBC技术实现查询数据库数据，并显示在控制台
public class demo1 {

	public static void main( String[] arg)throws Exception{
		//注册驱动
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		//获取连接Connection 
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/day06","root","root");
		//得到执行sequery语句的对象Statement 
		Statement stmt=con.createStatement();
		//执行sql语句并返回结果 
		ResultSet rs=stmt.executeQuery("select * from users");
		//处理结果
		while(rs.next()){
			System.out.println(rs.getObject("password"));
			System.out.println(rs.getObject("name"));
			System.out.println(rs.getObject("email"));
			System.out.println(rs.getObject("birthday"));
			System.out.println(rs.getObject("id"));
		}
		//关闭资源
		rs.close();
		stmt.close();
		con.close();
	}
}
