package com.hebut.bookshare.biz.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.hebut.bookshare.biz.IBookBiz;
import com.hebut.bookshare.dao.IBookDao;
import com.hebut.bookshare.dao.impl.BookDaoImpl;
import com.hebut.bookshare.datasource.ConnectionManager;
import com.hebut.bookshare.datasource.TransactionManager;
import com.hebut.bookshare.po.Book;
import com.hebut.bookshare.po.VBook;
import com.hebut.bookshare.vo.PageBean;

public class BookBizImpl implements IBookBiz {

	private IBookDao iBookDao;
	private ConnectionManager connectionManager;
	
	public BookBizImpl() {
		super();
		iBookDao = new BookDaoImpl();
		connectionManager = new ConnectionManager();
	}


	@Override
	public PageBean showVBookByPage(int currentPage, int pageSize) {
		
		Connection connection = null;
		try {
			connection = connectionManager.openConnection();
			
			return iBookDao.showVBookByPage(connection, currentPage, pageSize);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally{
			try {
				connectionManager.closeConnection(connection);
			} catch (SQLException e) {
				System.out.println("showVBookByPage:>关闭连接失败！");
			}
		}
	}


	@Override
	public PageBean showVBookByCondtion(int currentPage, int pageSize, String condtion) {

		Connection connection = null;
		try {
			connection = connectionManager.openConnection();
			
			return iBookDao.showVBookByCondtion(connection, currentPage, pageSize, condtion);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally{
			try {
				connectionManager.closeConnection(connection);
			} catch (SQLException e) {
				System.out.println("showVBookByCondtion:>关闭连接失败！");
			}
		}
		
	}


	@Override
	public VBook findVBookByBookid(String bookid) {
		Connection connection = null;
		try {
			 connection = connectionManager.openConnection();
			 return iBookDao.selectVBookByBookid(connection, bookid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally{
			try {
				connectionManager.closeConnection(connection);
			} catch (SQLException e) {
				System.out.println("findVBookByBookid:>关闭数据库失败！");
			}
		}
		
	}


	@Override
	public int findVBookCntByCate(String catename) {

		Connection connection = null;
		try {
			connection = connectionManager.openConnection();
			return iBookDao.selectVBooksCntByCate(connection, catename);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} finally{
			try {
				connectionManager.closeConnection(connection);
			} catch (SQLException e) {
				System.out.println("findVBookCntByCate:>关闭数据连接失败！");
			}
		}
		
	}


	@Override
	public List<VBook> selectTop10Book() {
		
		Connection connection = null;
		try {
			connection = connectionManager.openConnection();
			return iBookDao.selectTop10Book(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally{
			try {
				connectionManager.closeConnection(connection);
			} catch (SQLException e) {
				System.out.println("selectTop10Book:>关闭数据连接失败！");
			}
		}
	}


	@Override
	public List<VBook> selectRandom4Book(int beginnum) {
		
		Connection connection = null;
		try {
			connection = connectionManager.openConnection();
			return iBookDao.selectRandom4Book(connection, beginnum);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			try {
				connectionManager.closeConnection(connection);
			} catch (SQLException e) {
				System.out.println("selectRandom4Book:>关闭数据库连接失败！");
			}
		}
	}


	@Override
	public int findBookCntByDate(Date date) {
		Connection connection = null;
		try {
			connection = connectionManager.openConnection();
			return iBookDao.selectBooksCntByDate(connection, date);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}finally{
			try {
				connectionManager.closeConnection(connection);
			} catch (SQLException e) {
				System.out.println("findBookCntByDate:>关闭数据库连接失败！");
			}
		}
	}


	@Override
	public boolean addBook(Book book) {
		Connection connection = null;
		try {
			connection = connectionManager.openConnection();
			
			TransactionManager transactionManager = new TransactionManager(); 
			transactionManager.beginTransaction(connection);
			
			boolean flag = iBookDao.insertBook(connection, book);
			if(flag){
				transactionManager.commitTransaction(connection);
			}else{
				transactionManager.rollBackTransaction(connection);
			}
			return flag;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally{
			try {
				connectionManager.closeConnection(connection);
			} catch (SQLException e) {
				System.out.println("addBook:>关闭数据库连接失败！");
			}
		}
	}



}
