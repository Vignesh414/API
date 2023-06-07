
package com.apitask;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.java.AddAddress_InputRoot;
import com.java.AddressData;
import com.java.Address_Output_Pojo;
import com.java.CityList_Input_pojo;
import com.java.CityList_Output_pojo;
import com.java.DeleteAddress_Input_pojo;
import com.java.GetAddress_Output_pojo;
import com.java.JsonObject;
import com.java.Login_OutputRoot;
import com.java.StateList_Output_Pojo;
import com.java.UpdateAddress_InputRoot;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class SwaggerDoc extends BaseClass {

	String token;
	int address_id;
	int stateId;
	int cityId;
	int newAddedAddressId;

	@Test(priority = 1)
	public void Login() {
		addHeader("accept", "application/json");
		addBasicAuth("akashka888@gmail.com", "Akash@123");
		Response response = addReqType("POST", "https://www.omrbranch.com/api/postmanBasicAuthLogin");
		System.out.println(response.getStatusCode());
		Login_OutputRoot as = response.as(Login_OutputRoot.class);
		System.out.println(as.getData().getFirst_name());
		token = as.getData().getLogtoken();
		Assert.assertEquals("message", as.getData().getFirst_name(), "Akash");
	}

	@Test(priority = 6)
	public void GetAddress() {
		List<Header> h = new ArrayList<Header>();

		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + token);
		Header h3 = new Header("Content-Type", "application/json");
		h.add(h1);
		h.add(h2);
		h.add(h3);
		Headers x = new Headers(h);
		addHeaders(x);

		Response response = addReqType("GET", "https://www.omrbranch.com/api/getUserAddress");

		GetAddress_Output_pojo address = response.as(GetAddress_Output_pojo.class);

		ArrayList<AddressData> addressdata = address.getData();

		for (int i = 0; i < addressdata.size(); i++) {
			if (String.valueOf(addressdata.get(i).getId()).equals(String.valueOf(address_id))) {
				System.out.println(addressdata.get(i).getId() + "\n" + addressdata.get(i).getAddress_code() + " \n"
						+ addressdata.get(i).getFirst_name() + " \n" + addressdata.get(i).getMobile() + " \n"
						+ addressdata.get(i).getCity_id() + " \n" + addressdata.get(i).getState_id());
				newAddedAddressId = addressdata.get(i).getId();
			}
		}

	}

	@Test(priority = 7)
	public void DeleteAddress() {
		List<Header> h = new ArrayList<Header>();

		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + token);
		Header h3 = new Header("Content-Type", "application/json");
		h.add(h1);
		h.add(h2);
		h.add(h3);
		Headers x = new Headers(h);
		addHeaders(x);

		DeleteAddress_Input_pojo deleteAddress_Input_pojo = new DeleteAddress_Input_pojo(
				String.valueOf(newAddedAddressId));
		addReqBody(deleteAddress_Input_pojo);
		addReqType("DELETE", "https://www.omrbranch.com/api/deleteAddress");

		io.restassured.path.json.JsonPath jsonPath = response.jsonPath();
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals("verify Status code", getStatusCode(response), 200);
		System.out.println(jsonPath.get("message"));

	}

	@Test(priority = 4)
	public void AddAddress() {
		List<Header> h = new ArrayList<Header>();

		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + token);
		Header h3 = new Header("Content-Type", "application/json");
		h.add(h1);
		h.add(h2);
		h.add(h3);
		Headers x = new Headers(h);
		addHeaders(x);

		AddAddress_InputRoot ip = new AddAddress_InputRoot("Akash", "kk", "234567890", "33", 22, 22, 22, "635001",
				"aaad", "ss");
		addReqBody(ip);

		Response response = addReqType("POST", "https://www.omrbranch.com/api/addUserAddress");
		Address_Output_Pojo outres = response.as(Address_Output_Pojo.class);
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals("verify Status code", getStatusCode(response), 200);

		System.out.println(outres.getMessage());
		address_id = outres.getAddress_id();

	}

	@Test(priority = 5)
	public void UpdateAddress() {
		List<Header> h = new ArrayList<Header>();

		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + token);
		Header h3 = new Header("Content-Type", "application/json");
		h.add(h1);
		h.add(h2);
		h.add(h3);
		Headers x = new Headers(h);
		addHeaders(x);
		UpdateAddress_InputRoot up = new UpdateAddress_InputRoot(String.valueOf(address_id), "akash", "ku", "123666444",
				"apartment", 12, 33, 44, "a", "chennai", "chennai");
		addReqBody(up);
		Response response = addReqType("PUT", "https://www.omrbranch.com/api/updateUserAddress");

		System.out.println(getStatusCode(response));

		Assert.assertEquals("verify Status code", getStatusCode(response), 200);

		io.restassured.path.json.JsonPath jsonPath = response.jsonPath();
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals("verify Status code", getStatusCode(response), 200);
		System.out.println(jsonPath.get("message"));

	}

	@Test(priority = 2)
	public void StateList() {

		addHeader("accept", "application/json");
		Response response = addReqType("GET", "https://www.omrbranch.com/api/stateList");
		StateList_Output_Pojo stateList_Output_Pojo = response.as(StateList_Output_Pojo.class);

		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals("verify Status code", getStatusCode(response), 200);

		ArrayList<com.java.StateList> StateList = stateList_Output_Pojo.getData();

		for (com.java.StateList stateList2 : StateList) {

			if (stateList2.getName().equals("Tamil Nadu")) {

				stateId = stateList2.getId();
			}

		}

	}

	@Test(priority = 3)
	public void CityList() {
		List<Header> h = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h3 = new Header("Content-Type", "application/json");
		h.add(h1);
		h.add(h3);
		Headers x = new Headers(h);
		addHeaders(x);

		CityList_Input_pojo input = new CityList_Input_pojo(String.valueOf(stateId));
		addReqBody(input);
		Response response = addReqType("POST", "https://www.omrbranch.com/api/cityList");

		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals("verify Status code", getStatusCode(response), 200);

		CityList_Output_pojo cityOutput = response.as(CityList_Output_pojo.class);

		ArrayList<com.java.CityList> citylist = cityOutput.getData();

		for (com.java.CityList cityList2 : citylist) {

			if (cityList2.getName().equals("Yercaud")) {
				cityId = cityList2.getId();
			}

		}

	}

}
