package com.srivastava.actions;

/*
 * Action are model
 * and it can be easily test
 * it is POJO Class
 */
public class WelcomeAC {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String execute(){
		this.setMessage("Welcome User !");
		return "success";
		
	}
	

}
