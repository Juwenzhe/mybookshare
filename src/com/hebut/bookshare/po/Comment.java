package com.hebut.bookshare.po;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class Comment implements Serializable {

	private String bookid;
	private List<VComment> lstSinComments;
	private double bookscore;
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Comment(String bookid, List<VComment> lstSinComments) {
		super();
		this.bookid = bookid;
		this.lstSinComments = lstSinComments;
		double totalScore = 0.0;
		for (VComment vComment : lstSinComments) {
			totalScore+=vComment.getCommentscore();
		}
		this.bookscore = totalScore/lstSinComments.size();
	}
	
	public String getBookid() {
		return bookid;
	}
	public void setBookid(String bookid) {
		this.bookid = bookid;
	}
	public List<VComment> getLstSinComments() {
		return lstSinComments;
	}
	public void setLstSinComments(List<VComment> lstSinComments) {
		this.lstSinComments = lstSinComments;
	}
	public double getBookscore() {
		return bookscore;
	}
	
	@Override
	public String toString() {
		return "Comment [bookid=" + bookid + ", lstSinComments=" + lstSinComments + ", bookscore="
				+ bookscore + "]";
	}
}
