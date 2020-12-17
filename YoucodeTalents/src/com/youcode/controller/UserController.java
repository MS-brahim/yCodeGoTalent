package com.youcode.controller;


import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

import com.youcode.config.Config;
import com.youcode.models.User;


public class UserController extends User{
	
	Config config;
	Scanner scanner;
	Connection connection;
	public UserController(Long id, String first_name, String last_name, String email, String phone) throws SQLException {
		super(id, first_name, last_name, email, phone);
		
	}
	public UserController() throws SQLException {
		config = new Config("jdbc:mysql://localhost:3308/youcodetalent","root","");
		scanner = new Scanner(System.in);
		  connection = config.connect();

	}
	
	public void display() throws SQLException {
		
		String query = "Select * from users";
		Statement statement = config.connect().createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		String leftAlignFormat = "| %-15s | %-15s | %-15s | %-15s | %-15s |%n";
		
		System.out.format("+-----------------+-----------------------------------------------------+%n");
		System.out.format("|       ID        ||      First_name      ||  last_Name   ||      Email     ||       Phone     |%n");
		System.out.format("+-----------------+-----------------------------------------------------+%n");
		
		while (resultSet.next()) {
			
			    System.out.format(leftAlignFormat, resultSet.getLong("id"), resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getString("email"), resultSet.getString("phone"));

			}
			
			System.out.format("+---------------------------------+-------------------------------------+%n");
			//			
		}
	
	  
	  public void add() throws SQLException {
		  
		  //Random Id 
		  
		  Random rd = new Random();
          long id = (long)(rd.nextDouble()*1000000000L);
		  
		  System.out.println("Enter the First_name");
		  this.first_name = scanner.next();
		  
		  System.out.println("Enter the Last_name");
		  this.last_name = scanner.next();
		  System.out.println("Enter the Email");
		  this.email = scanner.next();
		  System.out.println("Enter the Phone");
		  this.phone = scanner.next();
		  
		  String sqlString = "INSERT into users (id, first_name,last_name, email, phone)" + " values(?,?,?,?,?)";
		  
		  java.sql.PreparedStatement statement = config.connect().prepareStatement(sqlString, Statement.RETURN_GENERATED_KEYS);
		  	statement.setLong(1, id);
			statement.setString(2, this.first_name);
			statement.setString(3, this.last_name);
			statement.setString(4, this.email);
			statement.setString(5, this.phone);
			statement.executeUpdate();
		 
		System.out.println("User added: " +id);
	  }
	  
	  public User finUserById() throws SQLException, ClassNotFoundException {
		  
		  
			
	        
		  
		  System.out.println("Enter the id user that you want");
		  
		  long id = scanner.nextLong();
		  
		  
	        
	       
		  String sqlString = "SELECT * FROM users WHERE id=?";
		  java.sql.PreparedStatement statement = config.connect().prepareStatement(sqlString);
		  statement.setLong(1, id);
		  User user = new User();
		  ResultSet resultSet = statement.executeQuery();
		  
		  if(resultSet.next()) {
			  
			  user.setId(id);
			  user.setFirst_name(resultSet.getString("first_name"));
			  user.setLast_name(resultSet.getString("last_name"));
			  user.setEmail(resultSet.getString("email"));
			  user.setPhone(resultSet.getString("phone"));
			  
			  
		  } else {
			  System.out.println("Not existe");
			  
			  finUserById();
			  
		  } 

		
		return user; 
		  
	  }

	  
	  public void update() throws ClassNotFoundException, SQLException {
			
			
		  System.out.println("Enter your id:");
		  String idstring = scanner.nextLine();
		  long id = Long.parseLong(idstring);
		  System.out.println("Enter your first name:");
		  String first_name = scanner.nextLine();
		  System.out.println("Enter your last name:");
		  String last_name = scanner.nextLine();
		  System.out.println("Enter your email:");
		  String email = scanner.nextLine();
		  System.out.println("Enter your phone number:");
		  String phone = scanner.nextLine();
		  String sqlString = "update  users SET  first_name=?, last_name=?, email=?, phone=? WHERE id=?";
		  java.sql.PreparedStatement statement = connection.prepareStatement(sqlString);
			statement.setString(1, first_name);
			statement.setString(2, last_name);
			statement.setString(3, email);
			statement.setString(4, phone );
			statement.setLong(5, id);
			statement.executeUpdate();
		 
		System.out.println("Your informations are successfully updated");
	
		
		
	}
	  
	
		 
		public void delete() throws SQLException {
			
			 System.out.println("Enter the id");
			  this.id = scanner.nextLong(); 
			  String sqlString = "delete from  users"+ " WHERE id=?";
			  java.sql.PreparedStatement statement = config.connect().prepareStatement(sqlString);
				statement.setLong(1, this.id);
				statement.executeUpdate();
		  
			  System.out.println("Users Deleted");
			  


		}
		
		
		}
	
	
