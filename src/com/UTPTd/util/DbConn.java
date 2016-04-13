package com.UTPTd.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbConn {
	private static String driverName = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localhost:1521:TestOrcl";
	private static String user = "system";
	private static String password = "Xyz7902335";
	
	static{
		try {
			Class.forName(driverName);
		} catch (Exception e) {
			System.out.println("驱动加载失败");
		}
	}
	public static Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			System.out.println("数据库连接失败");
		}
		return conn;
	}
	public static void main(String[] args) {
		try {
			if(getConnection() != null) {
				System.out.println("不为空！");
			}
		} catch (Exception e) {
			System.out.println("还是空！");
		}
		
	}
	public static void release(ResultSet rs, PreparedStatement pst, Connection conn) {
		if(rs != null) 
			try {
				rs.close();
			} catch (Exception e) {
				System.out.println("ResultSet释放失败！！");
			}
		if(pst != null)
			try {
				pst.close();
			} catch (Exception e) {
				System.out.println("PrepareStatement释放失败！");
			}
		if(conn != null)
			try {
				conn.close();
			} catch (Exception e) {
				System.out.println("Connection释放失败！");
			}
			
	}
}
