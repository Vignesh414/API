package com.apitask;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {

	RequestSpecification reqSpec;
	Response response;

	public void addHeader(String key, String Value) {

		reqSpec = RestAssured.given().header(key, Value);
	}
	
	
	public void addHeaders(Headers x) {
		reqSpec = RestAssured.given().headers(x);
		
	}

	public void addBasicAuth(String user, String pass) {

		reqSpec = reqSpec.auth().preemptive().basic(user, pass);

	}

	public void addPathParam(String Key, Object Value) {

		reqSpec = reqSpec.pathParam(Key, Value);
	}

	public void addQueryParam(String Key, String Value) {

		reqSpec = reqSpec.queryParam(Key, Value);
	}

	public void addReqBody(String body) {

		reqSpec = reqSpec.body(body);

	}
	
	public void addReqBody(Object body) {

		reqSpec = reqSpec.body(body);

	}

	public Response addReqType(String type, String url) {

		switch (type) {

		case "GET":
			response = reqSpec.get(url);
			break;
		case "POST":
			response = reqSpec.post(url);
			break;

		case "PUT":
			response = reqSpec.put(url);
			break;

		case "PATCH":
			response = reqSpec.patch(url);
			break;

		case "DELETE":
			response = reqSpec.delete(url);
			break;
		}
		return response;
	}

	public int getStatusCode(Response response) {

		return response.getStatusCode();
	}

	public String getResBodyAsPrettyString(Response response) {

		return response.asPrettyString();
	}

}
