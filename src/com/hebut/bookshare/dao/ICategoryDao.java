package com.hebut.bookshare.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.hebut.bookshare.po.Category;

public interface ICategoryDao {

	public abstract List<Category> showCate(Connection connection)throws SQLException;
	public abstract String findCateIdByCateName(Connection connection, String catename) throws SQLException;
	
}
