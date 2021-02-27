package methods;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.Ignore;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestGetMethod {

	private Response response;
	
	@Test
	@Ignore
	public void testStatusCode() {
		get("https://postman-echo.com/GET").then().statusCode(200);
	}
	
	@Test
	@Ignore
	public void testBody(){
		get("https://postman-echo.com/GET").then().assertThat()
               .body("headers.host", equalTo("postman-echo.com"));
	}
	
	@Test
	@Ignore
	public void testHeader(){
		get("https://postman-echo.com/GET").then()
               .header("Content-Length", "305");
	}
	
	@Test
	public void testGetMethod1() {
		RestAssured.baseURI = "https://reqres.in/";
		RestAssured.basePath = "/api/users?page=2";
		
		given().log().all().get().then().log().all().body("data[0].id", equalTo(7));
	}
}
