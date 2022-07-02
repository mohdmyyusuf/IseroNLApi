package restAssuredPack;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ExtractNodeValues {
	
	@Test
	public void extractNodes() {
		
		RestAssured.baseURI = "https://reqres.in";
		RequestSpecification httpreq = RestAssured.given();
		Response resp = httpreq.request(Method.GET, "/api/users/2");
		
		//String respBody = resp.getBody().asString();
		//System.out.println(respBody);
		 
		JsonPath jspath = resp.jsonPath();
		
		System.out.println(jspath.get("data"));
		 
		
		
		
	}

}
