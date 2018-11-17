package com.hebut.bookshare.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hebut.bookshare.dao.ICommentDao;
import com.hebut.bookshare.datasource.SQLManager;
import com.hebut.bookshare.po.Comment;
import com.hebut.bookshare.po.VComment;
import com.hebut.bookshare.vo.PageBean;

public class CommentDaoImpl implements ICommentDao{

	private SQLManager sqlManager;
	
	public CommentDaoImpl() {
		super();
		sqlManager = new SQLManager();
	}

	@Override
	public Comment selectAllComments(Connection connection, String bookid) throws SQLException {

		String sqlStr = "select * from vcomments where bookid=?";
		Object[] params = {bookid};
		
		ResultSet rs = sqlManager.readable(connection, sqlStr, params);
		List<VComment> lstComments = new ArrayList<VComment>();
		while(rs.next()){
			VComment vComment = new VComment(rs.getString(1), rs.getDate(2), rs.getString(3), rs.getDouble(4), 
					rs.getString(5), rs.getString(6), rs.getString(7));
			lstComments.add(vComment);
		}
		Comment comment = new Comment(bookid, lstComments);
		
		return comment;
	}

	@Override
	public PageBean selectCommentsByPageAndBookid(Connection connection, int pagesize, int currentpage, String bookid)
			throws SQLException {
		String sql = "select * from vcomments where bookid=? limit ?,?";
		int beginRows = (currentpage-1)*pagesize;
		Object[] params = {bookid, beginRows, pagesize};
		
		ResultSet rs = sqlManager.readable(connection, sql, params);
		List<VComment> lstComments = new ArrayList<VComment>();
		while(rs.next()){
			VComment vComment = new VComment(rs.getString(1), rs.getDate(2), rs.getString(3), rs.getDouble(4), 
					rs.getString(5), rs.getString(6), rs.getString(7));
			lstComments.add(vComment);
		}
		String sql2 = "select count(*)  from vcomments where bookid=?";
		Object[] params2 = {bookid};
		ResultSet rs2 = sqlManager.readable(connection, sql2, params2);
		int totalRows = 0;
		while(rs2.next()){
			totalRows = rs2.getInt(1);break;
		}
		int totalPages = totalRows%pagesize==0?(totalRows/pagesize):(totalRows/pagesize+1);
		PageBean pageBean = new PageBean(totalRows, totalPages, currentpage, pagesize, lstComments);
		return pageBean;
	}

	
}
