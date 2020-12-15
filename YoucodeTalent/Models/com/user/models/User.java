package com.user.models;

public class User {
	
	
	protected Long id;
	protected String last_name;
	protected String first_name;
	protected String email;
	protected String phone;
	
	public User() {
		
	}
	
	public  User(Long id, String first_name,String last_name,String email, String phone  ) {
		
		 this.id=id;
		 this.first_name=first_name;
		 this.last_name=last_name;
		 this.email=email;
		 this.phone=phone;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String First_name) {
		this.first_name = First_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		
		this.last_name = last_name;
		
	}

	public String getEmail() {
		return email;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		
		return "User [ id = " + id + ", first_name = " + first_name + ", last_name = " + last_name + ", email = " + email +", phone " + phone + "]";
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
