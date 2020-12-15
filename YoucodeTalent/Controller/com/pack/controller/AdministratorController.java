package com.pack.controller;


import com.user.config.Config;
import com.user.models.Administrator;
import com.user.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AdministratorController extends Administrator {
	static Config config;

    public AdministratorController() {
		config = new Config("jdbc:mysql://localhost:3308/youcodetalent","root","");
    }


    public ArrayList<User> findAllUsers() throws SQLException {

        String query = "SELECT * FROM Administrator";
        Statement statement = config.connect().createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {

            System.out.println(resultSet.getString("password"));
            

        }


        return null;

    }
//public static void display() throws SQLException {
//		
//		String query = "Select * from users";
//		Statement statement = config.connect().createStatement();
//		ResultSet resultSet = statement.executeQuery(query);
//		String leftAlignFormat = "| %-15s | %-15s | %-15s | %-15s | %-15s |%n";
//		
//		System.out.format("+-----------------+-----------------------------------------------------+%n");
//		System.out.format("|       ID        ||      First_name      ||  last_Name   ||      Email     ||       Phone     |%n");
//		System.out.format("+-----------------+-----------------------------------------------------+%n");
//		
//		while (resultSet.next()) {
//			
//			    System.out.format(leftAlignFormat, resultSet.getLong("id"), resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getString("email"), resultSet.getString("phone"));
//
//			}
//			
//			System.out.format("+---------------------------------+-------------------------------------+%n");
//			//			
//		}

}