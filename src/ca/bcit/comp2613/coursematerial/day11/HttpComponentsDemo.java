package ca.bcit.comp2613.coursematerial.day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class HttpComponentsDemo {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet("http://www.bcit.ca");
		HttpResponse response = client.execute(request);
	
		// Get the response
		BufferedReader rd = new BufferedReader
		  (new InputStreamReader(response.getEntity().getContent()));
		    
		String line = "";
		while ((line = rd.readLine()) != null) {
		 System.out.println(line);
		}
	}
}


