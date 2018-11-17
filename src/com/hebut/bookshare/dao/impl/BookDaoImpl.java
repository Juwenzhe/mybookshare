package com.hebut.bookshare.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hebut.bookshare.dao.IBookDao;
import com.hebut.bookshare.datasource.SQLManager;
import com.hebut.bookshare.po.Book;
import com.hebut.bookshare.po.VBook;
import com.hebut.bookshare.vo.PageBean;

public class BookDaoImpl implements IBookDao {

	private SQLManager sqlManager;
	
	public BookDaoImpl() {
		super();
		sqlManager = new SQLManager();
	}

	@Override
	public PageBean showVBookByPage(Connection connection, int currentPage, int pageSize) throws SQLException {
		
		String sql = "select * from v_books limit ?,?";
		int beginRow = (currentPage-1)*pageSize;
		Object[] params = {beginRow, pageSize};
		
		ResultSet rs = sqlManager.readable(connection, sql, params);
		List<VBook> lstVBooks = new ArrayList<VBook>();
		while(rs.next()){
			VBook vBook = new VBook(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getString(5), 
					rs.getString(6), rs.getString(7), rs.getString(8), rs.getDouble(9), rs.getInt(10), rs.getString(11), 
					rs.getTimestamp(12), rs.getDouble(13),rs.getString(14));
			lstVBooks.add(vBook);
		}
		String sqlStr2 = "select count(*) from v_books";
		Object[] params2={};
		
		ResultSet rs2 = sqlManager.readable(connection, sqlStr2, params2);
		int totalRows = 0;
		while(rs2.next()){
			totalRows = rs2.getInt(1);break;
		}
		int totalPages = totalRows%pageSize==0?(totalRows/pageSize):(totalRows/pageSize+1);
		PageBean pageBean = new PageBean(totalRows, totalPages, currentPage, pageSize, lstVBooks);
		
		return pageBean;
	}

	@Override
	public PageBean showVBookByCondtion(Connection connection, int currentPage, int pageSize, String condtion)
			throws SQLException {
		
		String sql = "select * from v_books where";
		ResultSet rs = null;
		if(condtion.length()>3){
			sql +=condtion+" limit ?,?";
			int beginRows = (currentPage-1)*pageSize;
			Object[] params = {beginRows, pageSize};
			
			rs = sqlManager.readable(connection, sql, params);
		}else{
			sql=sql.substring(0, sql.length()-5);
			Object[] params = {};
			rs = sqlManager.readable(connection, sql, params);
		}
		
		List<VBook> lstVBooks = new ArrayList<VBook>();
		while(rs.next()){
			VBook vBook = new VBook(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getString(5), 
					rs.getString(6), rs.getString(7), rs.getString(8), rs.getDouble(9), rs.getInt(10), rs.getString(11), 
					rs.getTimestamp(12), rs.getDouble(13),rs.getString(14));
			lstVBooks.add(vBook);
		}
		
		String sql2 = "select count(*) from v_books where";
		if(condtion !=""){
			sql2 +=condtion;
		}else{
			sql2 = sql2.substring(0, sql2.length()-5);
		}
		Object[] params2 = {};
		ResultSet rs2 = sqlManager.readable(connection, sql2, params2);
		int totalRows = 0;
		while(rs2.next()){
			totalRows = rs2.getInt(1);break;
		}
		int totalPages = totalRows%pageSize==0?(totalRows/pageSize):(totalRows/pageSize+1);
		PageBean pageBean = new PageBean(totalRows, totalPages, currentPage, pageSize, lstVBooks);
		return pageBean;
	}

	@Override
	public VBook selectVBookByBookid(Connection connection, String bookid) throws SQLException {

		String sql = "select * from v_books where bookid = ?";
		Object[] params = {bookid};
		ResultSet rs = sqlManager.readable(connection, sql, params);
		VBook vBook = null;
		while(rs.next()){
			vBook = new VBook(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getString(5), rs.getString(6), 
					rs.getString(7), rs.getString(8), rs.getDouble(9), rs.getInt(10), rs.getString(11), rs.getDate(12), rs.getDouble(13), rs.getString(14));
			break;
		}
		return vBook;
	}

	@Override
	public int selectVBooksCntByCate(Connection connection, String catename) throws SQLException {
		
		String sql = "select count(*) from v_books where category = ?";
		Object[] params = {catename};
		
		ResultSet rs =  sqlManager.readable(connection, sql, params);
		int i = 0;
		while(rs.next()){
			i = rs.getInt(1);
		}
		return i;
	}

	@Override
	public List<VBook> selectTop10Book(Connection connection) throws SQLException {

		String sql = "select * from v_books order by downloadcnt limit 0,9";
		Object[] params={};
		ResultSet rs = sqlManager.readable(connection, sql, params);
		List<VBook> lstBooks = new ArrayList<VBook>();
		while(rs.next()){
			VBook vBook = new VBook(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getString(5), rs.getString(6), 
					rs.getString(7), rs.getString(8), rs.getDouble(9), rs.getInt(10), rs.getString(11), rs.getDate(12), rs.getDouble(13), rs.getString(14));
			lstBooks.add(vBook);
		}
		return lstBooks;
	}

	@Override
	public List<VBook> selectRandom4Book(Connection connection, int beginnum)throws SQLException {

		String sql = "select * from v_books limit ?,5";
		Object[] params = {beginnum};
		ResultSet rs = sqlManager.readable(connection, sql, params);
		List<VBook> lstBooks = new ArrayList<VBook>();
		while(rs.next()){
			VBook vBook = new VBook(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getString(5), rs.getString(6), 
					rs.getString(7), rs.getString(8), rs.getDouble(9), rs.getInt(10), rs.getString(11), rs.getDate(12), rs.getDouble(13), rs.getString(14));
			lstBooks.add(vBook);
		}
		return lstBooks;
	}

	@Override
	public int selectBooksCntByDate(Connection connection, Date date) throws SQLException {
		
		String sql = "select count(*) from v_books where booksharetime < ?";
		Object[] params = {date};
		
		ResultSet rs = sqlManager.readable(connection, sql, params);
		int i = 0;
		while(rs.next()){
			i = rs.getInt(1);
		}
		return i;
	}

	@Override
	public boolean insertBook(Connection connection, Book book) throws SQLException {
		String sqlStr = "insert into books values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params = {book.getBookid(), book.getName(), book.getBookprice(), book.getBookshareuid(), 
				book.getBooksharelvl(), book.getCategoryid(), book.getPhotoid(), book.getPressid(), 
				book.getDownloadcnt(), book.getAvailable(), book.getBooksharetime(), book.getBookscore(), 
				book.getBookdescription()};
		int inflectedRows = sqlManager.writable(connection, sqlStr, params);
		return inflectedRows==1?true:false;
	}

}
