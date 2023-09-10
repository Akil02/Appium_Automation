package Learning_Rest.Learning;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SampleDelete {

	@Test
	public void Delete() {
		RestAssured.baseURI = "https://petstore.swagger.io";
		Response r = RestAssured.given().when().delete("v2/user/JegaVarsan");
		System.out.println(r.getStatusCode());
		System.out.println(r.then().extract().asPrettyString().toString());
	}
}
