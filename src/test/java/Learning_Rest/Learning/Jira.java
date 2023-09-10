package Learning_Rest.Learning;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Jira {
     String name1 = "OR";
      String k = "";
      String h = "";
//	@Test
	public void KeyCreation() {
		String v = "{\r\n"
				+ "  \"username\": \"akilganesh3\",\r\n"
				+ "  \"password\": \"B9iTUpD4SS\"\r\n"
				+ "}";
		RestAssured.baseURI = "http://localhost:8080";
		Response res = RestAssured.given().contentType(ContentType.JSON).and().body(v).when().post("/rest/auth/1/session");
		System.out.println(res.then().extract().asPrettyString().toString());
		JsonPath jp = new JsonPath(res.then().extract().asPrettyString().toString());
		System.out.println(jp.getString("session.value"));
		System.out.println(res.getStatusCode());
		k = jp.getString("session.value");
		h = jp.getString("session.name");
	}
	
	@Test
	public void CreateIssue() {
		String v1 = "{\r\n"
				+ "    \"fields\": {\r\n"
				+ "       \"project\":\r\n"
				+ "       {\r\n"
				+ "          \"key\": \""+name1+"\"\r\n"
				+ "       },\r\n"
				+ "       \"summary\": \"Baking defects\",\r\n"
				+ "       \"description\": \"Sample defect to check in postman\",\r\n"
				+ "       \"issuetype\": {\r\n"
				+ "          \"name\": \"Bug\"\r\n"
				+ "       }\r\n"
				+ "   }\r\n"
				+ "}";
		System.out.println("JSESSIONID=2A1D9AA67268D5A6C638DD45F9C3BAA8");
		RestAssured.baseURI = "http://localhost:8080";
		Response res = RestAssured.given().header("Cookie", "JSESSIONID=2059A419179B0CD5F4EA5D4517292853").contentType(ContentType.JSON).body(v1).when().post("/rest/api/2/issue");
	//	res.then().statusCode(201);
		System.out.println(res.statusCode());
	}
	
	
}
