package com.itheima.web.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

//ʹ��JDBC����ʵ�ֲ�ѯ���ݿ����ݣ�����ʾ�ڿ���̨
public class demo1 {

	public static void main( String[] arg)throws Exception{
		//ע������
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		//��ȡ����Connection 
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/day06","root","root");
		//�õ�ִ��sequery���Ķ���Statement 
		Statement stmt=con.createStatement();
		//ִ��sql��䲢���ؽ�� 
		ResultSet rs=stmt.executeQuery("select * from users");
		//������
		while(rs.next()){
			System.out.println(rs.getObject("password"));
			System.out.println(rs.getObject("name"));
			System.out.println(rs.getObject("email"));
			System.out.println(rs.getObject("birthday"));
			System.out.println(rs.getObject("id"));
		}
		//�ر���Դ
		rs.close();
		stmt.close();
		con.close();
	}
}
