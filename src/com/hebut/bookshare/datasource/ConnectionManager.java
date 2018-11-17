package com.hebut.bookshare.datasource;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 * <p>Class Name: ConnectionManager</p>
 * <P>Package: com.hebut.bookshare.datasource</p>
 * <p>Description: 为客户端连接数据库提供开关闭数据库连接</p>
 * <p>CopyRight: Hebut</p>
 * @author Administrator
 * @date 2016年12月6日 上午10:53:34
 */
public class ConnectionManager {

	/**
	 * @description: 开启数据库连接
	 * @author: Administrator
	 * @param: null
	 * @return Connection
	 * @throws SQLException 
	 * @exception: SQLException
	 * @date 2016年12月6日 上午10:54:24
	 */
	public Connection openConnection() throws SQLException{

		DataSourceProvider dataSourceProvider = DataSourceProvider.getInstance();
		BasicDataSource basicDataSource= dataSourceProvider.getBasicDataSource();

		Connection connection = basicDataSource.getConnection();
		if(connection !=null){
			System.out.println("[ConnectionManager]:openConnection:>客户获取数据库连接成功！");
			return connection;
		}else{
			System.out.println("[ConnectionManager]:openConnection:>客户获取数据库连接失败！");
			return null;
		}
	}

	/**
	 * @description: 客户端关闭连接
	 * @author: Administrator
	 * @param: connection
	 * @return void
	 * @exception: SQLException
	 * @date 2016年12月6日 上午10:57:33
	 */
	public void closeConnection(Connection connection) throws SQLException{

		if(connection != null && !connection.isClosed()){
			connection.close();
			System.out.println("[ConnectionManager]:closeConnection:>数据库连接关闭成功");
		}
	}
}
