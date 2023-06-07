package com.java;

import java.util.ArrayList;

public class GetAddress_Output_pojo {

	public int status;
	public String message;
	public ArrayList<AddressData> data;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ArrayList<AddressData> getData() {
		return data;
	}

	public void setData(ArrayList<AddressData> data) {
		this.data = data;
	}

}
