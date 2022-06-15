package com.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Get_two_methods {

	public static void main(String[] args) {

		// TYPE-1 GET METHOD (normal)

		Response get = RestAssured.get("https://reqres.in//api//users?page=2");

		System.out.println(get.getStatusCode());
		System.out.println(get.getStatusLine());

		ResponseBody body = get.getBody();
		String responsestring = body.asString();
		System.out.println(responsestring);

		
		
		// TYPE-2 GET METHOD (normal base uri)

		RestAssured.baseURI = "https://reqres.in/";
		RequestSpecification given = RestAssured.given(); // used where parameters like params, content types, headers,
															// authorizations are set
		Response getmethod = given.get("/api/users?page=2");

		int statusCode = getmethod.getStatusCode();
		String asString = getmethod.asString();

		System.out.println("get status code using given : " + statusCode);
		System.out.println("get status message using given : " + asString);

		
		
		
		// TYPE-3 GET METHOD (bdd style get method)
		RestAssured.baseURI = "https://reqres.in/api/";

		Response response = RestAssured
				
		.given()
			.param("", "")
			.header("", "")
			
		.when()
			.get("/users?page=2");

		System.out.println("pretty body using BDD style : " + response.asPrettyString());

	}

}
