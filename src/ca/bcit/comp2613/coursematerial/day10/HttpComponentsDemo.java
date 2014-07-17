package ca.bcit.comp2613.coursematerial.day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class HttpComponentsDemo {
	public static void main(String[] args) throws ClientProtocolException,
			IOException {
		HttpClient client = HttpClientBuilder.create().build();
		doSampleGet(client);

		doSamplePost(client);

		doSamplePut(client);
		
		doSampleDelete(client);
	}

	private static void doSampleDelete(HttpClient client) throws IOException,
	ClientProtocolException {
		HttpResponse response;
		String id = "5";
		HttpDelete delete = new HttpDelete("http://rest-hchan.rhcloud.com/api/todo"
				+ "/" + id);
	
		response = client.execute(delete);
		printResponse(response);		
	}

	private static void doSampleGet(HttpClient client) throws IOException,
			ClientProtocolException {
		HttpGet get = new HttpGet("http://rest-hchan.rhcloud.com/api/todo");
		HttpResponse response = client.execute(get);

		printResponse(response);
	}

	private static void doSamplePut(HttpClient client)
			throws UnsupportedEncodingException, IOException,
			ClientProtocolException {
		HttpResponse response;
		StringEntity stringEntity;
		String id = "1";
		HttpPut put = new HttpPut("http://rest-hchan.rhcloud.com/api/todo"
				+ "/" + id);
		stringEntity = new StringEntity("{ \"id\" : " + id
				+ ", \"content\" : \"" + new Date()
				+ "\", \"order\" :1, \"done\" : false}");
		stringEntity.setContentType("application/json");
		put.setEntity(stringEntity);
		response = client.execute(put);
		printResponse(response);
	}

	private static void printResponse(HttpResponse response) throws IOException {
		System.out.println(response.getStatusLine().getStatusCode());
		if (response.getEntity() != null) {
			BufferedReader rd = new BufferedReader(new InputStreamReader(response
					.getEntity().getContent()));
	
			String line = "";
			while ((line = rd.readLine()) != null) {
				System.out.println(line);
			}
		}
	}

	private static void doSamplePost(HttpClient client)
			throws UnsupportedEncodingException, IOException,
			ClientProtocolException {
		HttpResponse response;
		HttpPost post = new HttpPost("http://rest-hchan.rhcloud.com/api/todo");
		StringEntity stringEntity = new StringEntity(
				"{ \"content\" : \"yoyo\", \"order\" :1, \"done\" : false}");
		stringEntity.setContentType("application/json");
		post.setEntity(stringEntity);
		response = client.execute(post);
		printResponse(response);
	}
}
