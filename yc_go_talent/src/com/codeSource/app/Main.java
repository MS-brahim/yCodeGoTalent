package com.codeSource.app;

import java.sql.SQLException;
import java.util.Scanner;

import com.codeSource.controller.AdminController;
import com.codeSource.controller.ParticipationController;
import com.codeSource.controller.UserController;

public class Main {
	
	static void adminMenu() {
		System.out.println(" 1-Admin Login");
		System.out.println(" 2-Candidat");
	}
	
	public static int menu () {

        int selection;
        Scanner input = new Scanner(System.in);

        /***************************************************/

        System.out.println("+-------------------------+ :");
        System.out.println("| You Welcome in Our Application|");
        System.out.println("+-------------------------+ :");
        System.out.println("1 - list User ");
        System.out.println("2 - ADD User ");
        System.out.println("3 - UPDATE User ");
        System.out.println("4 - DELETE User ");
        System.out.println("5 - Quit");
        System.out.println("6 - Find User ById");
        System.out.println("7 - Participate");



        selection = input.nextInt();
        return selection;    
    }
	
	public static void main(String[] args) throws SQLException {
		
		AdminController admin = new AdminController();
		UserController userController = new UserController();
		ParticipationController participationController = new ParticipationController();
		
		Scanner scanneMenu = new Scanner(System.in);
		
		System.out.println("+--------------------------------+");
	    System.out.println("| You Welcome in Our Application |");
	    System.out.println("+--------------------------------+");
		try {
			adminMenu();
			//userController.add();
			//admin.adminConnect();
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
					//Case 2 Partie Candidats 

					Boolean out = true;
					
					while(out) {
						
						switch (menu()) {
						
						case 1 : 
												
							userController.display();
							break;
							
						case 2 : 
										
							userController.add();
							break;
							
				        case 3 :		
								
							userController.update();
							break;
							
			            case 4 : 
	
							userController.delete();
							break;
							
			            case 5: 
			            	System.exit(0);
			            	
			            	break;
			            	
			            case 6: 
			            	
			            	System.out.println(userController.finUserById().toString());
			            	break;
			            	
			            case 7:
			            	
							participationController.addParticipation();
							break;
						}
					}
					
					
				}
			}while (scanneMenu!=null);		
		} catch (Exception e) {
			e.getMessage();
		}
		
	}

}
