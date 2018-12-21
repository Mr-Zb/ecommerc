/**   
* @Title: MySQLDBUtils.java 
* @Package com.attiot.mysqldb.utils 
* @Description: TODO
* @author zhangbf
* @company attiot  
* @date 2017年5月4日 上午11:49:58 
* @version V1.0   
*/
package com.fun.mysqldb.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MySQLDBUtils {
	private static MySQLDBUtils instance;
	public Connection conn;
	private MySQLDBUtils() {		
		try {
			Properties property = new Properties();			
			property.load(FileUtils.class.getClassLoader().getResourceAsStream("cloud.properties"));
			String url = property.getProperty("db.url");
			String username = property.getProperty("db.username");	
			String password = property.getProperty("db.password");
			property.clear();				
			Class.forName("com.mysql.jdbc.Driver");
		    conn = DriverManager.getConnection(url , username , password ) ; 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public static MySQLDBUtils getInstance() {
		if(null == instance) {
			instance = new MySQLDBUtils();
		}
		return instance;
	}
	
	
	public Connection getConnection() {
		return this.conn;
	}
	
	public void closeConnection() {
		if(null!=conn) {
			try {			
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}	
}
