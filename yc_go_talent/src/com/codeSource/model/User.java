package com.codeSource.model;

import com.codeSource.config.Config;

public class User {
	Config config = new Config();
	
	private long id;
	private String firstname;
	private String lastname;
	private String email;
	private String phone;
	
	public User() {
		super();
		try {
			config.connect();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public User(long id, String firstname, String lastname, String email, String phone) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
