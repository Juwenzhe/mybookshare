package com.hebut.bookshare.biz;

import java.util.List;

import com.hebut.bookshare.po.Press;

public interface IPressBiz {

	public abstract List<Press> findAllPress();
	public abstract Press findPressByPressName(String pressname);
	public abstract boolean addPress(Press press);
	
}
