package com.hebut.bookshare.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddBookToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AddBookToCartServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String bookid = request.getParameter("bookid");
		System.out.println(bookid);
		System.out.println("fangwen");
		response.getWriter().print("{\"bookid\":\"书号"+bookid+"\"}");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
