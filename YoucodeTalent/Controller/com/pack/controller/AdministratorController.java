package com.pack.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.user.config.Config;
import com.user.models.Participation;
import com.user.models.User;



public class AdministratorController {

	static Config config;
	Scanner input = new Scanner(System.in);
	public AdministratorController() {
		config = new Config("jdbc:mysql://localhost:3308/youcodetalent","root","");
		
	}
	
public static  ArrayList<User> findAllUsers() throws SQLException, ClassNotFoundException {
		
		//declaring the array list
		ArrayList<User> usersList = new ArrayList<>();
		
		String query = "SELECT * FROM users";
		PreparedStatement statement = config.connect().prepareStatement(query);
		ResultSet resultSet = statement.executeQuery();
		
		while(resultSet.next()) {

			User user  = new User(resultSet.getLong("id"),resultSet.getString("first_name"),resultSet.getString("last_name"),resultSet.getString("email"),resultSet.getString("phone"));
			usersList.add(user);
			
		}
		
		for(User list: usersList) {
	        System.out.println(list.toString());
	    }
		
		return usersList;
		
	}

	
	
	
	public void adminConnect() throws SQLException {
		String query = "Update admin_session SET  is_connected=true WHERE id_admin=15970010";
		PreparedStatement stmt = config.connect().prepareStatement(query);
		stmt.executeUpdate();
		System.out.println("Admin Logged in succesfully");
	}
	
	public List<Participation> findParticipations() throws SQLException{
		String query = "SELECT * FROM participation";
		Statement statement = config.connect().createStatement();
		ResultSet resultSet = statement.executeQuery(query);

		while (resultSet.next()) {

			System.out.println(resultSet.getString("id_user"));
			System.out.println(resultSet.getString("id_category"));
			System.out.println(resultSet.getString("description"));
			System.out.println(resultSet.getString("show_start_time"));

		}
		
		return null;
		
	}
	
	public Participation findParticipationByUserEmail() {
		
		System.out.println("Email");
		String email = input.next();
		Participation participation= new Participation();
		
	try {
		String query = "SELECT p.id_user FROM participation p, users u WHERE p.id_user= u.id AND u.email='"+email+"'";
		PreparedStatement stmt = config.connect().prepareStatement(query);
		ResultSet resultSet = stmt.executeQuery(query);
		while (resultSet.next()) {

			System.out.println(resultSet.getString("id_user"));

		}
	} catch (Exception e) {
		System.out.println("Vous avez une erreur " + e.getMessage());
	}
		
		
		return null;
		
		
	}
	
}