package com.hebut.bookshare.biz;

import java.util.List;

import com.hebut.bookshare.po.Category;

public interface ICateBiz {

	public abstract List<Category> findAllcates();
	public abstract String findCateId(String catename);
}
