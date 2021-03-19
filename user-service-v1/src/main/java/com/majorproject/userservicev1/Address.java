package com.majorproject.userservicev1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer addressIdInteger;
	private String firstLineString;
	private String secondLineString;
	private String thirdLineString;
	private String cityNameString;
	private String pincodeString;
	
	@ManyToOne
	private User user;
	
	public Address() {
		
	}
	
	public Address(Integer addressIdInteger, String firstLineString, String secondLineString, String thirdLineString,
			String cityNameString, String pincodeString, User user) {
		super();
		this.addressIdInteger = addressIdInteger;
		this.firstLineString = firstLineString;
		this.secondLineString = secondLineString;
		this.thirdLineString = thirdLineString;
		this.cityNameString = cityNameString;
		this.pincodeString = pincodeString;
		this.user = user;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getAddressIdInteger() {
		return addressIdInteger;
	}
	public void setAddressIdInteger(Integer addressIdInteger) {
		this.addressIdInteger = addressIdInteger;
	}
	public String getFirstLineString() {
		return firstLineString;
	}
	public void setFirstLineString(String firstLineString) {
		this.firstLineString = firstLineString;
	}
	public String getSecondLineString() {
		return secondLineString;
	}
	public void setSecondLineString(String secondLineString) {
		this.secondLineString = secondLineString;
	}
	public String getThirdLineString() {
		return thirdLineString;
	}
	public void setThirdLineString(String thirdLineString) {
		this.thirdLineString = thirdLineString;
	}
	public String getCityNameString() {
		return cityNameString;
	}
	public void setCityNameString(String cityNameString) {
		this.cityNameString = cityNameString;
	}
	public String getPincodeString() {
		return pincodeString;
	}
	public void setPincodeString(String pincodeString) {
		this.pincodeString = pincodeString;
	}
	
	
}
