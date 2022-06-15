package com.apitesting;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

public class Unirest_api_testing {

	public static void main(String[] args) {

		//GET_METHOD
		HttpResponse<JsonNode> asJson = Unirest.get("https://reqres.in/api/users/2").asJson();

		int getstatus = asJson.getStatus();
		System.out.println("STATUS CODE : " + getstatus);

		String getstatusText = asJson.getStatusText();
		System.out.println("STATUS MESSAGE  : " + getstatusText);

		JsonNode getbody = asJson.getBody();
		System.out.println("RESPONSE BODY  : " + getbody);

		System.out.println("***********************************************************************************************************");
		
		
		//POST_METHOD

		HttpResponse<JsonNode> post = Unirest.post("https://reqres.in/api/users")
				.body("{\"id\":7,\"email\":\"jothi.bluth@reqres.in\",\"first_name\":\"Jothi\",\"last_name\":\"ram\"}")
				.asJson();

		int poststatus = post.getStatus();
		System.out.println("STATUS CODE : " + poststatus);

		String poststatusText = post.getStatusText();
		System.out.println("STATUS MESSAGE  : " + poststatusText);

		JsonNode postbody = post.getBody();
		System.out.println("RESPONSE BODY  : " + postbody);
		
		System.out.println("***********************************************************************************************************");
		
		//verifying_post_method
		
		HttpResponse<JsonNode> verifypost = Unirest.get("https://reqres.in/api/user/329").asJson();

		int verifypoststatus = verifypost.getStatus();
		System.out.println("STATUS CODE : " + verifypoststatus);

		String verifypostText = verifypost.getStatusText();
		System.out.println("STATUS MESSAGE  : " + verifypostText);

		JsonNode verifypostbody = verifypost.getBody();
		System.out.println("RESPONSE BODY  : " + verifypostbody);
		
	}

}
