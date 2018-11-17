package com.hebut.bookshare.po;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Book implements Serializable {

	private String bookid;
	private String name;
	private double bookprice;
	private String bookshareuid;
	private String booksharelvl;
	private String categoryid;
	private String photoid;
	private String pressid;
	private int downloadcnt;
	private String available;
	private Date booksharetime;
	private double bookscore;
	private String bookdescription;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Book(String bookid, String bookshareuid, String booksharelvl, String categoryid, String photoid,
			String pressid, int downloadcnt, String available, Date booksharetime) {
		super();
		this.bookid = bookid;
		this.bookshareuid = bookshareuid;
		this.booksharelvl = booksharelvl;
		this.categoryid = categoryid;
		this.photoid = photoid;
		this.pressid = pressid;
		this.downloadcnt = downloadcnt;
		this.available = available;
		this.booksharetime = booksharetime;
	}



	public Book(String bookid, String name, double bookprice, String bookshareuid, String booksharelvl,
			String categoryid, String photoid, String pressid, int downloadcnt, String available, Date booksharetime,
			double bookscore, String bookdescription) {
		super();
		this.bookid = bookid;
		this.name = name;
		this.bookprice = bookprice;
		this.bookshareuid = bookshareuid;
		this.booksharelvl = booksharelvl;
		this.categoryid = categoryid;
		this.photoid = photoid;
		this.pressid = pressid;
		this.downloadcnt = downloadcnt;
		this.available = available;
		this.booksharetime = booksharetime;
		this.bookscore = bookscore;
		this.bookdescription = bookdescription;
	}
	public String getBookid() {
		return bookid;
	}
	public void setBookid(String bookid) {
		this.bookid = bookid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBookprice() {
		return bookprice;
	}
	public void setBookprice(double bookprice) {
		this.bookprice = bookprice;
	}
	public String getBookshareuid() {
		return bookshareuid;
	}
	public void setBookshareuid(String bookshareuid) {
		this.bookshareuid = bookshareuid;
	}
	public String getBooksharelvl() {
		return booksharelvl;
	}
	public void setBooksharelvl(String booksharelvl) {
		this.booksharelvl = booksharelvl;
	}
	public String getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(String categoryid) {
		this.categoryid = categoryid;
	}
	public String getPhotoid() {
		return photoid;
	}
	public void setPhotoid(String photoid) {
		this.photoid = photoid;
	}
	public String getPressid() {
		return pressid;
	}
	public void setPressid(String pressid) {
		this.pressid = pressid;
	}
	public int getDownloadcnt() {
		return downloadcnt;
	}
	public void setDownloadcnt(int downloadcnt) {
		this.downloadcnt = downloadcnt;
	}
	public String getAvailable() {
		return available;
	}
	public void setAvailable(String available) {
		this.available = available;
	}
	public Date getBooksharetime() {
		return booksharetime;
	}
	public void setBooksharetime(Date booksharetime) {
		this.booksharetime = booksharetime;
	}
	public double getBookscore() {
		return bookscore;
	}
	public void setBookscore(double bookscore) {
		this.bookscore = bookscore;
	}
	public String getBookdescription() {
		return bookdescription;
	}
	public void setBookdescription(String bookdescription) {
		this.bookdescription = bookdescription;
	}
	@Override
	public String toString() {
		return "Book [bookid=" + bookid + ", name=" + name + ", bookprice=" + bookprice + ", bookshareuid="
				+ bookshareuid + ", booksharelvl=" + booksharelvl + ", categoryid=" + categoryid + ", photoid="
				+ photoid + ", pressid=" + pressid + ", downloadcnt=" + downloadcnt + ", available=" + available
				+ ", booksharetime=" + booksharetime + ", bookscore=" + bookscore + ", bookdescription="
				+ bookdescription + "]";
	}
	
}
