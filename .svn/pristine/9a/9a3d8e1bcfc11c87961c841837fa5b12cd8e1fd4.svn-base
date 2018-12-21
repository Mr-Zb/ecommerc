/**   
* @Title: TDeviceLocationDAO.java 
* @Package com.attiot.mysqldb.dao 
* @Description: TODO
* @author zhangbf
* @company attiot  
* @date 2017年5月4日 下午12:39:32 
* @version V1.0   
*/
package com.fun.mysqldb.dao;

import java.sql.Connection;

import java.util.List;

import com.fun.mysqldb.AttributeDto;
import com.fun.mysqldb.SysMessageInfo;
import com.fun.mysqldb.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;


public class TDeviceLocationDAO {

	public List<AttributeDto> getAttributeList() {
		String sql = "select pk_id as pkId,platform_id as platformId,platform_name as platformName,"
				+ " version as version,pay_id as payId ,pay_name as payName,pay_url as payUrl,"
				+ " is_bank as isBank ,is_merge as isMerge from t_attribute"; 
		Connection conn = null;
		List<AttributeDto> query =null;
		try {
			conn = JDBCUtils.getConnection();
			QueryRunner qr = new QueryRunner();
		 query = qr.query(conn, sql, new BeanListHandler<AttributeDto>(AttributeDto.class));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeConnection(conn, null, null);
		}
		return query;
	}
	//查询所有网银信息
	public List<AttributeDto> getAttributeListByBack() {
		String sql = "select  pk_id as pkId,platform_id as platformId,platform_name as platformName, "
				+ " version as version,pay_id as payId ,pay_name as payName,pay_url as payUrl,"
				+ " is_bank as isBank from t_attribute where is_bank = 0"; 
		Connection conn = null;
		List<AttributeDto> query =null;
		try {
			conn = JDBCUtils.getConnection();
			QueryRunner qr = new QueryRunner();
		 query = qr.query(conn, sql, new BeanListHandler<AttributeDto>(AttributeDto.class));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeConnection(conn, null, null);
		}
		return query;
	}
	//查询所有银联信息
	public List<AttributeDto> getAttributeListByBack1(String str) {
		String sql = "select  pk_id as pkId,platform_id as platformId,platform_name as platformName, "
				+ " version as version,pay_id as payId ,pay_name as payName,pay_url as payUrl,"
				+ " is_bank as isBank,is_merge as is_merge from t_attribute where 1=1 and is_bank = 1 and platform_name = ?"; 
		Connection conn = null;
		List<AttributeDto> query =null;
		try {
			conn = JDBCUtils.getConnection();
			QueryRunner qr = new QueryRunner();
		 query = qr.query(conn, sql, new BeanListHandler<AttributeDto>(AttributeDto.class),str);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeConnection(conn, null, null);
		}
		return query;
	}
	
	//查询所有Message信息
		public List<SysMessageInfo> getMessae() {
			String sql = "SELECT pk_id AS pkId," + 
					"t.create_user AS createUser," + 
					"t.create_time AS createTime," + 
					"t.update_user AS updateUser," + 
					"t.update_time AS updateTime," + 
					"t.data_version AS dataVersion," + 
					"t.title AS title," + 
					"t.content AS content," + 
					"t.create_name AS createName, " + 
					"t.state AS state " + 
					"	FROM t_sys_message t where t.state = 1" + 
					"	order by t.create_time desc limit 8"; 
			Connection conn = null;
			List<SysMessageInfo> query =null;
			try {
				conn = JDBCUtils.getConnection();
				QueryRunner qr = new QueryRunner();
			 query = qr.query(conn, sql, new BeanListHandler<SysMessageInfo>(SysMessageInfo.class));
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtils.closeConnection(conn, null, null);
			}
			return query;
		}
}
