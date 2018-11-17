package com.hebut.bookshare.biz;

import java.util.Date;
import java.util.List;

import com.hebut.bookshare.po.Book;
import com.hebut.bookshare.po.VBook;
import com.hebut.bookshare.vo.PageBean;

public interface IBookBiz {

	public abstract PageBean showVBookByPage(int currentPage, int pageSize);
	public abstract PageBean showVBookByCondtion(int currentPage, int pageSize, String condtion);
	public abstract VBook findVBookByBookid(String bookid);
	public abstract int findVBookCntByCate(String catename);
	public abstract List<VBook> selectTop10Book();
	public abstract List<VBook> selectRandom4Book(final int beginnum);
	public abstract boolean addBook(final Book book);
	public abstract int findBookCntByDate(final Date date);
}

