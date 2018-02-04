package com.itheima.Util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class JNDIUtil {
	private static DataSource ds;
	static{
		try {
			Context initCtx = new InitialContext();
			ds=(DataSource) initCtx.lookup("java:comp/env/jdbc/day25");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			throw new ExceptionInInitializerError("初始化链接失败");
		}
		
	}
	
	public static DataSource getDataSource(){
		return ds;
	}
	
	public static Connection getConnection(){
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
}
