package com.hebut.bookshare.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hebut.bookshare.biz.IBookBiz;
import com.hebut.bookshare.biz.ICommentBiz;
import com.hebut.bookshare.biz.impl.BookBizImpl;
import com.hebut.bookshare.biz.impl.CommentBizImpl;
import com.hebut.bookshare.po.Comment;
import com.hebut.bookshare.po.VBook;

public class ShowBookDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ShowBookDetailsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bookid = request.getParameter("bookid");
		ICommentBiz iCommentBiz = new CommentBizImpl();
		Comment comment = iCommentBiz.findAllCommentByBookid(bookid);
		request.setAttribute("comment", comment);
		IBookBiz iBookBiz = new BookBizImpl();
		VBook book = iBookBiz.findVBookByBookid(bookid);
		request.setAttribute("book", book);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/bookdetails.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
