package com.hebut.bookshare.biz.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import com.hebut.bookshare.biz.IUserBiz;
import com.hebut.bookshare.dao.IUserDao;
import com.hebut.bookshare.dao.impl.UserDaoImpl;
import com.hebut.bookshare.datasource.ConnectionManager;
import com.hebut.bookshare.datasource.TransactionManager;
import com.hebut.bookshare.po.User;
import com.hebut.bookshare.po.UserDetails;

public class UserBizImpl implements IUserBiz{

	private IUserDao iUserDao;

	public UserBizImpl() {
		super();
		iUserDao = new UserDaoImpl();
	}


	@Override
	public User loginBiz(String username, String password) {

		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = null;
		try {
			connection = connectionManager.openConnection();

			User user = iUserDao.loginDao(connection, username, password);
			iUserDao.lastlogintimeDao(connection, username);
			return user;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally{
			try {
				connectionManager.closeConnection(connection);
			} catch (SQLException e) {
				System.out.println("connectionManager.closeConnection(connection):>关闭数据库连接失败！");
			}
		}

	}


	@Override
	public boolean testUserName(String username) {

		//开启一个有效的连接
		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = null;
		try {
			connection = connectionManager.openConnection();
			return iUserDao.testUserNameDao(connection, username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally{
			try {
				connectionManager.closeConnection(connection);
			} catch (SQLException e) {
				System.out.println("UserBiz:testUserName:>关闭连接失败！");
			}
		}
	}


	@Override
	public boolean fastRegister(User user) {

		//获取一个有效的连接
		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = null;
		try {
			connection = connectionManager.openConnection();
			//2.开启事务
			TransactionManager transactionManager = new TransactionManager();
			transactionManager.beginTransaction(connection);
			//3.调用UserDao的方法
			boolean flag = iUserDao.fastRegister(connection, user);
			if(flag){
				transactionManager.commitTransaction(connection);
			}else{
				transactionManager.rollBackTransaction(connection);
			}

			return flag;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally{
			try {
				connectionManager.closeConnection(connection);
			} catch (SQLException e) {
				System.out.println("fastRegister:>快速注册失败！");
			}
		}

	}


	@Override
	public boolean detailsRegister(UserDetails details) {

		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = null;
		try {
			connection = connectionManager.openConnection();

			TransactionManager transactionManager = new TransactionManager();
			transactionManager.beginTransaction(connection);

			boolean flag = iUserDao.detailRegister(connection, details);

			if(flag){
				transactionManager.commitTransaction(connection);
			}else{
				transactionManager.rollBackTransaction(connection);
			}
			return flag;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally{
			try {
				connectionManager.closeConnection(connection);
			} catch (SQLException e) {
				System.out.println("detailsRegister:>关闭连接失败！");
			}
		}

	}


	@Override
	public int findUserCntByDate(Date date) {
		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = null;
		try {
			connection = connectionManager.openConnection();
			return iUserDao.selectUsersByDate(connection, date);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} finally{
			try {
				connectionManager.closeConnection(connection);
			} catch (SQLException e) {
				System.out.println("UserBiz:findUserCntByDate:>关闭连接失败！");
			}
		}
	}


}
