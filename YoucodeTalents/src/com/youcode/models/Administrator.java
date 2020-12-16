package com.youcode.models;

public class Administrator extends User {

	private String password;

	public Administrator(Long id, String first_name, String last_name, String email, String phone, String password) {
		super(id, first_name, last_name, email, phone);
		this.password = password;
	}

//	public Administrator() {
//	}

	@Override
	public String toString() {
		return "Admin [password= " + password + "]";
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
}
