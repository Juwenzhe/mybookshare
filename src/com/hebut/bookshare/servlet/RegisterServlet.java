package com.hebut.bookshare.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hebut.bookshare.biz.IUserBiz;
import com.hebut.bookshare.biz.impl.UserBizImpl;
import com.hebut.bookshare.po.User;
import com.hebut.bookshare.po.UserDetails;
import com.hebut.bookshare.utils.MD5Utils;
import com.hebut.bookshare.utils.RequestToBean;
import com.hebut.bookshare.utils.UUIDProvider;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		//由于字段少，且要对密码加密处理，所以放弃了RequestToBean
		//RequestToBean.populate(request, user);
		if(username !=null && password !=null && phone !=null){
			String md5password = MD5Utils.toMD5String(password);
			User user = new User(UUIDProvider.UUIDProduct(), username, md5password,"安全", phone);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
			UserDetails userDetails = new UserDetails(UUIDProvider.UUIDProduct(), user.getUid(), 1, new Date());
			if(request.getParameter("birth") !=null){
				try {
					Date birthdate = dateFormat.parse(request.getParameter("birth"));
					userDetails = new UserDetails(UUIDProvider.UUIDProduct(), user.getUid(), 1, new Date(), birthdate);
				} catch (ParseException e) {
					userDetails = new UserDetails(UUIDProvider.UUIDProduct(), user.getUid(), 1, new Date(), new Date());
				}
			}else{
				userDetails = new UserDetails(UUIDProvider.UUIDProduct(), user.getUid(), 1, new Date(), new Date());
			};
			RequestToBean.populate(request, userDetails);
			System.out.println(userDetails);
			
			IUserBiz iUserBiz = new UserBizImpl();
			boolean flag = iUserBiz.fastRegister(user);
			boolean flag2 = iUserBiz.detailsRegister(userDetails);
			
			if(flag){
				if(flag2){
					response.sendRedirect("login?resCode=501");
				}else{
					response.sendRedirect("login?resCode=502");
				}
				
			}else{
				RequestDispatcher dispatcher = request.getRequestDispatcher("register?resCode=502");
				dispatcher.forward(request, response);
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
