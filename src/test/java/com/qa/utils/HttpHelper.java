package com.qa.utils;

import java.io.File;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class HttpHelper {

	public static String uploadApp(String filepath) throws UnirestException {
		
		Unirest.setTimeouts(0, 0);
		HttpResponse<String> response = Unirest.post("https://api-cloud.browserstack.com/app-automate/upload")
		  .header("Authorization", "Basic cWttc3VwcG9ydF9Mak5wdEM6bzh0bVk4VTFGUWpQYlNOcFpVc0s=")
		  .header("Cookie", "tracking_id=8d92c023-0e56-415a-b7cd-8278dcb8bcf7")
		  .field("file", new File(filepath))
		  .field("custom_id", "TestApp")
		  .asString();
		return response.getBody();

	}
}
