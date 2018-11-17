package com.hebut.bookshare.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import com.hebut.bookshare.dao.IUserDao;
import com.hebut.bookshare.datasource.SQLManager;
import com.hebut.bookshare.po.User;
import com.hebut.bookshare.po.UserDetails;

public class UserDaoImpl implements IUserDao {

	private SQLManager sqlManager;
	
	public UserDaoImpl() {
		super();
		sqlManager = new SQLManager();
	}

	@Override
	public User loginDao(Connection connection, String username, String password) throws SQLException {

		String sql = "select * from users where username = ? and password = ?";
		Object[] params = {username, password};
		
		ResultSet rs = sqlManager.readable(connection, sql, params);
	
		while(rs.next()){
			User user = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getTimestamp(4),rs.getString(5));
			return user;
		}
		return null;
	}
	
	@Override
	public void lastlogintimeDao(Connection connection, String username) throws SQLException {
		String sql2 = "update users set lastlogintime = ? where username= ?";
		Object[] params2 = {new Timestamp(new Date().getTime()), username};
		sqlManager.writable(connection, sql2, params2);
	}

	@Override
	public boolean testUserNameDao(Connection connection, String username) throws SQLException {

		String sqlStr = "select * from users where username=?";
		Object[] params={username};

		ResultSet rs= sqlManager.readable(connection, sqlStr, params);
		
		return rs.next()?true:false;
	}

	@Override
	public boolean fastRegister(Connection connection, User user) throws SQLException {

		String sqlStr = "insert into users(uid,username,password,condtion,phone) value(?,?,?,?,?)";
		Object[] params = {user.getUid(), user.getUsername(), user.getPassword(), 
				user.getCondtion(),user.getPhone()};
		
		int inflectedRows = sqlManager.writable(connection, sqlStr, params);
		
		return inflectedRows==1?true:false;
	}

	@Override
	public boolean detailRegister(Connection connection, UserDetails userDetails) throws SQLException {
		
		String sql = "insert into userdetails (detaid,uid,level,resmoney,userscore,truename,cityaddress,registime,job,question,birthday,hobby) value(?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params ={userDetails.getDetaid(),userDetails.getUid(),userDetails.getLevel(),userDetails.getResmoney(),
						userDetails.getUserscore(),userDetails.getTruename(),userDetails.getCityaddress(),new Timestamp(userDetails.getRegistime().getTime()),
						userDetails.getJob(),userDetails.getQuestion(),new Timestamp(userDetails.getBirthday().getTime()),userDetails.getHobby()};
		
		return sqlManager.writable(connection, sql, params)==1?true:false;
	}

	@Override
	public int selectUsersByDate(Connection connection, Date date) throws SQLException {
		String sql = "select count(*) from userdetails where registime < ?";
		Object[] params = {date};
		
		ResultSet rs = sqlManager.readable(connection, sql, params);
		int i = 0;
		while(rs.next()){
			i = rs.getInt(1);
		}
		return i;
	}

	

}
