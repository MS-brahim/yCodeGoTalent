package com.user.models;

import java.sql.SQLException;
import java.util.ArrayList;

public class Administrator extends User {
	
	private String password;

	public Administrator(String password) {
		super();
		this.password = password;
	}
	
	public Administrator() {}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Administrator [password=" + password + ", toString()=" + super.toString() + "]";
	}
	
	public ArrayList<User> findAllUsers() throws SQLException{
		return null;}
	
	public void adminConnect(){}
	
	public ArrayList<Participation> findParticipations(){
		return null;}
	
	public Participation findParticipationByEmail(){
		return null;}
	
	public void validateParticipation(){}

	
	
	
	
	

}
