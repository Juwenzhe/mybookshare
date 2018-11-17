package com.hebut.bookshare.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import com.hebut.bookshare.po.User;
import com.hebut.bookshare.po.UserDetails;

public interface IUserDao {

	public abstract boolean testUserNameDao(Connection connection, String username) throws SQLException;
	public abstract User loginDao(Connection connection,String username, String password)throws SQLException;
	public abstract void lastlogintimeDao(Connection connection,String uid)throws SQLException;
	public abstract boolean fastRegister(Connection connection, User user)throws SQLException;
	public abstract boolean detailRegister(Connection connection,UserDetails userDetails) throws SQLException;
	public abstract int selectUsersByDate(Connection connection, Date date)throws SQLException;
	
}
