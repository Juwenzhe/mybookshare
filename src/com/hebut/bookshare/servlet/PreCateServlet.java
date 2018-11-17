package com.hebut.bookshare.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hebut.bookshare.biz.ICateBiz;
import com.hebut.bookshare.biz.impl.CateBizImpl;
import com.hebut.bookshare.po.Category;

public class PreCateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PreCateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ICateBiz iCateBiz = new CateBizImpl();
		List<Category> lstcates = iCateBiz.findAllcates();
		request.setAttribute("lstcates", lstcates);
		RequestDispatcher dispatcher = request.getRequestDispatcher("share");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
