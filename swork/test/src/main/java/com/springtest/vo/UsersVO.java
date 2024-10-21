package com.springtest.vo;

public class UsersVO {
	private String id = null;
	private String password = null;
	private String name = null;
	private String role = null;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UsersVO [id=" + id + ", password=" + password + ", name=" + name + ", role=" + role + "]";
	}
}