package requestspecifications;

import org.junit.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

public class TestRequestSpecification {


	@Test
	public void testRequestSpecification() {
		RequestSpecification requestSpec = new  RequestSpecBuilder()
				.setContentType("application/json")
				.setBaseUri("http://localhost:3000/")
				.addQueryParam("author_id","5")
				.build();
					
			given()
				.spec(requestSpec)
				.log().uri()
			.when()
				.get("/books")
			.then()
				.statusCode(200)
				.log().body();
						
	}
}
