package com.hebut.bookshare.po;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Record implements Serializable {

	private String recordid;
	private String uid;
	private String record;
	private Date time;
	public Record() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Record(String recordid, String uid, String record, Date time) {
		super();
		this.recordid = recordid;
		this.uid = uid;
		this.record = record;
		this.time = time;
	}
	@Override
	public String toString() {
		return "Record [recordid=" + recordid + ", uid=" + uid + ", record=" + record + ", time=" + time + "]";
	}
	public String getRecordid() {
		return recordid;
	}
	public void setRecordid(String recordid) {
		this.recordid = recordid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getRecord() {
		return record;
	}
	public void setRecord(String record) {
		this.record = record;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
}
