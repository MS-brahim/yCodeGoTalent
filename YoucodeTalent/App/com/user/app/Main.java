package com.user.app;
import java.sql.SQLException;
import java.util.Scanner;

import com.pack.controller.AdministratorController;
import com.pack.controller.UserController;
import com.user.models.Administrator;


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

        selection = input.nextInt();
        return selection;    
    }
	
	

	public static void main(String[] args) {
		
		UserController userController = new UserController();
		
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
            	
//            case 7 : 
//				
//				try {
//					
//					
//					AdministratorController.display();
//					
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					System.out.println(e);
//				}
				
//				break;
            	
            default:
				System.out.println("Oups une erreur est trouvé");
				break;
			}
		}
		
	}

}