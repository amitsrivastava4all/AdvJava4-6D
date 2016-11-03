package com.srivastava.actions;

import com.opensymphony.xwork2.Action;

public class LoginAC implements Action {
	private String userid;
	private String password;
	private String message;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String doLogin(){
		if(userid.equals(password)){
			message = "Welcome "+userid;
		}
		else
		{
			message = "Invalid Userid or Password";
		}
		return SUCCESS;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
