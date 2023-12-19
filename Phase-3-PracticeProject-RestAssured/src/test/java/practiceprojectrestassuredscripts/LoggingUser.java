package practiceprojectrestassuredscripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class LoggingUser {
	@Test
	public void Logging_Request() {
		Response response = RestAssured.given().baseUri("https://reqres.in").basePath("/api/unknown")
				.contentType("application/json").when().get().then().statusCode(200).log().all().extract().response();
		System.out.println(response.getBody().asPrettyString());
		System.out.println("Status Code " + response.getStatusCode());
		System.out.println("Response Time: " + response.getTime());
		System.out.println("Content Type: " + response.getHeader("ContentType"));
		int expectStatusCode = 200;
		int ActualStatusCode = response.getStatusCode();
		Assert.assertEquals(expectStatusCode, ActualStatusCode);
	}
}
