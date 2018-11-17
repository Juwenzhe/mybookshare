package com.hebut.bookshare.biz;

import com.hebut.bookshare.po.Comment;
import com.hebut.bookshare.vo.PageBean;

public interface ICommentBiz {

	public abstract Comment findAllCommentByBookid(String bookid);
	public abstract PageBean findCommentsByPageAndBookid(int currentpage, int pagesize, final String bookid);
}
