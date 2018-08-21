package com.pojo;

public class User {
	private int id;
	private String account;
	private String password;
	private String jueseid;
	
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getJueseid() {
		return jueseid;
	}
	public void setJueseid(String jueseid) {
		this.jueseid = jueseid;
	}
	public String toString() {
		return "User [id=" + id + ", account=" + account + ", password=" + password + ", jueseid=" + jueseid
				+ "]";
	}
}
