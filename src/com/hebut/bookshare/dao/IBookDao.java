package com.hebut.bookshare.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.hebut.bookshare.po.Book;
import com.hebut.bookshare.po.VBook;
import com.hebut.bookshare.vo.PageBean;

public interface IBookDao {

	public abstract PageBean showVBookByCondtion(Connection connection, final int currentPage, final int pageSize, String condtion)throws SQLException;
	public abstract PageBean showVBookByPage(Connection connection, final int currentPage, final int pageSize)throws SQLException;
	public abstract VBook selectVBookByBookid(Connection connection, final String bookid)throws SQLException;
	public abstract int selectVBooksCntByCate(Connection connection, final String catename)throws SQLException;
	public abstract List<VBook> selectTop10Book(Connection connection) throws SQLException;
	public abstract List<VBook> selectRandom4Book(Connection connection, final int beginnum) throws SQLException;
	public abstract int selectBooksCntByDate(Connection connection, Date date)throws SQLException;
	public abstract boolean insertBook(Connection connection, final Book book)throws SQLException;
	
}
