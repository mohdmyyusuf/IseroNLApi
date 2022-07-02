package restAssuredPack;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestCU {
	
	@Test(dataProvider = "userdetailssupplier", dataProviderClass = com.inl.test.util.DataSupplierClass.class)
	public void createUser(String name, String job) {
	/*PreemptiveBasicAuthScheme scheme = new PreemptiveBasicAuthScheme();
	scheme.setUserName("test");
	scheme.setPassword("dada");
	
	RestAssured.authentication = scheme;*/
		
		RestAssured.baseURI = "https://reqres.in";
		RequestSpecification httpreq = RestAssured.given();
		
		JSONObject obj = new JSONObject(); //Jsonobject is used to pass the parameters to the post request.
		obj.put("name", name);
		obj.put("job", job);
		httpreq.header("Content-Type", "application/json");
		httpreq.body(obj.toJSONString());
		Response response = httpreq.request(Method.POST, "/api/users");
		String respBody = response.body().asString();
		System.out.println(respBody);
	}
	
	/*@DataProvider(name = "user details supplier")
	public String[][] getUserData(){
			
			String uservlues[][] = {{"yusuf","test"},{"khan","engg"},{"MY","arch"}, };
			
			return uservlues;
		}*/

}
