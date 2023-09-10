package Learning_Rest.Learning;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import io.restassured.path.json.JsonPath;

public class SampleGet {

//	@Test
	public void GetCall() {
		RestAssured.baseURI = "https://petstore.swagger.io";
		Response restp = RestAssured.given().param("username", "JegaVarsan1")
				.param("password", "1234").log().params().when().get("/v2/user/login");
	    System.out.println(restp.getStatusCode());
	   System.out.println(restp.asPrettyString().toString());
	}
	
	
	
	
}
