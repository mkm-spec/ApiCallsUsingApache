package methods;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.Ignore;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestGetMethod {

	private Response response;
	
	@BeforeClass
	public static void init() {
		RestAssured.BaseURI = "https://reqres.in/";
		RestAssured.BasePath = "/api";
	}
	
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
	public void testGetMethodWithLogsAndResponseBody() {
		
		RestAssured.basePath = "/api/users?page=2";
		
		Response response = given().r
		when().
		get(/users?page=2);
		
		System.out.println(response.body().asString());
		//given().log().all().get().then().log().all().body("data[0].id", equalTo(7));
	}
	
	@Test
	@Ignore
	public void testUsingBasicAuthentication(String user, String pass) {
		given().
			authenticate(httpBuilder);
		
		get();
	}
	
	
}
