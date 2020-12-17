<<<<<<< HEAD:YoucodeTalents/src/com/youcode/models/User.java
package com.youcode.models;
=======
package com.codeSource.model;

import com.codeSource.config.Config;
>>>>>>> BRAHIM:yc_go_talent/src/com/codeSource/model/User.java

public class User {
	Config config = new Config();
	
	protected Long id;
	protected String last_name;
	protected String first_name;
	protected String email;
	protected String phone;
	
	public User() {
		super();
		try {
			config.connect();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public User(long id, String first_name, String last_name, String email, String phone) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phone = phone;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
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

	public void setEmail(String email) {
		this.email = email;
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
}
