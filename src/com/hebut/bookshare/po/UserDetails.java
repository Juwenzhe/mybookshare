package com.hebut.bookshare.po;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

@SuppressWarnings("serial")
public class UserDetails implements Serializable {

	private String detaid;
	private String uid;
	private int level;
	private int resmoney;
	private int userscore;
	private String truename;
	private String cityaddress;
	private Date registime;
	private String job;
	private String question;
	private Date birthday;
	private String[] hobby;
	private Record record;
	
	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserDetails(String detaid, String uid, int level, Date registime) {
		super();
		this.detaid = detaid;
		this.uid = uid;
		this.level = level;
		this.registime = registime;
	}

	
	public UserDetails(String detaid, String uid, int level, Date registime, Date birthday) {
		super();
		this.detaid = detaid;
		this.uid = uid;
		this.level = level;
		this.registime = registime;
		this.birthday = birthday;
	}

	public UserDetails(String detaid, String uid, int level, int resmoney, int userscore, String truename,
			String cityaddress, Date registime, String job, String question, Date birthday, String[] hobby,
			Record record) {
		super();
		this.detaid = detaid;
		this.uid = uid;
		this.level = level;
		this.resmoney = resmoney;
		this.userscore = userscore;
		this.truename = truename;
		this.cityaddress = cityaddress;
		this.registime = registime;
		this.job = job;
		this.question = question;
		this.birthday = birthday;
		this.hobby = hobby;
		this.record = record;
	}

	public String getDetaid() {
		return detaid;
	}
	public void setDetaid(String detaid) {
		this.detaid = detaid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getResmoney() {
		return resmoney;
	}
	public void setResmoney(int resmoney) {
		this.resmoney = resmoney;
	}
	public int getUserscore() {
		return userscore;
	}
	public void setUserscore(int userscore) {
		this.userscore = userscore;
	}
	public String getTruename() {
		return truename;
	}
	public void setTruename(String truename) {
		this.truename = truename;
	}
	public String getCityaddress() {
		return cityaddress;
	}
	public void setCityaddress(String cityaddress) {
		this.cityaddress = cityaddress;
	}
	public Date getRegistime() {
		return registime;
	}
	public void setRegistime(Date registime) {
		this.registime = registime;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String[] getHobby() {
		return hobby;
	}
	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}
	public Record getRecord() {
		return record;
	}
	public void setRecord(Record record) {
		this.record = record;
	}
	@Override
	public String toString() {
		return "UserDetails [detaid=" + detaid + ", uid=" + uid + ", level=" + level + ", resmoney=" + resmoney
				+ ", userscore=" + userscore + ", truename=" + truename + ", cityaddress=" + cityaddress
				+ ", registime=" + registime + ", job=" + job + ", question=" + question + ", birthday=" + birthday
				+ ", hobby=" + Arrays.toString(hobby) + ", record=" + record + "]";
	}
}
