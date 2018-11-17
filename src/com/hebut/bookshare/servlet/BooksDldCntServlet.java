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

public class BooksDldCntServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BooksDldCntServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		JSONObject json = new JSONObject();
		JSONArray ydata = new JSONArray();
		JSONArray dldcnt = new JSONArray();
		
		IBookBiz iBookBiz = new BookBizImpl();
		List<VBook> lstBooks = iBookBiz.selectTop10Book();
		for (VBook vBook : lstBooks) {
			ydata.put(vBook.getBookname());
			dldcnt.put(vBook.getDownloadcnt());
		}
		json.put("ydata", ydata);
		json.put("dldcnt", dldcnt);
		
		response.getWriter().print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
