package com.hebut.bookshare.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hebut.bookshare.biz.IBookBiz;
import com.hebut.bookshare.biz.ICateBiz;
import com.hebut.bookshare.biz.impl.BookBizImpl;
import com.hebut.bookshare.biz.impl.CateBizImpl;
import com.hebut.bookshare.po.Category;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ShowPercentByCate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShowPercentByCate() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		JSONObject data = new JSONObject();
		JSONArray catedata = new JSONArray();
		JSONArray catesdetails = new JSONArray();
		ICateBiz iCateBiz = new CateBizImpl();
		IBookBiz iBookBiz = new BookBizImpl();
		List<Category> lstcates = iCateBiz.findAllcates();
		for (Category category : lstcates) {
			catedata.put(category.getCatename());
			int cnt = iBookBiz.findVBookCntByCate(category.getCatename());
			catesdetails.put("{value:"+cnt+", name:\""+category.getCatename()+"\"}");
		}
		data.put("catedata", catedata);
		data.put("catesdetails", catesdetails);
		
		response.getWriter().println(data);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
