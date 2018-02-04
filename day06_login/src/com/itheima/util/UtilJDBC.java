package com.itheima.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class UtilJDBC {

	private static String driverClass;
	private static String url;
	private static String user;
	private static String password;
	
	static{
		ResourceBundle rb=ResourceBundle.getBundle("dbinfo");
		driverClass=rb.getString("driverClass");
		url=rb.getString("url");
		user=rb.getString("user");
		password=rb.getString("password");
		
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection () throws SQLException{
		return DriverManager.getConnection(url,user,password);
	}
	
	public static void closeAll(ResultSet rs,Statement stmt,Connection con){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rs=null;
		}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			stmt=null;
		}
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con=null;
		}
	}
}
