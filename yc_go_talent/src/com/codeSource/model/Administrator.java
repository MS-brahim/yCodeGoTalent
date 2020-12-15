package com.codeSource.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.codeSource.config.Config;

import java.util.List;

public class Administrator extends User {
	
	private String password;
	
	Config config = new Config();
	
	public Administrator() {
		super();
		try {
			config.connect();
		} catch (Exception e) {
			e.getMessage();
		}
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
	
	public void adminConnect(String emailInput, String passInput) throws Exception {
		
		String sql ="SELECT users.*,administrator.password "
				+ "FROM users "
				+ "INNER JOIN administrator "
				+ "ON id_user = administrator.id_user "
				+ "WHERE email='"+emailInput+"' AND password='"+passInput+"'";
				
		ResultSet result = config.getStatement().executeQuery(sql);
		if(result.next()) {
			/*sql = "UPDATE adminsession "
					+ "INNER JOIN users "
					+ "ON  id_administrator = users.id "
					+ "SET adminsession.is_connected = true";*/
			
			String fname = result.getString("first_name");
			String lname = result.getString("last_name");
			
			System.out.println("u-Users");
			System.out.println("p-Participations");
			System.out.println("f-Find Participation By User Email");
			System.out.println("v-Validate Participation");
			
		}else {
			System.out.println("Email and password inccorect!! Enter 1 try Again");
		}
	} 
	
	public void findParticipations() throws SQLException{

		String sql = "SELECT participation.*,users.*,category.name "
				+ "FROM participation "
				+ "INNER JOIN users "
				+ "ON id_user= users.id "
				+ "INNER JOIN category "
				+ "ON id_category = category.id";
		
		ResultSet resultSet = config.getStatement().executeQuery(sql);
		String leftAlignFormat = "| %-14s | %-14s | %-30s | %-20s | %-12s | %-20s | %-20s | %-20s | %-20s |%n";
		
		System.out.format("+----------------+------------------+-----------------------+--------------------+--------------------+---------------------------+-----------------+------------------+--------------------+-------------+%n");
		System.out.format("|   first name   ||    last name  ||   	 Email			||  	  Phone      ||  	    Name       	 ||      	 Start Date   	 || 	End Date   || 	Description   ||	 	File	   || 	Status   |%n");
		System.out.format("+----------------+------------------+-----------------------+--------------------+--------------------+---------------------------+-----------------+------------------+--------------------+-------------+%n");
		while (resultSet.next()) {		
		    System.out.format(leftAlignFormat, resultSet.getString("first_name"), resultSet.getString("last_name"), 
		    		resultSet.getString("email"), resultSet.getString("phone"), resultSet.getString("name"), 
		    		resultSet.getDate("show_start_date"), resultSet.getDate("show_end_date"));
		}
		System.out.format("+----------------+------------------+-----------------------+--------------------+--------------------+---------------------------+-----------------+------------------+--------------------+-------------+%n");
	}
}
