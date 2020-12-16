package com.codeSource.model;

public class Administrator extends User {
	
	private String password;
		
	public Administrator() {
		super();
	}

	public Administrator(long id, String firstname, String lastname, String email, String phone, String password) {
		super(id, firstname, lastname, email, phone);
		this.setPassword(password);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
