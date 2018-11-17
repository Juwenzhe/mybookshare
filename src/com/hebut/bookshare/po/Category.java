package com.hebut.bookshare.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Category implements Serializable {

	private String cateid;
	private String catename;
	private String catedescription;
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(String cateid, String catename, String catedescription) {
		super();
		this.cateid = cateid;
		this.catename = catename;
		this.catedescription = catedescription;
	}
	public String getCateid() {
		return cateid;
	}
	public void setCateid(String cateid) {
		this.cateid = cateid;
	}
	public String getCatename() {
		return catename;
	}
	public void setCatename(String catename) {
		this.catename = catename;
	}
	public String getCatedescription() {
		return catedescription;
	}
	public void setCatedescription(String catedescription) {
		this.catedescription = catedescription;
	}
	@Override
	public String toString() {
		return "Category [cateid=" + cateid + ", catename=" + catename + ", catedescription=" + catedescription + "]";
	}
	
}
