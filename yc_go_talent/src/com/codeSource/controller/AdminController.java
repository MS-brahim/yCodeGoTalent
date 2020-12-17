package com.codeSource.controller;

import javax.mail.PasswordAuthentication;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.codeSource.config.Config;
import com.codeSource.model.AdminSession;
import com.codeSource.model.Participation;
import com.codeSource.model.User;

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
				
				
				if (new AdminSession().isConnected()==false) {
					
					String sqlSession = "UPDATE adminsession SET is_connected = true WHERE id_administrator = '"+idAdmin+"'";
					config.getStatement().executeUpdate(sqlSession);
					System.out.println("______________________________________________");
					System.out.println("Admin Connected Success : " +fname+" "+lname);
					System.out.println("______________________________________________");
					
					System.out.println("u-Users");
					System.out.println("p-Participations");
					System.out.println("f-Find Participation By User Email");
					System.out.println("v-Validate Participation");
					System.out.println("d-Deconnect");
				}
					
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
	
	public void validateParticipation() throws SQLException, AddressException, MessagingException {
		
		 System.out.println("Category ID :");
	     int idCat =  new Scanner(System.in).nextInt();
	     System.out.println("User ID :");
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
	             
	             //admin.SendMail("stmp.gmail.com", "465", "fromEmail", "mdp", "toEmail", "ok", "message");
	             
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
	
	public void adminDeconnect() throws Exception {
		
		String sqlSession = "UPDATE adminsession SET is_connected = false ";
		config.getStatement().executeUpdate(sqlSession);
		System.out.println("Admin Deconnected Success");
	}
	
	public void SendMail(String server,String port,String username,String password,String to,
			String subject,String msg) throws AddressException, MessagingException {
		
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.host", server);
		prop.put("mail.smtp.port", port);
		Session session = Session.getInstance(prop, new Authenticator() {
			
		    @Override
		    protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
		        return new PasswordAuthentication(username, password);
		    }
		});
		try {
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(
			  Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject(subject);

			MimeBodyPart mimeBodyPart = new MimeBodyPart();
			mimeBodyPart.setContent(msg, "text/html");

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(mimeBodyPart);

			message.setContent(multipart);
			Transport.send(message);
			System.out.println("Send Message Success");
		} catch (Exception e) {
			e.getMessage();
		}
		
		
			
	}
}
