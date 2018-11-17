package com.hebut.bookshare.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hebut.bookshare.dao.ICategoryDao;
import com.hebut.bookshare.datasource.SQLManager;
import com.hebut.bookshare.po.Category;

public class CategoryDaoImpl implements ICategoryDao{

	private SQLManager sqlManager;
	
	public CategoryDaoImpl() {
		super();
		sqlManager = new SQLManager();
	}

	@Override
	public List<Category> showCate(Connection connection) throws SQLException {
		
		String sql = "select * from category";
		Object[] params = {};
		
		ResultSet rs = sqlManager.readable(connection, sql, params);
		List<Category> lstCates = new ArrayList<Category>();
		while(rs.next()){
			Category category = new Category(rs.getString(1), rs.getString(2), rs.getString(3));
			lstCates.add(category);
		}
		return lstCates;
	}

	@Override
	public String findCateIdByCateName(Connection connection, String catename) throws SQLException {

		String sql = "select cateid from category where catename = ?";
		Object[] params = {catename};
		
		ResultSet rs = sqlManager.readable(connection, sql, params);
		while(rs.next()){
			 return rs.getString(1);
		}
		return null;
	}
}
