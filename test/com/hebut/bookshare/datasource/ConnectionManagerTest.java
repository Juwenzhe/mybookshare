package com.hebut.bookshare.datasource;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

public class ConnectionManagerTest {

	@Test
	public void testOpenConnection() throws SQLException {
		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = connectionManager.openConnection();
		if(connection !=null){
			System.out.println("开启成功！");
		}
	}

	@Test
	public void testCloseConnection() throws SQLException {
		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = connectionManager.openConnection();
		if(connection !=null){
			System.out.println("开启成功！");
		}
		connectionManager.closeConnection(connection);
		System.out.println("关闭成功！");
	}

}
