package com.majorproject.userservicev1;

public class BecomeSellerRequest {
	
	private String companyNameString;
	
	public BecomeSellerRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BecomeSellerRequest(String companyNameString) {
		super();
		this.companyNameString = companyNameString;
	}

	public String getCompanyNameString() {
		return companyNameString;
	}

	public void setCompanyNameString(String companyNameString) {
		this.companyNameString = companyNameString;
	}
	
	
}
