
package com.apitask;

import org.json.simple.parser.ParseException;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiTaskPut {

	
	public static void main(String[] args) throws ParseException {
		
		
	
	RequestSpecification reqSpec;
	//PUT
			reqSpec = RestAssured.given();
			reqSpec.header("Content-Type", "application/json");
			reqSpec.body("{\r\n" + 
					"    \"flightName\": \"AirIndia\",\r\n" + 
					"    \"Country\": \"America1\",\r\n" + 
					"    \"Destinations\": 40,\r\n" + 
					"    \"URL\": \"https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India\"\r\n" + 
					"}");
			reqSpec.pathParam("fNO", "9593");

		Response put = reqSpec.put("https://www.omrbranch.com/api/flight/{fNO}");
		System.out.println(put.statusCode());
		Response response = reqSpec.get("https://www.omrbranch.com/api/flight/{fNO}");
		System.out.println(	response.asPrettyString());
		
		JsonPath jsonPath = response.jsonPath();
		System.out.println(jsonPath.get("data.id"));
		System.out.println(response.getStatusLine());

		
		
		
		
}
}