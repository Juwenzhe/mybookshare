package com.hebut.bookshare.po;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class SingleComment implements Serializable {

	private String commentid;
	private Date commentime;
	private String commentext;
	private double commentscore;
	private String uid;
	private String bookid;
	private String comid;
	public SingleComment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SingleComment(String commentid, Date commentime, String commentext, double commentscore, String uid,
			String bookid, String comid) {
		super();
		this.commentid = commentid;
		this.commentime = commentime;
		this.commentext = commentext;
		this.commentscore = commentscore;
		this.uid = uid;
		this.bookid = bookid;
		this.comid = comid;
	}
	
	public SingleComment(String commentid, Date commentime, String commentext, double commentscore, String uid,
			String bookid) {
		super();
		this.commentid = commentid;
		this.commentime = commentime;
		this.commentext = commentext;
		this.commentscore = commentscore;
		this.uid = uid;
		this.bookid = bookid;
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
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getBookid() {
		return bookid;
	}
	public void setBookid(String bookid) {
		this.bookid = bookid;
	}
	public String getComid() {
		return comid;
	}
	public void setComid(String comid) {
		this.comid = comid;
	}
	@Override
	public String toString() {
		return "SingleComment [commentid=" + commentid + ", commentime=" + commentime + ", commentext=" + commentext
				+ ", commentscore=" + commentscore + ", uid=" + uid + ", bookid=" + bookid + ", comid=" + comid + "]";
	}
	
}
