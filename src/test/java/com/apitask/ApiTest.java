
package com.apitask;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ApiTest extends BaseClass {
	Object flightNumber;

	@Test(priority = 4)
	public void getFlight() {
		addHeader("Content-Type", "application/json");
		addPathParam("fNo", flightNumber);
		Response response = addReqType("GET", "https://www.omrbranch.com/api/flight/{fNo}");
		System.out.println("Created and updated flight is");
		System.out.println(getResBodyAsPrettyString(response));
	}

	@Test(priority = 2)
	public void updateFlightPut() {
		addHeader("Content-Type", "application/json");
		addPathParam("fNo", flightNumber);
		addReqBody("{\r\n" + "    \"flightName\": \"AirIndia\",\r\n" + "    \"Country\": \"America\",\r\n"
				+ "    \"Destinations\": 10000,\r\n"
				+ "    \"URL\": \"https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India\"\r\n" + "}");
		Response response = addReqType("PUT", "https://www.omrbranch.com/api/flight/{fNo}");
		System.out.println(response.getStatusCode());

	}

	@Test(priority = 3)
	public void updateFlightPatch() {
		addHeader("Content-Type", "application/json");
		addPathParam("fNo", flightNumber);
		addReqBody("{\r\n" + "    \"flightName\": \"AirIndiaAkash\",\r\n" + "    \"Country\": \"America\",\r\n"
				+ "    \"Destinations\": 90,\r\n"
				+ "    \"URL\": \"https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India\"\r\n" + "}");
		Response response = addReqType("PATCH", "https://www.omrbranch.com/api/flight/{fNo}");
		System.out.println(response.getStatusCode());

	}

	@Test(priority = 1)
	public void createFlight() {
		addHeader("Content-Type", "application/json");
		addReqBody("{\r\n" + "    \"flightName\": \"AirIndia\",\r\n" + "    \"Country\": \"India\",\r\n"
				+ "    \"Destinations\": \"87\",\r\n"
				+ "    \"URL\": \"https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India\"\r\n" + "}");
		Response response = addReqType("POST", "https://www.omrbranch.com/api/flights");
		JsonPath jsonPath = response.jsonPath();
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(jsonPath.get("data.id"));
		Object object = jsonPath.get("data.id");
		flightNumber =object;

	}

	@Test(priority = 5)
	public void deleteFlight() {
		addHeader("Content-Type", "application/json");
		addPathParam("fNo", flightNumber);
		Response response = addReqType("DELETE", "https://www.omrbranch.com/api/flight/{fNo}");
		System.out.println(response.getStatusCode());
		System.out.println(getResBodyAsPrettyString(response));

	}

}
