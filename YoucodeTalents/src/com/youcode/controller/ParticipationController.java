package com.youcode.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;
import com.youcode.config.Config;



public class ParticipationController {

	Config config;
	Scanner scanner;
	Connection connection;
	
	
	public ParticipationController() throws ClassNotFoundException, SQLException {
		
		config = new Config("jdbc:mysql://localhost:3308/youcodetalent","root","");
		scanner = new Scanner(System.in);
		connection = config.connect();
	}
	
	public void addParticipation() throws SQLException {
		
		System.out.println("Enter your id:");
		String idString = scanner.nextLine();
		long id = Long.parseLong(idString);
		
		
		
		System.out.println("Choose your category:");

		String sqlString = "SELECT * FROM category";
		PreparedStatement statement = connection.prepareStatement(sqlString);
		ResultSet resultSet = statement.executeQuery();
		
		while(resultSet.next()) {
			
			//id_category and category_name
			System.out.println(resultSet.getLong("id")+". "+resultSet.getString("name"));
		}
		
		String categoryString = scanner.nextLine();
		long category = Long.parseLong(categoryString);
		
		System.out.println("Enter description about your talent:");
		String description = scanner.nextLine();
		
		System.out.println("Enter Start-Time: (yyy-mmm-dd h:m:s)");
		String startTime = scanner.nextLine();
		Timestamp startTimestamp = Timestamp.valueOf(startTime);
		
		System.out.println("Enter End-Time: (yyy-mmm-dd h:m:s)");
		String endTime = scanner.nextLine();
		Timestamp endTimestamp = Timestamp.valueOf(endTime);
		
		System.out.println("Enter the path of your attached file:");
		String file = scanner.nextLine();
		
		boolean is_accepted = false;
		
		String query = "INSERT into participation (id_user, id_category, description, show_start_time, show_end_time, attached_file, is_accepted) values(?,?,?,?,?,?,?)";
		  PreparedStatement statement1 = connection.prepareStatement(query);
		  
			statement1.setLong(1, id);
			statement1.setLong(2, category);
			statement1.setString(3, description);
			statement1.setTimestamp(4, startTimestamp);
			statement1.setTimestamp(5, endTimestamp );
			statement1.setString(6, file);
			statement1.setBoolean(7, is_accepted );
			
			statement1.executeUpdate();
		 
		System.out.println("Check your email :).");
				
	}
}