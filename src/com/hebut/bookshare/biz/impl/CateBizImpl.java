package com.hebut.bookshare.biz.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.hebut.bookshare.biz.ICateBiz;
import com.hebut.bookshare.dao.ICategoryDao;
import com.hebut.bookshare.dao.impl.CategoryDaoImpl;
import com.hebut.bookshare.datasource.ConnectionManager;
import com.hebut.bookshare.po.Category;

public class CateBizImpl implements ICateBiz {

	private ICategoryDao iCateDao;
	private ConnectionManager connectionManager;
	
	public CateBizImpl() {
		super();
		iCateDao = new CategoryDaoImpl();
		connectionManager = new ConnectionManager();
	}

	@Override
	public List<Category> findAllcates() {

		Connection connection = null;
		try {
			connection = connectionManager.openConnection();
			return iCateDao.showCate(connection);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally{
			try {
				connectionManager.closeConnection(connection);
			} catch (SQLException e) {
				System.out.println("findAllcates:>关闭数据连接失败！");
			}
		}
	}

	@Override
	public String findCateId(String catename) {
		Connection connection = null;
		try {
			connection = connectionManager.openConnection();
			return iCateDao.findCateIdByCateName(connection, catename);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally{
			try {
				connectionManager.closeConnection(connection);
			} catch (SQLException e) {
				System.out.println("findCateId:>关闭数据连接失败！");
			}
		}
	}
}
