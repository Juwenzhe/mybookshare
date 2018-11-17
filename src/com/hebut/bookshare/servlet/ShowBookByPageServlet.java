package com.hebut.bookshare.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hebut.bookshare.biz.IBookBiz;
import com.hebut.bookshare.biz.impl.BookBizImpl;
import com.hebut.bookshare.vo.PageBean;

public class ShowBookByPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ServletConfig config;
	
    public ShowBookByPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接受用户请求参数
		int currentPage = 1;
		if(request.getParameter("currentPage")==null){
			currentPage = 1;
		}else{
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
			System.out.println(currentPage);
		}
		int pagesize = Integer.parseInt(config.getInitParameter("pagesize"));
		//处理用户请求
		IBookBiz iBookBiz = new BookBizImpl();
		PageBean pageBean = iBookBiz.showVBookByPage(currentPage, pagesize);
		request.setAttribute("pageBean", pageBean);
		//返回结果
		RequestDispatcher dispatcher = request.getRequestDispatcher("search");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
	}
}
