package com.java;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonObject {

	public static void main(String[] args) throws IOException, ParseException {

		FileReader file = new FileReader("C:\\Users\\ADMIN\\eclipse-workspace\\API\\src\\test\\resources\\JsonFiles\\singleflight.json");

		JSONParser jp = new JSONParser();
		JSONObject jo1 = (JSONObject) jp.parse(file);
		JSONObject s = (JSONObject) jo1.get("data");
		String ss = (String) s.get("flightName");
		System.out.println(ss);

		FileReader file2 = new FileReader(	System.getProperty("user.dir") + "\\src\\test\\resources\\JsonFiles\\listflight.json");

		JSONParser jp2 = new JSONParser();
		JSONObject object = (JSONObject) jp2.parse(file2);
		JSONArray array = (JSONArray) object.get("data");
		for (int i = 0; i < array.size(); i++) {
			
			JSONObject object2 = (JSONObject) array.get(i);
			System.out.println(object2.get("id"));
			System.out.println(object2.get("flightName"));
			System.out.println(object2.get("Country"));
			System.out.println(object2.get("Destinations"));
			System.out.println(object2.get("URL"));
		}
		

	}
}
