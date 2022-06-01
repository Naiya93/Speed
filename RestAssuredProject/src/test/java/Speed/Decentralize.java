package Speed;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import java.lang.reflect.Member;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.ITestContext;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Models.Gettoken;
import Models.Token;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Decentralize {

	RequestSpecification httpRequest;

	 //@BeforeMethod

	
	 public void setup() 
	 { baseURI="https://devappapi.tryspeed.com";
	 basePath="/login"; }
	 

	@Test
	public void login(ITestContext context) {


		Token user = new Token("naiya+21@tryspeed.com", "Test@123");

		baseURI = "https://devappapi.tryspeed.com/login";

		// Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		// String body=gson.toJson(user);


		Response httpRequest = 
			(Response)	given()
				.baseUri(baseURI)
				.headers("Content-Type", "application/json")
				.accept(ContentType.JSON)
				.body(user)
				.when()
				.post()
				.andReturn();
			
		
	/*	int statuscode=httpRequest.getStatusCode();
		        assertEquals(statuscode, 200);*/

		       
		        
	    
		Gettoken tk = httpRequest.getBody().as(Gettoken.class);
		//System.out.println(tk.toString());
		
			
		//System.out.println("this is IDTOKEN "+ tk.getId_token());
		
		String Authorization=tk.getId_token();
		System.out.println("this is Id Token "+ Authorization);
		

		String Access=tk.getAccess_token();
		System.out.println("this is Access Token "+ Access);

		String session=tk.getSession();
		System.out.println("this is Session "+ session);
		
		
		
		
		context.setAttribute("idtoken", Authorization);
		
		context.setAttribute("accesstoken", Access);
		context.setAttribute("sid", session);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		 * Response resp= httpRequest //.log() //.all() .when() .post() .andReturn();
		 */
		/*
		 * .then() .statusCode(200) //.statusLine("200 OK") .log() .all() .andReturn();
		 */

		/*
		 * Gettoken gtoken=resp.getBody().as(Gettoken.class);
		 * 
		 * 
		 * String t=(gtoken.getId_token()); System.out.println(t);
		 */
		/*
		 * Token token=resp.getBody().as(Token.class);
		 * System.out.println(token.toString());
		 */

		/*
		 * String idToken = resp.jsonPath().getString("id_token");
		 * System.out.println(idToken.toString());
		 */

	}
}
