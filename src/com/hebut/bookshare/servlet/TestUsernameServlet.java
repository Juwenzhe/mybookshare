package com.hebut.bookshare.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hebut.bookshare.biz.IUserBiz;
import com.hebut.bookshare.biz.impl.UserBizImpl;

public class TestUsernameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public TestUsernameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String userName = new String(username.getBytes("iso-8859-1"), "UTF-8");
		IUserBiz iUserBiz= new UserBizImpl();
		boolean flag = iUserBiz.testUserName(userName);
		System.out.println(flag?"用户名不可用":"用户名可用");
		response.getWriter().print(flag);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
