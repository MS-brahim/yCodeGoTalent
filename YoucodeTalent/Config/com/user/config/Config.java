package com.user.config;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class Config {
	
	private String url;
	private String username;
	private String password;
	
	public Config() {}
	
	public Config(String url, String username, String password) {
		
		this.url=url;
		this.username=username;
		this.password=password;
		
	}
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Connection connect() throws SQLException {
		
		Connection connection = DriverManager.getConnection(this.url,this.username,this.password);
		return connection;
		
		
	}
	

}