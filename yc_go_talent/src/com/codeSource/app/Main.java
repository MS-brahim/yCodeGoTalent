package com.codeSource.app;

import java.util.Scanner;

import com.codeSource.controller.UserController;
import com.codeSource.model.Administrator;
import com.codeSource.model.User;

public class Main {
	
	static void Menu() {
		System.out.println(" 1-Admin Login");
		System.out.println(" 2-Candidat");
	}
	
	public static void main(String[] args) {
		UserController user = new UserController();
		User userC = new User();
		
		Scanner scanneMenu = new Scanner(System.in);
		
		System.out.println("+--------------------------------+");
	    System.out.println("| You Welcome in Our Application |");
	    System.out.println("+--------------------------------+");
		try {
			Menu();
			new Administrator().findParticipations();
			do {
				switch(scanneMenu.nextInt()) {
				case 1:
					user.login();
					switch(scanneMenu.next().charAt(0)) {
					case 'u':
						userC.display();
						break;
						
					case 'p':
						
						break;
						
					case 'f':
						break;
						
					case 'v':
						break;
					}
					
					break;
				case 2:				
					userC.display();
					break;
				}
			}while (scanneMenu!=null);		
		} catch (Exception e) {
			e.getMessage();
		}
		
	}

}
