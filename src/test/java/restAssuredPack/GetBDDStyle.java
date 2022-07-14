package restAssuredPack;

import org.testng.annotations.Test;

import com.inl.test.util.EndpointCreator;
import com.inl.test.util.XlUtilClass;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetBDDStyle {
		
	   //
		@Test(dataProvider = "userdetailssupplier", dataProviderClass = com.inl.test.util.DataSupplierClass.class)
		public void getUserDetail(String endpoint) {
			 String baseUri ="https://reqres.in/api" + endpoint;
			given().when().get(baseUri).then().statusCode(200).statusLine("HTTP/1.1 200 OK");
		}
}
