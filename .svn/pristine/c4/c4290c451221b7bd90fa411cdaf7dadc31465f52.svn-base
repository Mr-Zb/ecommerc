package com.fun.mysqldb.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
/**
 * 工具类，得到连接，关闭连接
 * @author jmcfeng
 *
 */
public class JDBCUtils {
	private static String DRIVER;
	private static String URL;
	private static String USERNAME;
	private static String PASSWORD;
	//设置参数
	static{
		Properties prop = new Properties();
//		try {
//			prop.load(JDBCUtils.class.getClassLoader()
//					.getResourceAsStream("cloud.properties"));
//			DRIVER = prop.getProperty("db.driver");
//			URL = prop.getProperty("db.url");
//			USERNAME = prop.getProperty("db.username");
//			PASSWORD = prop.getProperty("db.password");
			DRIVER = "com.mysql.jdbc.Driver";
			URL = "jdbc:mysql://"+DESUtil.getDecryptString("XgyrMQgHxfqPwM7HZfkeWfvxqFQ8B/RB")+"?characterEncoding=utf8&useSSL=true";
			USERNAME = DESUtil.getDecryptString("WnplV/ietfQ=");
			PASSWORD = DESUtil.getDecryptString("BQt2T/A9KBFCz6W1NlT8tw==");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
	/**
	 * 得到连接
	 */
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		Connection conn = null;
		Class.forName(DRIVER);
		String url = URL;
		String username = USERNAME;
		String password = PASSWORD;
		conn = DriverManager.getConnection(url,username,password);
		return conn;
	}
	/**
	 * 关闭连接
	 */
	public static void closeConnection(Connection conn, Statement stat,
					ResultSet rs){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(stat != null){
			try {
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
