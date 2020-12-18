package com.codeSource.app;

import java.sql.SQLException;
import java.util.Scanner;

import com.codeSource.controller.AdminController;
import com.codeSource.controller.ParticipationController;
import com.codeSource.controller.UserController;

public class Main {
	
	static void adminMenu() {
		System.out.println(" 1-Admin");
		System.out.println(" 2-Candidat");
	}
	
	public static int menu () {

        int selection;
        Scanner input = new Scanner(System.in);

        /***************************************************/
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
		UserController user = new UserController();
		ParticipationController participation = new ParticipationController();
		
		Scanner scanneMenu = new Scanner(System.in);
		
		System.out.println("+--------------------------------+");
	    System.out.println("| You Welcome in Our Application |");
	    System.out.println("+--------------------------------+");
		try {
			adminMenu();
			//admin.SendMail("stmp.gmail.com", "465", "fromEmail", "email password", "toEmail", "subject", "message");
			//participation.addParticipation();
			//userController.add();
			//admin.adminConnect();
			//admin.adminDeconnect();
			//admin.findAllUsers();
			//admin.findParticipationByEmail();
			//admin.findParticipations();
			//admin.validateParticipation();
 			do {
				switch(scanneMenu.nextInt()) {
				//Case 1 Partie Admin 
				case 1:
					admin.adminConnect();
					while (true) {
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
						case 'd':
							admin.adminDeconnect();
							//System.exit(0);
							break;
						}
						//break;
					} 
					
										
					//Case 2 Partie Candidats 
				case 2:				
					
					while(true) {
						
						switch (menu()) {
						
						case 1 : 
												
							user.display();
							break;
							
						case 2 : 
										
							user.add();
							break;
							
				        case 3 :		
								
				        	user.update();
							break;
							
			            case 4 : 
	
			            	user.delete();
							break;
							
			            case 5: 
			            	System.exit(0);
			            	
			            	break;
			            	
			            case 6: 
			            	
			            	System.out.println(user.finUserById().toString());
			            	break;
			            	
			            case 7:
			            	
							participation.addParticipation();
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
