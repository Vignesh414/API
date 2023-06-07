package com.java;

public class address {
	
	private String streetName;
	private String dristic;
	private int pinCode;
	public address(String streetName, String dristic, int pinCode) {
		super();
		this.streetName = streetName;
		this.dristic = dristic;
		this.pinCode = pinCode;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getDristic() {
		return dristic;
	}
	public void setDristic(String dristic) {
		this.dristic = dristic;
	}
	public int getPinCode() {
		return pinCode;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	
	
	
	
}
