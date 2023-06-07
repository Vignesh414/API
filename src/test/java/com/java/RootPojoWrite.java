package com.java;

import java.util.ArrayList;
import java.util.List;

public class RootPojoWrite {

	
	private String name;
	private int id;
	private List<String> course;
	private List<address> address;
	public RootPojoWrite(String name, int id, ArrayList course, List<com.java.address> address) {
		super();
		this.name = name;
		this.id = id;
		this.course = course;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List getCourse() {
		return course;
	}
	public void setCourse(ArrayList course) {
		this.course = course;
	}
	public List<address> getAddress() {
		return address;
	}
	public void setAddress(List<address> address) {
		this.address = address;
	}
	
	
	
	
	
	
	
	
	
	
	
}
