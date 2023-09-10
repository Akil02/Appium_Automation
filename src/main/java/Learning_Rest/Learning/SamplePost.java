package Learning_Rest.Learning;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class SamplePost {

	String val = "{\r\n"
			+ "    \"id\": 9223372036854763410,\r\n"
			+ "    \"username\": \"JegaVarsan1\",\r\n"
			+ "    \"firstName\": \"Jega\",\r\n"
			+ "    \"lastName\": \"Varsan\",\r\n"
			+ "    \"email\": \"string\",\r\n"
			+ "    \"password\": \"128795\",\r\n"
			+ "    \"phone\": \"string\",\r\n"
			+ "    \"userStatus\": 0\r\n"
			+ "}";
	
	@Test
	public void PostCall() {
		RestAssured.baseURI = "https://petstore.swagger.io";
		Response restp = RestAssured.given().contentType(ContentType.JSON).and().body(val).when().post("/v2/user");
	    System.out.println(restp.getStatusCode());
	    JsonPath p = new JsonPath(restp.then().extract().asPrettyString().toString());
	    System.out.println(p.getString("message"));
	}
}
