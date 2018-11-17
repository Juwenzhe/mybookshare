package com.hebut.bookshare.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hebut.bookshare.biz.IBookBiz;
import com.hebut.bookshare.biz.impl.BookBizImpl;
import com.hebut.bookshare.po.VBook;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Guess4BooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Guess4BooksServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int beginnum = (int)(3*Math.random());
		IBookBiz iBookBiz = new BookBizImpl();
		List<VBook> lstBooks = iBookBiz.selectRandom4Book(beginnum);
		
		JSONObject data = new JSONObject();
		JSONArray bookid = new JSONArray();
		for (VBook vBook : lstBooks) {
			bookid.put(vBook.getBookid());
		}
		data.put("bookid", bookid);
		
		response.getWriter().print(data);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
