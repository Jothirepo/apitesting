package com.apitesting;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Java_api_testing {
    
public static void main(String[] args) throws IOException {
		
		
		//GET_METHOD
		URL url = new URL("https://reqres.in/api/users?page=2");			//create an object for the url
		
		HttpURLConnection openConnection = (HttpURLConnection) url.openConnection();	//open the url and store it in it's parent class
		
		openConnection.setRequestMethod("GET"); 					//set request method as GET
		
		openConnection.connect();									//set connect to establish connection
		
		int responseCode = openConnection.getResponseCode();
		
		System.out.println("GET RESPONSE CODE : " + responseCode);
		
		System.out.println("******************************************************************");
		
		//DELETE METHOD
		URL ur = new URL("https://reqres.in/api/users/2");
		
		HttpURLConnection huc = (HttpURLConnection) ur.openConnection();
		
		huc.setRequestMethod("DELETE");
		
		huc.connect();
		
		int responseCode2 = huc.getResponseCode();
		
		System.out.println("DELETE RESPONSE CODE : " + responseCode2);
		
		String responseMessage = huc.getResponseMessage();
		
		System.out.println("DELETE RESPONSE MESSAGE : " + responseMessage);

	}

}
