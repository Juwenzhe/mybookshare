package com.hebut.bookshare.biz.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.hebut.bookshare.biz.IPressBiz;
import com.hebut.bookshare.dao.IPressDao;
import com.hebut.bookshare.dao.impl.PressDaoImpl;
import com.hebut.bookshare.datasource.ConnectionManager;
import com.hebut.bookshare.datasource.TransactionManager;
import com.hebut.bookshare.po.Press;

public class PressBizImpl implements IPressBiz {

	private ConnectionManager connectionManager;
	private IPressDao iPressDao;
	
	public PressBizImpl() {
		super();
		connectionManager = new ConnectionManager();
		iPressDao = new PressDaoImpl();
	}

	@Override
	public List<Press> findAllPress() {

		Connection connection = null;
		try {
			connection = connectionManager.openConnection();
			return iPressDao.selectPress(connection);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally{
			try {
				connectionManager.closeConnection(connection);
			} catch (SQLException e) {
				System.out.println("findAllPress:>关闭连接失败！");
			}
		}
	}

	@Override
	public Press findPressByPressName(String pressname) {
		Connection connection = null;
		try {
			connection = connectionManager.openConnection();
			return iPressDao.isExistPress(connection, pressname);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally{
			try {
				connectionManager.closeConnection(connection);
			} catch (SQLException e) {
				System.out.println("findPressByPressName:>关闭连接失败！");
			}
		}
	}

	@Override
	public boolean addPress(Press press) {
		
		Connection connection = null;
		try {
			connection = connectionManager.openConnection();
			
			TransactionManager transactionManager = new TransactionManager();
			transactionManager.beginTransaction(connection);
			
			boolean flag = iPressDao.insertPress(connection, press);
			if(flag){
				transactionManager.commitTransaction(connection);
			}else{
				transactionManager.rollBackTransaction(connection);
			}
			return flag;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally{
			try {
				connectionManager.closeConnection(connection);
			} catch (SQLException e) {
				System.out.println("addPress:>关闭连接失败！");
			}
		}
		
	}
}
