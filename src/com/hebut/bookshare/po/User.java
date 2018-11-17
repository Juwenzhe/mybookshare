package com.hebut.bookshare.po;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class User implements Serializable {

	private String uid;
	private String username;
	private String password;
	private Date lastlogintime;
	private String condtion;
	private String phone;
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String uid) {
		super();
		this.uid = uid;
	}

	public User(String uid, String username, String password) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
	}
	
	public Date getLastlogintime() {
		return lastlogintime;
	}

	public User(String uid, String username, String password, Date lastlogintime) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.lastlogintime = lastlogintime;
	}

	
	public User(String uid, String username, String password, String condtion, String phone) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.condtion = condtion;
		this.phone = phone;
	}

	public User(String uid, String username, String password, Date lastlogintime, String condtion, String phone) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.lastlogintime = lastlogintime;
		this.condtion = condtion;
		this.phone = phone;
	}

	public User(String uid, String username, String password, Date lastlogintime, String condtion) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.lastlogintime = lastlogintime;
		this.condtion = condtion;
	}

	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getCondtion() {
		return condtion;
	}

	public void setCondtion(String condtion) {
		this.condtion = condtion;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", lastlogintime="
				+ lastlogintime + ", condtion=" + condtion + "]";
	}

}
