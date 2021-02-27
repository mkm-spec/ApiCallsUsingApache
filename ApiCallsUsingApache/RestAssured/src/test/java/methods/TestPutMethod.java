package methods;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;

import org.junit.Before;
import org.junit.Test;

import io.restassured.RestAssured;

public class TestPutMethod {

	private static Map<String, String> bodyData = new HashMap<String, String>();
 	
	@Before
	public void createBodyData() {
		bodyData.put("userId", "2");
		bodyData.put("id", "19");
		bodyData.put("title", "this is projectdebug.com");
		bodyData.put("body", "change it");	
		RestAssured.baseURI = "http://jsonplaceholder.typicode.com";
		RestAssured.basePath = "/posts/";
	}
	
	@Test
	public void testPutMethod() {
		given()
			.contentType("application/json")
			.body(bodyData).
		when()
			.put("/100").
		then()
			.statusCode(200)
			.and()
			.body("title", equalTo("this is projectdebug.com"));
	}
}
