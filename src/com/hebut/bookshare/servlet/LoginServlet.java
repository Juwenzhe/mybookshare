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

import com.hebut.bookshare.biz.IUserBiz;
import com.hebut.bookshare.biz.impl.UserBizImpl;
import com.hebut.bookshare.po.User;
import com.hebut.bookshare.utils.MD5Utils;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//统计在线人数
		ServletContext application = this.getServletContext();
		@SuppressWarnings("unchecked")
		List<String> lstnames = (List<String>) application.getAttribute("onLineList");
		if(lstnames ==null ){
			lstnames = new ArrayList<String>();
		}
		if(username !=null && password !=null){
			String md5password = MD5Utils.toMD5String((request.getParameter("password")));
			IUserBiz userbiz = new UserBizImpl();
			User user = userbiz.loginBiz(username, md5password);
			if(user !=null){
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				String lastpage = request.getParameter("lastpage");
				
				//更新全局在线列表
				if(!lstnames.contains(username)){
					lstnames.add(username);
					application.setAttribute("onLineList", lstnames);
				}
				
				System.out.println(lastpage);
				if(lastpage!=""){
					response.sendRedirect(lastpage);
				}else{
					response.sendRedirect("welcome");
				}
			}else{
				response.sendRedirect("login?resCode=201");
			}
		}else{
			response.sendRedirect("welcome?resCode=301");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
