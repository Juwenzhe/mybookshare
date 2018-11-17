package com.hebut.bookshare.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hebut.bookshare.dao.IPressDao;
import com.hebut.bookshare.datasource.SQLManager;
import com.hebut.bookshare.po.Press;

public class PressDaoImpl implements IPressDao {

	private SQLManager sqlManager;
	
	public PressDaoImpl() {
		super();
		sqlManager = new SQLManager();
	}

	@Override
	public List<Press> selectPress(Connection connection) throws SQLException {

		String sql = "select * from presses";
		Object[] params = {};
		
		ResultSet rs = sqlManager.readable(connection, sql, params);
		List<Press> lstPress = new ArrayList<Press>();
		while(rs.next()){
			Press press = new Press(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
			lstPress.add(press);
		}
		return lstPress;
	}

	@Override
	public Press isExistPress(Connection connection, String name) throws SQLException {

		String sqlStr = "select * from presses where pressname = ?";
		Object[] params = {name};
		
		ResultSet rs = sqlManager.readable(connection, sqlStr, params);
		Press press = null;
		while(rs.next()){
			press = new Press(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
		}
		return press;
	}

	@Override
	public boolean insertPress(Connection connection, Press press) throws SQLException {

		String sqlStr = "insert into presses values(?,?,?,?)";
		Object[] params = {press.getPressid(), press.getPressname(), press.getPressaddress(),press.getPressdescription()};
		
		int inflectedRows = sqlManager.writable(connection, sqlStr, params);
		return inflectedRows==1?true:false;
	}

}
