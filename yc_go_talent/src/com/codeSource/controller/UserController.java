package com.codeSource.controller;

import java.util.Scanner;

import com.codeSource.model.Administrator;

public class UserController {
	
	Administrator admin =  new Administrator();
	
	public void login() throws Exception {
		System.out.println("Enter Your Email : ");
		String emailInput =  new Scanner(System.in).nextLine();
		
		System.out.println("Enter Your Password : ");
		String passInput =  new Scanner(System.in).nextLine();
		
		if (emailInput.isEmpty() && passInput.isEmpty()) {
			System.out.println("Please Enter Your Email And Password!!");
		}else {
			admin.adminConnect(emailInput,passInput);		
		}
	}
}
