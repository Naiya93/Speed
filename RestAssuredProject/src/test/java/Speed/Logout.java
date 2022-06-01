package Speed;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Logout {

	@Test
	
	public void Logoutt(ITestContext context) {
	
		
		System.out.println("Logout running");
	baseURI="https://devappapi.tryspeed.com/logout";
	
	String idt=(String) context.getAttribute("idtoken");
	String at=(String) context.getAttribute("accesstoken");
	String s=(String) context.getAttribute("sid");
	
	
	
	JSONObject request=new JSONObject(); 
	request.put("session",s);

	
	given().baseUri(baseURI)
		.headers("Authorization",idt)
	.headers("Access",at)
//	.headers("session",s)
	.headers("Content-Type","application/json")
	.contentType(ContentType.JSON)
	.body(request.toJSONString())
	.when()
	.post()
	.then()
	.statusCode(200);
	

	
	}
}
