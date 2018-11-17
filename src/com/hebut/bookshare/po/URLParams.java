package com.hebut.bookshare.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class URLParams implements Serializable{

	private String searchbookname;
	private String searchpress;
	private String searchshareuser;
	private String minprice;
	private String maxprice;
	public URLParams() {
		super();
		// TODO Auto-generated constructor stub
	}
	public URLParams(String searchbookname, String searchpress, String searchshareuser, String minprice,
			String maxprice) {
		super();
		this.searchbookname = searchbookname;
		this.searchpress = searchpress;
		this.searchshareuser = searchshareuser;
		this.minprice = minprice;
		this.maxprice = maxprice;
	}
	public String getSearchbookname() {
		return searchbookname;
	}
	public void setSearchbookname(String searchbookname) {
		this.searchbookname = searchbookname;
	}
	public String getSearchpress() {
		return searchpress;
	}
	public void setSearchpress(String searchpress) {
		this.searchpress = searchpress;
	}
	public String getSearchshareuser() {
		return searchshareuser;
	}
	public void setSearchshareuser(String searchshareuser) {
		this.searchshareuser = searchshareuser;
	}
	public String getMinprice() {
		return minprice;
	}
	public void setMinprice(String minprice) {
		this.minprice = minprice;
	}
	public String getMaxprice() {
		return maxprice;
	}
	public void setMaxprice(String maxprice) {
		this.maxprice = maxprice;
	}
	@Override
	public String toString() {
		return "URLParams [searchbookname=" + searchbookname + ", searchpress=" + searchpress + ", searchshareuser="
				+ searchshareuser + ", minprice=" + minprice + ", maxprice=" + maxprice + "]";
	}
	
}
