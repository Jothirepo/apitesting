package com.restassured;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

import static org.hamcrest.Matchers.*;

import java.util.concurrent.TimeUnit;

public class Validate_hamcrest {

	@Test
	public void validateid() {

		get("https://reqres.in/api/users?page=2").then().body("data.id", equalTo(7));

	}

	
	@Test
	public void validateTime() {

		get("https://reqres.in/api/users?page=2").then().time(lessThan(1L), TimeUnit.SECONDS);
							
	}
	
	@Test
	public void checkEntries() {

		get("https://reqres.in/api/users?page=2").then().body("data", hasSize(2));
		
	}
	
	@Test
	public void isempty() {

		get("https://reqres.in/api/users?page=2").then().body("data", empty());
		
	}
}
