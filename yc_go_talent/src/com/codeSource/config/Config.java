package com.codeSource.config;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

public class Config {
	final String DRIVER = "com.mysql.jdbc.Driver";
	final String DB_PATH = "jdbc:mysql://localhost:3306/yc_gotalent";
	String userName = "root";
	String password = "";
	Connection conn;
	Statement stmt;
		
	//Constructor
	public Config() {

	}

	public void connect() throws SQLException, Exception{
		Class.forName(DRIVER);
		//System.out.println("Connection success...");
		conn = DriverManager.getConnection(DB_PATH,userName,password);
		stmt = conn.createStatement();
	}
		
	public Statement getStatement() {
		return stmt;
	}
}
