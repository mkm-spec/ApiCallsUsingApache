package testCases;


import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.apache.logging.log4j.Logger;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test_Get01 {

	public Response response;
	@BeforeClass
	public void init() {
		response = RestAssured.get("https://reqres.in/api/users?page=2");
	}
	@Test
	public void testGetResponse_200() {
		assertThat("Status code is NOT OK", response.getStatusCode(), is(equalTo(200)));
	}
	@Test
	public void testGetResponse_contains_first_name(String firstName) {
		firstName = "Rachel";
		//assetThat(response.getBody()("data.first_name"), hasItems("Rachel","Lindsay"));
	}
}
