package com.codeSource.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.codeSource.config.Config;
import com.codeSource.model.Participation;
import com.codeSource.model.User;
import java.util.List;


public class AdminController {
	
	Config config = new Config();
	
	public AdminController() {
		try {
			config.connect();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void adminConnect() throws Exception {
		
		System.out.println("Enter Your Email : ");
		String email =  new Scanner(System.in).nextLine();
		
		System.out.println("Enter Your Password : ");
		String password =  new Scanner(System.in).nextLine();
		
		if (email.isEmpty() && password.isEmpty()) {
			System.out.println("Please Enter Your Email And Password!!");
		}else {	
		
			String sql ="SELECT users.*,administrator.* "
					+ "FROM users "
					+ "INNER JOIN administrator "
					+ "ON id_user = administrator.id_user "
					+ "WHERE email='"+email+"' AND password='"+password+"'";
					
			ResultSet result = config.getStatement().executeQuery(sql);
			if(result.next()) {
				long idAdmin = result.getLong("id_user");
				String fname = result.getString("first_name");
				String lname = result.getString("last_name");
				
				
				 //String sqlSession = "UPDATE adminsession SET is_connected = true WHERE id_administrator = '"+idAdmin+"'";
				 //config.getStatement().executeQuery(sqlSession);
				 System.out.println("Save Connected!");
					
				
				System.out.println("Admin : " +fname+" "+lname+" "+idAdmin);
					
				System.out.println("_________________________________");
				System.out.println("u-Users");
				System.out.println("p-Participations");
				System.out.println("f-Find Participation By User Email");
				System.out.println("v-Validate Participation");
				
			}else {
				System.out.println("Email and password inccorect!! Enter 1 try Again");
			}
		}
	} 
	
	public List<User> findAllUsers() throws SQLException {
		
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
		return null;
	}

	public List<Participation> findParticipations() throws SQLException{
		
		String sql = "SELECT participation.*,category.name "
				+ "FROM participation "
				+ "INNER JOIN category "
				+ "ON id_category = category.id";
		
		ResultSet resultSet = config.getStatement().executeQuery(sql);
		String leftAlignFormat = "|  %-10s	|  %-15s	|  %-15s	|  %-25s	|  %-15s	|  %-5s	|%n";
		
		System.out.format("+---------------+-----------------------+-----------------------+-------------------------------+-----------------------+---------------+%n");
		System.out.format("|     Name	|	Start Date	|	End Date	|	Description		|	File		|  Status	|%n");
		System.out.format("+---------------+-----------------------+-----------------------+-------------------------------+-----------------------+---------------+%n");
		while (resultSet.next()) {		
		    System.out.format(leftAlignFormat, resultSet.getString("name"), 
		    		resultSet.getTime("show_start_time"),	resultSet.getTime("show_end_time"),
		    		resultSet.getString("description"),	resultSet.getString(6),	
		    		resultSet.getBoolean("is_accepted"));
		    System.out.format("+---------------+-----------------------+-----------------------+-------------------------------+-----------------------+---------------+%n");
		}
		return null;
	}
	
	public Participation findParticipationByEmail() throws SQLException{
		System.out.println("Search in Participation By Email : ");
		String email = new Scanner(System.in).nextLine();
		
		if (email.isEmpty()) {
			System.out.println("Please enter a search email");
		}else {
			String sql = "SELECT participation.*,users.*,category.* "
					+ "FROM participation "
					+ "INNER JOIN users "
					+ "ON id_user= users.id "
					+ "INNER JOIN category "
					+ "ON id_category = category.id "
					+ "WHERE email ='"+email+"'";
			
			ResultSet resultSet = config.getStatement().executeQuery(sql);
			String leftAlignFormat = "| %-14s | %-14s | %-30s | %-20s | %-12s | %-18s | %-18s | %-29s | %-11s | %-9s |%n";
			
			System.out.format("+----------------+-----------------+-------------------------------+---------------------+--------------+--------------------+--------------------+-------------------------------+--------------+-----------+%n");
			System.out.format("|   first name   ||    last name  ||   	     Email	     	  ||  	    Phone        ||   Name      ||    Start Date     ||     End Date      ||  	     Description       	  ||	 File    ||  Status  |%n");
			System.out.format("+----------------+-----------------+-------------------------------+---------------------+--------------+--------------------+--------------------+-------------------------------+--------------+-----------+%n");
	
			if(resultSet.next()) {		
			    System.out.format(leftAlignFormat, resultSet.getString("first_name"), resultSet.getString("last_name"), 
			    		resultSet.getString("email"), resultSet.getString("phone"), resultSet.getString("name"), 
			    		resultSet.getTime("show_start_time"),	resultSet.getTime("show_end_time"), resultSet.getString("description"), 
			    		resultSet.getString(6),	resultSet.getBoolean("is_accepted"));
			    System.out.format("+----------------+-----------------+-------------------------------+---------------------+--------------+--------------------+--------------------+-------------------------------+--------------+-----------+%n");

			}else {
				System.out.println("No user is here for this email");
			}
		}
		return null;
	}
	
	public void validateParticipation() throws SQLException {
		
		 System.out.println("id category");
	     int idCat =  new Scanner(System.in).nextInt();
	     System.out.println("id user");
	     int idUser =  new Scanner(System.in).nextInt();

	     String sql = "SELECT * FROM participation WHERE id_user='"+idUser+"' AND id_category='"+idCat+"'";
	     ResultSet resultSet = config.getStatement().executeQuery(sql);

	     if(resultSet.next()) {

	    	 System.out.println("To accept Write (1)");
	    	 System.out.println("To Cancel Write (0)");
	    	 
	         int validInput = new Scanner(System.in).nextInt();
	         switch(validInput) {
	         case 1:
	        	 String sql2 = "UPDATE participation SET  is_accepted=true WHERE id_user='"+idUser+"' AND id_category='"+idCat+"'";
		            
	             config.getStatement().executeUpdate(sql2);
	             System.out.println("Participation Was Accepted");
	        	 break;
	        	 
	         case 0:
	        	 String sql3 = "UPDATE participation SET  is_accepted = false WHERE id_user='"+idUser+"' AND id_category='"+idCat+"'";
	             config.getStatement().executeUpdate(sql3);
	             System.out.println("Participation Was refused");
	        	 break;
	         }
	     }else {
	    	 System.out.println("Error");
	     }
	}
}
