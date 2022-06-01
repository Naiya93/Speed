package Speed;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Tests {


	
	@BeforeMethod
	
	public static void setupp() {
		baseURI="https://devappapi.tryspeed.com";
		basePath="/login";
	}
	
	@Test
	public static void login() {
		
		
		System.out.println("------------Logoin starts-----------");
		//baseURI="https://devappapi.tryspeed.com/login";
		
		JSONObject req=new JSONObject();
		req.put("email", "naiya+21@tryspeed.com");
		req.put("password", "Test@123");
		
	Response response = RestAssured.given()
			//.baseUri(baseURI)
		.headers("Content-Type","application/json")
		.accept(ContentType.JSON)
		.body(req.toJSONString())	
			.when()
		.post()
		.then()	
	    .statusCode(200)
		//.statusLine("200 OK")
		//.log()
		//.all()
		.extract()
        .response();
	  
	
	String idtoken= response.asString();
	String idToken = response.jsonPath().getString("id_token");
	String atoken = response.jsonPath().getString("access_token");
	String session = response.jsonPath().getString("session");
	
	System.out.println(idtoken);
	System.out.println("idtoken is:- "+ idToken);
	System.out.println("access token is:- "+ atoken);
	System.out.println("session is:- "+ session);
	  //String idToken = response.jsonPath().getString("id_token");
	}

	/*public class logoutclass extends Tests
	{
	
@Test
public void Logout()  {
	
	System.out.println("------------Logout starts-----------");
	
	baseURI="https://devappapi.tryspeed.com/logout";
	
	given()
	.headers("Authorization",idToken)
	.headers("Access",atoken)
	.headers("session",session)
	.headers("Content-Type","application/json")
	.when()
	.post(baseURI)
	.then()
	.statusCode(200);
	
	
}
	
}*/
}

	
	
	
	
	


	
	

