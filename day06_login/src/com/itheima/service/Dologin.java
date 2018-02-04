package com.itheima.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.itheima.entity.User;
import com.itheima.util.UtilJDBC;

/**
 * 更据用户名和密码查询用户对象信息
 * @author Administrator
 *
 */
public class Dologin {

	public User findUser(String name,String password){
		Connection con=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		User u=null;
		
		try {
			con=UtilJDBC.getConnection();
			stmt=con.prepareStatement("SELECT * FROM users WHERE username=? AND PASSWORD=?");
			stmt.setString(1,name);
			stmt.setString(2,password);
			rs=stmt.executeQuery();
			System.out.println(rs);
			if(rs.next()){
				u=new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setEmail(rs.getString("email"));
				u.setBirthday(rs.getDate("birthday"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			UtilJDBC.closeAll(rs,stmt,con);
		}
		return u;
	}
}
