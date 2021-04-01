package com.majorproject.userservicev1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Seller")
public class Seller {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sellerIdInteger;
	
	@NotEmpty(message = "Company name required")
	private String companyNameString;
	
	@OneToOne
	private User user;
	
	public Seller() {
		
	}

	public Seller(Integer sellerIdInteger, @NotEmpty(message = "Company name required") String companyNameString,
			User user) {
		super();
		this.sellerIdInteger = sellerIdInteger;
		this.companyNameString = companyNameString;
		this.user = user;
	}

	public Integer getSellerIdInteger() {
		return sellerIdInteger;
	}

	public void setSellerIdInteger(Integer sellerIdInteger) {
		this.sellerIdInteger = sellerIdInteger;
	}

	public String getCompanyNameString() {
		return companyNameString;
	}

	public void setCompanyNameString(String companyNameString) {
		this.companyNameString = companyNameString;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
