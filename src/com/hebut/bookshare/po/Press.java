package com.hebut.bookshare.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Press implements Serializable {

	private String pressid;
	private String pressname;
	private String pressaddress;
	private String pressdescription;
	public Press() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Press(String pressid, String pressname) {
		super();
		this.pressid = pressid;
		this.pressname = pressname;
	}

	@Override
	public String toString() {
		return "Press [pressid=" + pressid + ", pressname=" + pressname + ", pressaddress=" + pressaddress
				+ ", pressdescription=" + pressdescription + "]";
	}
	public Press(String pressid, String pressname, String pressaddress, String pressdescription) {
		super();
		this.pressid = pressid;
		this.pressname = pressname;
		this.pressaddress = pressaddress;
		this.pressdescription = pressdescription;
	}
	public String getPressid() {
		return pressid;
	}
	public void setPressid(String pressid) {
		this.pressid = pressid;
	}
	public String getPressname() {
		return pressname;
	}
	public void setPressname(String pressname) {
		this.pressname = pressname;
	}
	public String getPressaddress() {
		return pressaddress;
	}
	public void setPressaddress(String pressaddress) {
		this.pressaddress = pressaddress;
	}
	public String getPressdescription() {
		return pressdescription;
	}
	public void setPressdescription(String pressdescription) {
		this.pressdescription = pressdescription;
	}
	
}
