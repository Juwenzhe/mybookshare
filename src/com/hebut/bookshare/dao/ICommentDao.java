package com.hebut.bookshare.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.hebut.bookshare.po.Comment;
import com.hebut.bookshare.vo.PageBean;

public interface ICommentDao {

	public abstract Comment selectAllComments(final Connection connection, final String bookid)throws SQLException;
	public abstract PageBean selectCommentsByPageAndBookid(final Connection connection,final int pagesize,final int currentpage,final String bookid)throws SQLException;
}
