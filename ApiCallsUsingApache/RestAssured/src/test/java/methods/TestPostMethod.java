package methods;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class TestPostMethod {
	
	private static Map<String, String> bodyData = new HashMap<String, String>();
	
	@Before
	public void createBodyData() {
		bodyData.put("userId", "2");
		bodyData.put("id", "19");
		bodyData.put("title", "this is projectdebug.com");
		bodyData.put("body", "this is REST-Assured Tutorial");	
		RestAssured.baseURI = "http://jsonplaceholder.typicode.com";
		RestAssured.basePath = "/posts/";
	}
	
	@Test
	public void testPostMethod() {
		given()
			.contentType("application/json")
			.body(bodyData).
		when()
			.post().
		then()
			.statusCode(201)
			.and()
			.body("title", equalTo("this is projectdebug.com"));
	}
	
	@Test
	public void testPostToCheckJSON() {
		
	}

}
