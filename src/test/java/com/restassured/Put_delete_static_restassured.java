package com.restassured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import static io.restassured.RestAssured.*;

public class Put_delete_static_restassured {

	@Test (priority = 0)
	public void putmethod() {
	
		JSONObject job = new JSONObject();
		job.put("name", "jothi");
		job.put("job", "SDA");
		
		baseURI = "https://reqres.in/api";
		
		 given()
		.when()
		.body(job.toJSONString())		//used to convert jsonobject to json string
			//use the body from request specification
		.put("/register")			//use put from request sender options with URI
		.then()
		.statusCode(200);

	}
	
	@Test (priority = 1)
	public void deletemethod() {
		
		baseURI = "https://reqres.in/api";
		
		 given()
		.when()
		.delete("/register")
		.then()
		.statusCode(200);
		
	}
	
	
}
