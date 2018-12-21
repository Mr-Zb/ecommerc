/**   
* @Title: FileUtils.java 
* @Package com.attiot.mq 
* @Description: TODO
* @author zhangbf
* @company attiot  
* @date 2017年3月29日 上午10:12:01 
* @version V1.0   
*/
package com.fun.mysqldb.utils;

import java.util.Properties;


public class FileUtils implements java.io.Serializable{

	private static FileUtils instance;
	private static String logPath;	
//	private static SimpleDateFormat dateFormat;
	

	private FileUtils() {
		Properties property = new Properties();
		try {
			property.load(FileUtils.class.getClassLoader().getResourceAsStream("cloud.properties"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		property.clear();
	}
	
	public static FileUtils getInstance() {
		if(null == instance) {
			instance = new FileUtils();			
		}
		return instance;
	}
	
}
