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
import com.hebut.bookshare.po.URLParams;
import com.hebut.bookshare.utils.RequestToBean;
import com.hebut.bookshare.vo.PageBean;

public class ShowBookByConditionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ServletConfig config;
	public ShowBookByConditionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		URLParams params = new URLParams();
		RequestToBean.populate(request, params);

		String condtion = "";
		String cdt = "";
		if(params.getSearchbookname() !=null){
			String bookname = new String(params.getSearchbookname().getBytes("iso-8859-1"), "UTF-8");
			condtion+=" bookname like '%"+bookname+"%' and ";
			cdt+="{bookname:'"+bookname+"'},";
		}
		if(params.getSearchshareuser() !=null){
			String bookshareuser = new String(params.getSearchshareuser().getBytes("iso-8859-1"), "UTF-8");
			condtion+=" bookshareuser like '%"+bookshareuser+"%' and ";
			cdt+="{bookshareuser:'"+bookshareuser+"'},";
		}
		if(params.getSearchpress() !=null){
			String press = new String(params.getSearchpress().getBytes("iso-8859-1"), "UTF-8");
			condtion+=" press like '%"+press+"%' and ";
			cdt+="{press:'"+press+"'},";
		}
		if(params.getMaxprice() !=null){
			if(params.getMinprice() !=null){
				condtion+=" bookprice between "+Float.parseFloat(params.getMinprice())+" and "+Float.parseFloat(params.getMaxprice())+" and ";
				cdt+="{max:"+Float.parseFloat(params.getMaxprice())+"},{min:"+Float.parseFloat(params.getMinprice())+"},";
			}else{
				condtion+=" bookprice between 0 and "+Float.parseFloat(params.getMaxprice())+" and ";
				cdt+="{max:"+Float.parseFloat(params.getMaxprice())+"},{min:0},";
			}
		}else{
			if(params.getMinprice() !=null){
				condtion+=" bookprice > "+Float.parseFloat(params.getMinprice())+" and ";
				cdt+="{min:"+Float.parseFloat(params.getMinprice())+"},";
			}
		}
		if(condtion !=""){
			condtion = condtion.substring(0, condtion.length()-5);
		}
		int currentPage=1;
		String currentPage1 = request.getParameter("currentPage");
		if(currentPage1 !=null && !currentPage1.equals("null"))
			currentPage = Integer.parseInt(currentPage1);

		int pageSize = Integer.parseInt(config.getInitParameter("pagesize"));

		IBookBiz iBookBiz = new BookBizImpl();
		PageBean pageBean = iBookBiz.showVBookByCondtion(currentPage, pageSize, condtion);

		request.setAttribute("pageBean", pageBean);
		System.out.println("ShowBookByConditionServlet:>"+cdt);
		request.setAttribute("condtion", cdt);
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
