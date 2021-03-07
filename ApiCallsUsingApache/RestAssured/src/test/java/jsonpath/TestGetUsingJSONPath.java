package jsonpath;

import static io.restassured.RestAssured.given;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestGetUsingJSONPath {
	
	public static Response res;
	@Before
	public void setup(){
		RestAssured.baseURI = "https://postman-echo.com";
		RestAssured.basePath = "/GET";
		res = given()
				.when()
				.get();
	}

	@Test
	public void testBody(){
		String json = res.getBody().asString();
		JsonPath jsonPath = new JsonPath(json);
		String str = jsonPath.getJsonObject("headers.x-forwarded-port");
		System.out.println("Port Found : "+str);
		Assert.assertEquals(str, "443");
	}

}
