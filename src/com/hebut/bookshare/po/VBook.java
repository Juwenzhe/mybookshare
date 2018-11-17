package com.hebut.bookshare.po;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class VBook implements Serializable {

	private String bookid;
	private String bookname;
	private double bookprice;
	private String bookshareuser;
	private String booksharelvl;//免费还是不免费？
	private String category;
	private String photoid;
	private String press;
	private double score;//评分
	private int downloadcnt;
	private String avaliable;//是否通过了审核？
	private Date booksharetime;
	private double bookscore;//积分价
	private String bookdescription;
	public VBook() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VBook(String bookid, String bookname, double bookprice, String bookshareuser, String booksharelvl,
			String category, String photoid, String press, double score, int downloadcnt, String avaliable,
			Date booksharetime, double bookscore, String bookdescription) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.bookprice = bookprice;
		this.bookshareuser = bookshareuser;
		this.booksharelvl = booksharelvl;
		this.category = category;
		this.photoid = photoid;
		this.press = press;
		this.score = score;
		this.downloadcnt = downloadcnt;
		this.avaliable = avaliable;
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
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public double getBookprice() {
		return bookprice;
	}
	public void setBookprice(double bookprice) {
		this.bookprice = bookprice;
	}
	public String getBookshareuser() {
		return bookshareuser;
	}
	public void setBookshareuser(String bookshareuser) {
		this.bookshareuser = bookshareuser;
	}
	public String getBooksharelvl() {
		return booksharelvl;
	}
	public void setBooksharelvl(String booksharelvl) {
		this.booksharelvl = booksharelvl;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPhotoid() {
		return photoid;
	}
	public void setPhotoid(String photoid) {
		this.photoid = photoid;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public int getDownloadcnt() {
		return downloadcnt;
	}
	public void setDownloadcnt(int downloadcnt) {
		this.downloadcnt = downloadcnt;
	}
	public String getAvaliable() {
		return avaliable;
	}
	public void setAvaliable(String avaliable) {
		this.avaliable = avaliable;
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
		return "VBook [bookid=" + bookid + ", bookname=" + bookname + ", bookprice=" + bookprice + ", bookshareuser="
				+ bookshareuser + ", booksharelvl=" + booksharelvl + ", category=" + category + ", photoid=" + photoid
				+ ", press=" + press + ", score=" + score + ", downloadcnt=" + downloadcnt + ", avaliable=" + avaliable
				+ ", booksharetime=" + booksharetime + ", bookscore=" + bookscore + ", bookdescription="
				+ bookdescription + "]";
	}
}
