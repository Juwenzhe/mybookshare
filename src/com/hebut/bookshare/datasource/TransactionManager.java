package com.hebut.bookshare.datasource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * <p>Class Name: TransactionManager</p>
 * <P>Package: com.hebut.bookshare.datasource</p>
 * <p>Description: 三件事：设置手动提交事务、事务提交、事务回滚</p>
 * <p>CopyRight: Hebut</p>
 * @author Administrator
 * @date 2016年12月6日 上午11:20:24
 */
public class TransactionManager {

	/**
	 * @description: 设置手动提交事务
	 * @author: Administrator
	 * @param: connection
	 * @return void
	 * @throws SQLException 
	 * @exception 
	 * @date 2016年12月6日 上午11:22:25
	 */
	public void beginTransaction(Connection connection) throws SQLException{
		
			connection.setAutoCommit(false);
			System.out.println("[TransactionManager]:beginTransaction:>手动提交事务模式开启");
	}
	
	/**
	 * @description: TODO
	 * @author: Administrator
	 * @param: connection
	 * @return void
	 * @throws SQLException 
	 * @exception
	 * @date 2016年12月6日 上午11:29:09
	 */
	public void commitTransaction(Connection connection) throws SQLException{
		
			connection.commit();
			System.out.println("[TransactionManager]:commitTransaction:>已提交事务");
	}
	
	/**
	 * @description: TODO
	 * @author: Administrator
	 * @param: connection
	 * @return void
	 * @throws SQLException 
	 * @exception
	 * @date 2016年12月6日 上午11:30:31
	 */
	public void rollBackTransaction(Connection connection) throws SQLException{
		connection.rollback();
		System.out.println("[TransactionManager]:commitTransaction:>事务已回滚");
	}
}
