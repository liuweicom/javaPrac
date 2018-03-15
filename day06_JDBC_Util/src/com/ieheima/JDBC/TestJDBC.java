package com.ieheima.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestJDBC {
	@Test
	public void testSelect(){
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			con=JDBCUtil.getConnection();
			stmt=con.createStatement();
			rs=stmt.executeQuery("select * from users");
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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(rs, stmt, con);
		}
		
	}
	
	@Test
	public void testInsert(){
		Connection con=null;
		PreparedStatement stmt=null;
		
		try {
			con=JDBCUtil.getConnection();
			stmt=con.prepareStatement("INSERT INTO users VALUES(?,?,?,?,?)");
			stmt.setInt(1,2);
			stmt.setString(2,"timy");
			stmt.setString(3,"123456");
			stmt.setString(4,"timy@163.com");
			stmt.setString(5,"2017-12-19");
			
			int i=stmt.executeUpdate();
			if(i>0){
				System.out.println("success");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(null, stmt, con);
		}
		
	}
	
	
	@Test
	public void testUpdate(){
		Connection con=null;
		PreparedStatement stmt=null;
		
		try {
			con=JDBCUtil.getConnection();
			stmt=con.prepareStatement("UPDATE users SET name=?,password=?,email=?,birthday=? WHERE id=?");
			
			stmt.setString(1,"grace");
			stmt.setString(2,"123456");
			stmt.setString(3,"grace@163.com");
			stmt.setString(4,"2017-12-19");
			stmt.setInt(5,1);
			int i=stmt.executeUpdate();
			if(i>0){
				System.out.println("success");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(null, stmt, con);
		}
		
	}
	
	@Test
	public void testDelete(){
		Connection con=null;
		Statement stmt=null;
		
		try {
			con=JDBCUtil.getConnection();
			stmt=con.createStatement();
			int i=stmt.executeUpdate("DELETE FROM users WHERE id=4");
			if(i>0){
				System.out.println("success");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(null, stmt, con);
		}
		
	}
}
