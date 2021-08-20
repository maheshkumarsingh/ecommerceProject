package com.app.model;

public class User {
	private int userid;
	private String userEmail;
	private String userpass;
	private String fname;
	private String lname;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int userid, String userEmail, String userpass, String fname, String lname) {
		super();
		this.userid = userid;
		this.userEmail = userEmail;
		this.userpass = userpass;
		this.fname = fname;
		this.lname = lname;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserpass() {
		return userpass;
	}

	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", userEmail=" + userEmail + " firstname=" + fname + ", lastname=" + lname
				+ "]";
	}

}