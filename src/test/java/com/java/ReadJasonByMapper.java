package com.java;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import io.cucumber.core.internal.com.fasterxml.jackson.core.exc.StreamReadException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.DatabindException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.json.JsonMapper;

public class ReadJasonByMapper {

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		File file = new File(
				"C:\\Users\\ADMIN\\eclipse-workspace\\API\\src\\test\\resources\\JsonFiles\\listflight.json");

		JsonMapper mapper = new JsonMapper();

		RootPojo rp = mapper.readValue(file, RootPojo.class);

		System.out.println(rp.getPage());
		System.out.println(rp.getPer_page());
		System.out.println(rp.getTotal());
		System.out.println(rp.getTotal_pages());

		for (int i = 0; i < rp.getData().size(); i++) {

		System.out.println(	rp.getData().get(i).getId());
		System.out.println(	rp.getData().get(i).getFlightName());
		System.out.println(	rp.getData().get(i).getCountry());
		System.out.println(	rp.getData().get(i).getDestinations());
		System.out.println(	rp.getData().get(i).getuRL());
		}
		
	System.out.println(	rp.getSupport().getText());
		System.out.println(rp.getSupport().getUrl());
		

	}

}
