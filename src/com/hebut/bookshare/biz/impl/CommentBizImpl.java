package com.hebut.bookshare.biz.impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.hebut.bookshare.biz.ICommentBiz;
import com.hebut.bookshare.dao.ICommentDao;
import com.hebut.bookshare.dao.impl.CommentDaoImpl;
import com.hebut.bookshare.datasource.ConnectionManager;
import com.hebut.bookshare.po.Comment;
import com.hebut.bookshare.vo.PageBean;

public class CommentBizImpl implements ICommentBiz{

	private ICommentDao iCommentDao;
	private ConnectionManager connectionManager;
	
	public CommentBizImpl() {
		super();
		iCommentDao = new CommentDaoImpl();
		connectionManager = new ConnectionManager();
	}


	@Override
	public Comment findAllCommentByBookid(String bookid) {
		
		Connection connection = null;
		try {
			connection = connectionManager.openConnection();
			return iCommentDao.selectAllComments(connection, bookid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally{
			try {
				connectionManager.closeConnection(connection);
			} catch (SQLException e) {
				System.out.println("findAllCommentByBookid:>关闭数据库失败！");
			}
		}
		
	}


	@Override
	public PageBean findCommentsByPageAndBookid(int currentpage, int pagesize, String bookid) {

		Connection connection = null;
		try {
			connection = connectionManager.openConnection();
			
			return iCommentDao.selectCommentsByPageAndBookid(connection, pagesize, currentpage, bookid);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally{
			try {
				connectionManager.closeConnection(connection);
			} catch (SQLException e) {
				System.out.println("findCommentsByPageAndBookid:>关闭数据库连接失败!");
			}
		}
		
	}

}
