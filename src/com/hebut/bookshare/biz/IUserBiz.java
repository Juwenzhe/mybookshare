package com.hebut.bookshare.biz;

import java.util.Date;

import com.hebut.bookshare.po.User;
import com.hebut.bookshare.po.UserDetails;

public interface IUserBiz {

	public abstract User loginBiz(String username,String password);
	public abstract boolean testUserName(String username);
	public abstract boolean fastRegister(User user);
	public abstract boolean detailsRegister(UserDetails details);
	public abstract int findUserCntByDate(Date date);
	
}
