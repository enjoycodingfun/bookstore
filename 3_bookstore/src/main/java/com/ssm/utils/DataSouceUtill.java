
package com.ssm.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSouceUtill {
	private static ComboPooledDataSource dataSource=new ComboPooledDataSource();
	
	private static ThreadLocal<Connection> tl=new ThreadLocal<>();
	
	public static DataSource getDataSource(){
		
		return dataSource;
	}
	
	/**
	 * 从连接池里面取链接
	 * 
	* @author: 千锋讲师张增强
	* @createTime: 2017年9月11日 下午5:00:16
	* @history:
	* @return
	* @throws SQLException Connection
	 */
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
	/**
	 * 获得当前线程 绑定的链接对象
	* @author: 千锋讲师张增强
	* @createTime: 2017年9月11日 下午4:59:42
	* @history:
	* @return
	* @throws SQLException Connection
	 */
	public static Connection getCurrentConnection() throws SQLException{
		Connection conn = tl.get();
		if(conn==null){
			 conn = getConnection();
			 //放到ThreadLocal里
			 tl.set(conn);			
		}
		return conn;
		
	}
	/**
	 * 开启事物
	* @author: 千锋讲师张增强
	* @createTime: 2017年9月11日 下午4:59:34
	* @history:
	* @throws SQLException void
	 */
	public static void beginTransaction() throws SQLException{
		Connection conn = getCurrentConnection();
		if(conn!=null){
			conn.setAutoCommit(false);
			
		}
	}
	/**
	 * 回滚事务
	* @author: 千锋讲师张增强
	 * @throws SQLException 
	* @createTime: 2017年9月11日 下午5:02:24
	* @history: void
	 */
	public static void rollBack() throws SQLException{
		Connection conn = getCurrentConnection();
		if(conn!=null){
			conn.rollback();
			
		}
	}
		

	
	/**
	 * 提交事物
	* @author: 千锋讲师张增强
	* @createTime: 2017年9月11日 下午4:59:34
	* @history:
	* @throws SQLException void
	 */
	public static void commit() throws SQLException{
		Connection conn = getCurrentConnection();
		if(conn!=null){
			conn.commit();
			//把当前线程从ThreadLocal删除
			tl.remove();
		}
	}

}

	