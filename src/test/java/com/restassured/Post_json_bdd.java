package com.restassured;

import org.json.simple.JSONObject;

import org.testng.annotations.Test;

import io.restassured.RestAssured;


public class Post_json_bdd {

	//POST_USING OWN JSON FILE CREATION
	
	@Test
	private void postBdd() {
		
		
		JSONObject job = new JSONObject();		//Add json simple dependency to create json object
		job.put("first_name", "radha");				//they are in key value pair
		job.put("last_name", "prasanth");
		job.put("email", "rapa@codingthesmartway.com");
		
		System.out.println(job.toString());		//check the input
		
		//String jsonString = job.toJSONString(); //to convert the string to jsonstring
		
		
		RestAssured.baseURI = "http://localhost:3000/";
		
		RestAssured
		.given()
		.header("", "")				//	.contentType(ContentType.JSON)			| will be usedful in real world examples |
									//	.accept(ContentType.JSON)
		.when()
		.body(job.toJSONString())						//body of the json will be given here from jsonobject
														//body is given by json simple library
		.post("/employees")
		.then()
			.statusCode(201);
	
	}
	
	
	
}
