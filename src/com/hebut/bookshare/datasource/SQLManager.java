package com.hebut.bookshare.datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * <p>Class Name: SQLManager</p>
 * <P>Package: com.hebut.bookshare.datasource</p>
 * <p>Description: 通用的增删改查</p>
 * <p>CopyRight: Hebut</p>
 * @author Administrator
 * @date 2016年12月6日 上午11:17:24
 */
public class SQLManager {

	/**
	 * @description: 通用的增删改
	 * @author: Administrator
	 * @param: connection, sqlStr, params
	 * @return int
	 * @exception: SQLException
	 * @date 2016年12月6日 上午11:17:52
	 */
	public int writable(Connection connection, String sqlStr, Object...params) throws SQLException{
		
		//预编译sql语句
		PreparedStatement pstmt = connection.prepareStatement(sqlStr);
		
		for (int i = 0; i < params.length; i++) {
			pstmt.setObject(i+1, params[i]);
		}
		
		int inflectedRows = pstmt.executeUpdate();
		
		return inflectedRows;
		
	}
	
	/**
	 * @description: 通用的查
	 * @author: Administrator
	 * @param: connection, sqlStr, params
	 * @return ResultSet
	 * @exception: SQLException
	 * @date 2016年12月6日 上午11:19:05
	 */
	public ResultSet readable(Connection connection, String sqlStr, Object...params)throws SQLException{
		
		//预编译sql语句
		PreparedStatement pstmt = connection.prepareStatement(sqlStr);
		
		for (int i = 0; i < params.length; i++) {
			pstmt.setObject(i+1, params[i]);
		}
		
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}
}
