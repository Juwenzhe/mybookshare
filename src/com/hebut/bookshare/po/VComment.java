package com.hebut.bookshare.po;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class VComment implements Serializable {

	private String commentid;
	private Date commentime;
	private String commentext;
	private double commentscore;
	private String username;
	private String bookname;
	private String bookid;
	public VComment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VComment(String commentid, Date commentime, String commentext, double commentscore, String username,
			String bookname, String bookid) {
		super();
		this.commentid = commentid;
		this.commentime = commentime;
		this.commentext = commentext;
		this.commentscore = commentscore;
		this.username = username;
		this.bookname = bookname;
		this.bookid = bookid;
	}
	@Override
	public String toString() {
		return "VComment [commentid=" + commentid + ", commentime=" + commentime + ", commentext=" + commentext
				+ ", commentscore=" + commentscore + ", username=" + username + ", bookname=" + bookname + ", bookid="
				+ bookid + "]";
	}
	public String getCommentid() {
		return commentid;
	}
	public void setCommentid(String commentid) {
		this.commentid = commentid;
	}
	public Date getCommentime() {
		return commentime;
	}
	public void setCommentime(Date commentime) {
		this.commentime = commentime;
	}
	public String getCommentext() {
		return commentext;
	}
	public void setCommentext(String commentext) {
		this.commentext = commentext;
	}
	public double getCommentscore() {
		return commentscore;
	}
	public void setCommentscore(double commentscore) {
		this.commentscore = commentscore;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getBookid() {
		return bookid;
	}
	public void setBookid(String bookid) {
		this.bookid = bookid;
	}
}
