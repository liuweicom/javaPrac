package com.ieheima.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class JDBCUtil {
	private static String driverClass;
	private static String url;
	private static String username;
	private static String password;
	
	static{
		ResourceBundle rb=ResourceBundle.getBundle("dbinfo");
		driverClass=rb.getString("driverClass");
		url=rb.getString("url");
		username=rb.getString("username");
		password=rb.getString("password");
		try{
			Class.forName(driverClass);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws Exception{
		return DriverManager.getConnection(url,username,password);
	}
	
	public static void closeAll(ResultSet rs,Statement stmt,Connection con){
		//¹Ø±Õ×ÊÔ´
		if(rs!=null){
			try {
				rs.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rs=null;
		}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			stmt=null;
		}
		if(con!=null){
			try {
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con=null;
		}
	}
}
