package Learning_Rest.Learning;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class Sample {

	@Test
	public void GetCall() {
	/*	RestAssured.baseURI = "https://petstore.swagger.io/";
		System.out.println(RestAssured.given().param("status", "available").when().get("v2/pet/findByStatus").then().extract().statusCode());
		Response res = RestAssured.given().param("status", "available").when().get("v2/pet/findByStatus");
	    res.prettyPrint();
	    System.out.println(res.asString());  */
		RestAssured.baseURI = "https://reqres.in/";
		Response rest = RestAssured.given().when().get("api/users");
		System.out.println("Status code :"+rest.getStatusCode());
		String a= rest.then().extract().asPrettyString().toString();
		System.out.println(a);
		JsonPath p = new JsonPath(a);
		List<String> at = new ArrayList<String>();
	/*    at.add(p.getString("data.first_name"));
	    System.out.println(at.size());
	    for(String s : at) {
	    	System.out.println("The values of id is : "+s);
	    }  */
	    System.out.println("This is to check the "+rest.contentType());
	    
	    System.out.println(p.getList("data.first_name"));
	    System.out.println(p.getString("total"));
	    System.out.println("Third name : "+p.getString("data[3].first_name"));
	    List<String> s = p.getList("data.first_name");
	    for(int i = 0;i<s.size();i++) {
	    	System.out.println("Value of "+i+" is :"+s.get(i));
	    }
	    rest.then().contentType(ContentType.JSON).and().body("data[3].first_name", equalTo("Eve"));
	    
}
}
