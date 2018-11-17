package com.hebut.bookshare.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hebut.bookshare.biz.IBookBiz;
import com.hebut.bookshare.biz.IUserBiz;
import com.hebut.bookshare.biz.impl.BookBizImpl;
import com.hebut.bookshare.biz.impl.UserBizImpl;
import com.hebut.bookshare.utils.GetYesterday;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ShowPeoBooCntServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ShowPeoBooCntServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		JSONObject data = new JSONObject();
		JSONArray peopledata = new JSONArray();
		JSONArray bookscnt = new JSONArray();
		JSONArray dt = new JSONArray();
		
		IBookBiz iBookBiz = new BookBizImpl();
		IUserBiz iUserBiz = new UserBizImpl();
		
		Date date = new Date();
		for (int i = 0; i < 7; i++) {
			date = GetYesterday.getYesterday(date);
			System.out.println(data);
			int bookcnt = iBookBiz.findBookCntByDate(date);
			bookscnt.put(bookcnt);
			int usercnt = iUserBiz.findUserCntByDate(date);
			peopledata.put(usercnt);
			dt.put(new SimpleDateFormat("MM月dd日").format(date));
		}
		
		data.put("bookscnt", bookscnt);
		data.put("peopledata", peopledata);
		data.put("date", dt);
		
		response.getWriter().print(data);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
