package com.codeSource.model;

import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	public void display() throws SQLException {
		
		String query = "SELECT * FROM users";
		ResultSet resultSet = config.getStatement().executeQuery(query);
		String leftAlignFormat = "| %-15s | %-18s | %-15s | %-30s | %-20s  	 |%n";
		
		System.out.format("+-----------------+------------------------------------------------------------------------------------------------------+%n");
		System.out.format("|       ID        ||    First_name    ||   last_Name    ||  	    Email       	 ||      	 Phone   	 |%n");
		System.out.format("+-----------------+------------------------------------------------------------------------------------------------------+%n");		
		while (resultSet.next()) {		
		    System.out.format(leftAlignFormat, resultSet.getLong("id"), resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getString("email"), resultSet.getString("phone"));
		}
		System.out.format("+-----------------+------------------------------------------------------------------------------------------------------+%n");
	}
	
//	 public void add() throws SQLException {
//		  
//		  //Random Id 
//		  Random rd = new Random();
//		  long id = (long)(rd.nextDouble()*1000000000L);
//		  
//		  System.out.println("Enter the First_name");
//		  this.first_name = scanner.next();
//		  
//		  System.out.println("Enter the Last_name");
//		  this.last_name = scanner.next();
//		  System.out.println("Enter the Email");
//		  this.email = scanner.next();
//		  System.out.println("Enter the Phone");
//		  this.phone = scanner.next();
//		  
//		  String sqlString = "INSERT into users (id, first_name,last_name, email, phone)" + " values(?,?,?,?,?)";
//		  
//		  java.sql.PreparedStatement statement = config.connect().prepareStatement(sqlString, Statement.RETURN_GENERATED_KEYS);
//		  	statement.setLong(1, id);
//			statement.setString(2, this.first_name);
//			statement.setString(3, this.last_name);
//			statement.setString(4, this.email);
//			statement.setString(5, this.phone);
//			statement.executeUpdate();
//		 
//		System.out.println("User added");;
//	  }
//	 
}
