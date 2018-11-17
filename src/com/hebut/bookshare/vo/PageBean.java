package com.hebut.bookshare.vo;

import java.util.ArrayList;
import java.util.List;

public class PageBean {

	private int totalRows;
	private int totalPages;
	private int currentPage;
	private int pageSize;
	@SuppressWarnings("rawtypes")
	private List data = new ArrayList();
	public PageBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageBean(int totalRows, int totalPages, int currentPage, int pageSize, @SuppressWarnings("rawtypes") List data) {
		super();
		this.totalRows = totalRows;
		this.totalPages = totalRows%pageSize==0?(totalRows/pageSize):(totalRows/pageSize+1);
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.data = data;
	}
	
	public int getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages() {
		this.totalPages = totalRows%pageSize==0?(totalRows/pageSize):(totalRows/pageSize+1);
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	@SuppressWarnings("rawtypes")
	public List getData() {
		return data;
	}
	@SuppressWarnings("rawtypes")
	public void setData(List data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "PageBean [totalRows=" + totalRows + ", totalPages=" + totalPages + ", currentPage=" + currentPage
				+ ", pageSize=" + pageSize + ", data=" + data + "]";
	}
	
	
}
