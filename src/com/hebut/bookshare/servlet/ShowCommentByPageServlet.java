package com.hebut.bookshare.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hebut.bookshare.biz.IBookBiz;
import com.hebut.bookshare.biz.ICommentBiz;
import com.hebut.bookshare.biz.impl.BookBizImpl;
import com.hebut.bookshare.biz.impl.CommentBizImpl;
import com.hebut.bookshare.po.VBook;
import com.hebut.bookshare.po.VComment;
import com.hebut.bookshare.vo.PageBean;

public class ShowCommentByPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ServletConfig config;
    public ShowCommentByPageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String bookid = request.getParameter("bookid");
		ICommentBiz iCommentBiz = new CommentBizImpl();
		int currentpage = 1;
		if(request.getParameter("currentPage") !=null){
			currentpage = Integer.parseInt(request.getParameter("currentPage"));
		};
		int pagesize = Integer.parseInt(config.getInitParameter("pagesize"));
		
//		Comment comment = iCommentBiz.findAllCommentByBookid(bookid);
		PageBean pagebeancomment = iCommentBiz.findCommentsByPageAndBookid(currentpage, pagesize, bookid);
		List<VComment> lstVComments = iCommentBiz.findAllCommentByBookid(bookid).getLstSinComments();
		double scores = 0.0;
		for (VComment vComment : lstVComments) {
			scores += vComment.getCommentscore();
		}
		int score = 5;
		if(lstVComments.size()!=0){
			score = (int)scores/lstVComments.size();
		}
		request.setAttribute("score", score);
		request.setAttribute("pagebeancomment", pagebeancomment);
		IBookBiz iBookBiz = new BookBizImpl();
		VBook book = iBookBiz.findVBookByBookid(bookid);
		request.setAttribute("book", book);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/bookdetails.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
	}
}
