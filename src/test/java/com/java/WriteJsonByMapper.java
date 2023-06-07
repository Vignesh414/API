package com.java;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import io.cucumber.core.internal.com.fasterxml.jackson.core.exc.StreamWriteException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.DatabindException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.json.JsonMapper;

public class WriteJsonByMapper {

	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {

		File file = new File(
				"C:\\Users\\ADMIN\\eclipse-workspace\\API\\src\\test\\resources\\JsonFiles\\WriteEmployeeDetail.json");

		JsonMapper mapper = new JsonMapper();

		ArrayList<address> address = new ArrayList<address>();
		address a1 = new address("street", "chennai", 23456);
		address a2 = new address("jjasl", "ch", 343);
		address.add(a2);
		address.add(a1);

		ArrayList<String> course = new ArrayList<String>();
		course.add("java");
		course.add("akakak");

		RootPojoWrite rp = new RootPojoWrite("Akash", 234, course, address);
		mapper.writeValue(file, rp);

	}

}
