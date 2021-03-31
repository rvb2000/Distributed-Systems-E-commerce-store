package com.apurva.gatewayservicev1;


public class AuthenticationResponse {
	private String jwtString;
	
	
	
	public AuthenticationResponse() {
		// TODO Auto-generated constructor stub
	}

	public AuthenticationResponse(String jwtString) {
		super();
		this.jwtString = jwtString;
	}

	public String getJwtString() {
		return jwtString;
	}

	public void setJwtString(String jwtString) {
		this.jwtString = jwtString;
	}

	
	
}
