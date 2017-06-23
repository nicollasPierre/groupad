package br.com.furb.groupad_client.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.ws.rs.core.MediaType;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class RestUtils {

	public RestUtils() {

	}

	public static String getRestRequest(String url, String acceptHeader)
			throws ClientProtocolException, IOException, RuntimeException {

		// create HTTP Client
		HttpClient httpClient = HttpClientBuilder.create().build();

		// Create new getRequest with below mentioned URL
		HttpGet getRequest = new HttpGet(url);

		// Add additional header to getRequest which accepts a type of
		// data
		getRequest.addHeader("accept", acceptHeader);

		// Execute your request and catch response
		HttpResponse response = httpClient.execute(getRequest);

		// Check for HTTP response code: 200 = success
		if (response.getStatusLine().getStatusCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
		}

		// Get-Capture Complete application/xml body response
		BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
		String output;
		System.out.println("============Get  Output:============");

		// Simply iterate through XML response and show on console.
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}
		return output;
	}
	
	public static String putRestRequest(String url, String data)
			throws ClientProtocolException, IOException, RuntimeException {

		// create HTTP Client
		HttpClient httpClient = HttpClientBuilder.create().build();

		// Create new getRequest with below mentioned URL
		HttpPut putRequest = new HttpPut(url);
		StringEntity dataEtity = new StringEntity(data);
		dataEtity.setContentType(MediaType.TEXT_PLAIN);
		putRequest.setEntity(dataEtity);

		// Execute your request and catch response
		HttpResponse response = httpClient.execute(putRequest);

		// Check for HTTP response code: 200 = success
		if (response.getStatusLine().getStatusCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
		}

		// Get-Capture Complete application/xml body response
		BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
		String output;
		System.out.println("============Put  Output:============");

		// Simply iterate through XML response and show on console.
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}
		return output;
	}
	
	public static String postRestRequest(String url, String data)
			throws ClientProtocolException, IOException, RuntimeException {

		// create HTTP Client
		HttpClient httpClient = HttpClientBuilder.create().build();

		// Create new getRequest with below mentioned URL
		HttpPost postRequest = new HttpPost(url);
		StringEntity dataEtity = new StringEntity(data);
		dataEtity.setContentType(MediaType.TEXT_PLAIN);
		postRequest.setEntity(dataEtity);

		// Execute your request and catch response
		HttpResponse response = httpClient.execute(postRequest);

		// Check for HTTP response code: 200 = success
		if (response.getStatusLine().getStatusCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
		}

		// Get-Capture Complete application/xml body response
		BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
		String output;
		System.out.println("============Post Output:============");

		// Simply iterate through XML response and show on console.
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}
		return output;
	}
	
	public static String deleteRestRequest(String url, String acceptHeader)
			throws ClientProtocolException, IOException, RuntimeException {

		// create HTTP Client
		HttpClient httpClient = HttpClientBuilder.create().build();

		// Create new getRequest with below mentioned URL
		HttpDelete deleteRequest = new HttpDelete(url);

		// Add additional header to getRequest which accepts a type of
		// data
		deleteRequest.addHeader("accept", acceptHeader);

		// Execute your request and catch response
		HttpResponse response = httpClient.execute(deleteRequest);

		// Check for HTTP response code: 200 = success
		if (response.getStatusLine().getStatusCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
		}

		// Get-Capture Complete application/xml body response
		BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
		String output;
		System.out.println("============Get  Output:============");

		// Simply iterate through XML response and show on console.
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}
		return output;
	}
}
