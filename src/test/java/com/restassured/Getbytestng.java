package com.restassured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;

public class Getbytestng {
	
	@Test (priority = 0)
	public void getMethod() {
		
		//Get request
		Response get = RestAssured.get("https://reqres.in/api/users?page=2");
		
//STATUS		
		//Get the status code of the URL
		System.out.println("Get the status code of the requested URL : " + get.getStatusCode());
		//Get the status message with code of the URL
		System.out.println("Get the status code & msg of the requested URL : " + get.getStatusLine());
		
//BODY	
		//Get body of the requested URL
		ResponseBody body = get.getBody(); 			//get.body(); also can be used.
		
		//Get body with format
		System.out.println("pretty body using normal type : " + body.asPrettyString());
		//Get body without format
		System.out.println("string body using normal type : " + body.asString());
	}
	
	
//most frequently used type in real world project
	
	@Test (priority = 1)
	public void getBddMethod() {
		
		RestAssured.baseURI = "https://reqres.in/api/";		
		
		Response response = RestAssured
		.given()
			.param("", "")
			.header("","")
		.when()
			.get("/users?page=2");
		
		System.out.println("pretty body using BDD style : " + response.asPrettyString());

	}

	@Test (priority = 2)		
	public void getBddstylewiththen() {
		
		RestAssured.baseURI = "https://reqres.in/api/";
		
		ValidatableResponse statusCode = RestAssured
		.given()
			.param("", "")
			.header("","")
		.when()
			.get("/users?page=2")
			.then()
			.statusCode(200);
		
	}
}
