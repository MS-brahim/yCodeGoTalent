package com.codeSource.model;

public class Administrator extends User {
	
	private String password;
		
	public Administrator() {
		super();
	}

	public Administrator(long id, String first_name, String last_name, String email, String phone, String password) {
		super(id, first_name, last_name, email, phone);
		this.setPassword(password);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
