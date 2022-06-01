package Speed;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import java.io.File;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;


public class Testdemo {

	@Test
	public void validateschema() {
			
			baseURI="https://reqres.in/api";
			
			given();
			get("/users?page=2").
			then()
			//assertThat().body((JsonSchemaValidator.matchesJsonSchemaInClasspath(new File("/RestAssuredProject/src/test/java/Speed/scheema.json"))).
			//.assertThat().body(JsonSchemaValidator
		    	//	  .matchesJsonSchema(new File("D:\\Automation\\RestAssured\\RestAssured\\RestAssuredProject\\target\\classes\\scheema.json")))
					//.statusCode(200).log().all();
			.assertThat().body(matchesJsonSchemaInClasspath("scheema.json"))
			.log().all();
	}
		}
	

