package com.apurva.gatewayservicev1;


public class AuthenticationRequest {
	private String usernameString;
	private String passwordString;
	
	
	
	public AuthenticationRequest() {
		// TODO Auto-generated constructor stub
	}
	public AuthenticationRequest(String usernameString, String passwordString) {
		super();
		this.usernameString = usernameString;
		this.passwordString = passwordString;
	}
	public String getUsernameString() {
		return usernameString;
	}
	public void setUsernameString(String usernameString) {
		this.usernameString = usernameString;
	}
	public String getPasswordString() {
		return passwordString;
	}
	public void setPasswordString(String passwordString) {
		this.passwordString = passwordString;
	}
	
	
}
