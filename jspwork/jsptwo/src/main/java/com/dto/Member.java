package com.dto;

public class Member {
	private String id;
	private String passwd;

	public Member() {}

	public Member(String id, String passwd) {
		this.id = id;
		this.passwd = passwd;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	public Member login() {
		if (id.equals("admin") && passwd.equals("1234")) {
			return this;
		}
		return null;
	}
}