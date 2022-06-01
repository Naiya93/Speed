package Speed;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

import java.lang.reflect.Member;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Login {
	
	RequestSpecification httpRequest;

	@BeforeMethod
	
	public void setup() {
		baseURI="https://devappapi.tryspeed.com";
		basePath="/login";
	}
	
	@Test
	public void login() {
		
		//baseURI="https://devappapi.tryspeed.com/login";
		
		JSONObject req=new JSONObject();
		req.put("email", "naiya+21@tryspeed.com");
		req.put("password", "Test@123");
		
	  given()
			//.baseUri(baseURI)
		.headers("Content-Type","application/json")
		.accept(ContentType.JSON)
		.body(req.toJSONString())	
			.when()
		.post()
		.then()	
	    .statusCode(200)
		//.statusLine("200 OK")
		.log()
		.all();
	}
}
       //String idToken = response.jsonPath().getString("id_token");

	 /* public static String encode(String str1, String str2) {
	        return new String(Base64.getEncoder().encode((str1 + ":" + str2).getBytes()));
	    }

	    public static Response getCode() {
	        String authorization = encode(username, password);

	        return
	                given()
	                        .header("authorization", "Basic " + authorization)
	                        .contentType(ContentType.URLENC)
	                        .formParam("response_type", "code")
	                        .queryParam("client_id", clientId)
	                        .queryParam("redirect_uri", redirectUri)
	                        .queryParam("scope", scope)
	                        .post("/oauth2/authorize")
	                        .then()
	                        .statusCode(200)
	                        .extract()
	                        .response();
	    }

	    public static String parseForOAuth2Code(Response response) {
	        return response.jsonPath().getString("code");
	    }

	    @BeforeAll
	    public static void setup() {
	        RestAssured.baseURI = "https://some-url.com";
	    }

	    @Test
	    public void iShouldGetCode() {
	        Response response = getCode();
	        String code = parseForOAuth2Code(response);

	        Assertions.assertNotNull(code);
	    }
	}
	
	
	
	} 
}*/
