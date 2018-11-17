package com.hebut.bookshare.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hebut.bookshare.po.User;


public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LogoutServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		ServletContext application = this.getServletContext();
		
		@SuppressWarnings("unchecked")
		List<String> lstnames = (List<String>) application.getAttribute("onLineList");
		if(lstnames ==null ){
			lstnames = new ArrayList<String>();
		}else{
			lstnames.remove(user.getUsername());
		}
		application.setAttribute("onLineList", lstnames);
		
		session.removeAttribute("user");
		session.invalidate();
		response.sendRedirect("welcome");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
