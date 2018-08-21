package com.pojo;

import java.sql.Date;

public class Relative {
	private int id;
	private String account;
	private String name;
	private int phone;
	private Date date;
	private String Remarks;
	private String oldman;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getRemarks() {
		return Remarks;
	}

	public void setRemarks(String remarks) {
		Remarks = remarks;
	}

	public String getOldman() {
		return oldman;
	}

	public void setOldman(String oldman) {
		this.oldman = oldman;
	}

}
