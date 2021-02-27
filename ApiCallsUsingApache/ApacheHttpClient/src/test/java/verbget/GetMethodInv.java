package verbget;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Assert;
import org.junit.Test;



public class GetMethodInv {

	@Test
	public void aSimpleMethod() throws ClientProtocolException, IOException {
		//creating a default connection
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		//Setting up the endpoints
		HttpGet httpGet = new HttpGet("https://reqres.in/api/users?page=2");
		
		//calling up the get method
		HttpResponse httpRespone = httpClient.execute(httpGet);
		
		//StatusLine statusCode = httpRespone.getStatusLine();
		//Assert.assertArrayEquals(httpRespone.getStatusLine(), actuals);
		
		System.out.println(httpRespone.toString());
	}
	
	@Test
	public void testAResponseHandler() throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("https://reqres.in/api/users?page=2");
		
		//creating a response handler
		ResponseHandler<String> resHandler = new MyResponseHandler();
		
		String response = httpClient.execute(httpGet, resHandler);
		
		System.out.println(response);
		
	}
}
