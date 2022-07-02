package restAssuredPack;

import java.util.Iterator;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class GetRequestTests {

	@Test
	public void shotGetReq() {
		
		RestAssured.baseURI = "https://reqres.in";
		RequestSpecification httpreq = RestAssured.given();
		Response response = httpreq.request(Method.GET, "/api/users?page=2");
		
		String res =  response.getBody().asString();
		System.out.println(res);
		
		int rescode = response.getStatusCode();
		Assert.assertEquals(200, rescode);	
		
		String statusLine = response.getStatusLine();
		System.out.println(statusLine);
		Assert.assertEquals("HTTP/1.1 200 OK", statusLine);
		
		Assert.assertEquals(res.contains("254545"), true);
		
		String contentType = response.getContentType();
		System.out.println(contentType);
		
		Headers allHeaders = response.headers();
		
		for (Header head: allHeaders) {
			System.out.println(head.getName());
			System.out.println(head.getValue());
			System.out.println(head.getClass());
			
		}
	}
	
}
