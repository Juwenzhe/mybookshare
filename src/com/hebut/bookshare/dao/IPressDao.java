package com.hebut.bookshare.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.hebut.bookshare.po.Press;

public interface IPressDao {

	public abstract boolean insertPress(Connection connection, final Press press)throws SQLException;
	public abstract Press isExistPress(Connection connection, final String name)throws SQLException;
	public abstract List<Press> selectPress(Connection connection)throws SQLException;
}
