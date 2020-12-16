package com.youcode.app;

import java.sql.SQLException;
import java.util.Scanner;

import com.youcode.controller.AdministratorController;
import com.youcode.controller.ParticipationController;
import com.youcode.controller.UserController;
import com.youcode.models.Participation;




public class Main {
	
	//Create the menu
	
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
        System.out.println("7 - Find AllUsers (administrator)");
        System.out.println("8 - Participate");



        selection = input.nextInt();
        return selection;    
    }
	
	

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		UserController userController = new UserController();
		
		ParticipationController participationController = new ParticipationController();

		
		
		
		// TODO Auto-generated method stub
		
		Boolean out = true;
		
		while(out) {
			
			switch (menu()) {
			
			case 1 : 
				
				try {
					
					
					userController.display();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}
				
				break;
				
			case 2 : 
				
	            try {
					
					
					userController.add();
					
					
					
					participationController.addParticipation();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}
				
				break;
				
	        case 3 : 
				
	            try {
					
					
					userController.update();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}
				
				break;
				
            case 4 : 
				
	            try {
					
					
					userController.delete();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}
				
				break;
				
            case 5: 
            	System.exit(0);
            	
            	break;
            	
            case 6: 
            	
            	
            	try {
            		
            		
            		
            		
            		System.out.println(userController.finUserById().toString());
            		
            	} catch (Exception e) {
					// TODO: handle exception
            		
					System.out.println(e);

            		
				}
            	break;
            	
            case 7:
            	
            	try {
            		
            		System.out.println(AdministratorController.findAllUsers().toString());
            		
            		

            		
            	} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
				}
            	break; 
            	
            case 8:
            	
            	try {
					participationController.addParticipation();

            	} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
				}
            	

            	
            default:
				System.out.println("Oups une erreur est trouvé");
				break;
			}
		}
		
	}

}
