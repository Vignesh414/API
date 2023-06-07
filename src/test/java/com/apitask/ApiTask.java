package com.apitask;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class ApiTask {
	public static void main(String[] args) {
		RequestSpecification reqSpec;
//GET
		reqSpec = RestAssured.given();
		reqSpec.header("Content-Type", "application/json");
//		Response response = reqSpec.get("https://www.omrbranch.com/api/flights?page=1");
//		Response response2 = reqSpec.get("https://www.omrbranch.com/api/flight/9570");
//
//		System.out.println(response.asPrettyString());
//		System.out.println(response2.asPrettyString());

//POST

		        reqSpec.body("{\r\n" + 
		        		"    \"flightName\": \"AirIndia\",\r\n" + 
		        		"    \"Country\": \"India\",\r\n" + 
		        		"    \"Destinations\": \"87\",\r\n" + 
		        		"    \"URL\": \"https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India\"\r\n" + 
		        		"}");

		 Response response = reqSpec.post("https://www.omrbranch.com/api/flights");
		 System.out.println(response.asPrettyString());
		 JsonPath jsonPath = response.jsonPath();
			System.out.println(response.getStatusCode());
			System.out.println(response.getStatusLine());
			System.out.println(jsonPath.get("data.id"));
			Object object = jsonPath.get("data.id");
//		reqSpec.pathParam("fNO", "9593");
//
//		 
//		reqSpec.body("{\r\n" + "    \"flightName\": \"AirIndia\",\r\n" + "    \"Country\": \"America\",\r\n"
//						+ "    \"Destinations\": 41,\r\n"
//						+ "    \"URL\": \"https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India\"\r\n" + "}");
//		reqSpec.put("https://www.omrbranch.com/api/flight/{fNO}");
		
		
		
		
//		System.out.println(response3.statusLine());
//		Response putresponse = reqSpec.get("https://www.omrbranch.com/api/flight/{fNo}");
//
//		
//		int statusCode = putresponse.getStatusCode();
//		System.out.println(statusCode);
//		
//		String asPrettyString = putresponse.asPrettyString();
//		
//		System.out.println(asPrettyString);
//		
		
//		ResponseBody body = putresponse.getBody();
//		System.out.println(body.asPrettyString());

		
		
		
	}

}
