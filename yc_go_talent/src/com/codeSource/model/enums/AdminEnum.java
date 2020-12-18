package com.codeSource.model.enums;

public enum AdminEnum {
	EMPTY_EMAIL_OR_PASS("Please Enter Your Email And Password!!"),
	INCCORECT_EMAIL_OR_PASS("Email and password incorrect !! Enter 1 for try Again Or Enter 2 to switch to candidate"),
	SUCCESS_CONNECT("Admin Connected Success : "),
	SUCCESS_DECONNECT("Admin Deconnected Success");
	private String msgError;
	
	AdminEnum(String msgError){
		this.msgError = msgError;
	}
	
	public String getMsgError() {
		return msgError;
	}
	
	
}
