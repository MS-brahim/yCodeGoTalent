package com.codeSource.app;

import java.util.Scanner;

import com.codeSource.controller.AdminController;
import com.codeSource.controller.UserController;

public class Main {
	
	static void Menu() {
		System.out.println(" 1-Admin Login");
		System.out.println(" 2-Candidat");
	}
	
	public static void main(String[] args) {
		AdminController admin = new AdminController();
		UserController user = new UserController();
		
		Scanner scanneMenu = new Scanner(System.in);
		
		System.out.println("+--------------------------------+");
	    System.out.println("| You Welcome in Our Application |");
	    System.out.println("+--------------------------------+");
		try {
			Menu();
			admin.adminConnect();
			//admin.findAllUsers();
			//admin.findParticipationByEmail();
			//admin.findParticipations();
			//admin.validateParticipation();
 			do {
				switch(scanneMenu.nextInt()) {
				case 1:
					admin.adminConnect();
					do {
						switch(scanneMenu.next().charAt(0)) {
						case 'u':
							admin.findAllUsers();
							break;
							
						case 'p':
							admin.findParticipations();
							break;
							
						case 'f':
							admin.findParticipationByEmail();
							break;
							
						case 'v':
							admin.validateParticipation();
							break;
						}
					} while (true);
				case 2:				
					//Partie Candidats (Ayoub)
					break;
				}
			}while (scanneMenu!=null);		
		} catch (Exception e) {
			e.getMessage();
		}
		
	}

}
