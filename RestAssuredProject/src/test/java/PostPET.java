import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;



public class PostPET {

	@Test
	void Post_Pet() {
		
		JSONObject request=new JSONObject(); 
		request.put("name","Johnyy");
		request.put("job", "Mechanic");
		
		//baseURI="https://reqres.in/api/users";
		baseURI="https://reqres.in";
		
		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		headers("Content-Type","application/json").
		body(request.toJSONString()).
		when().post("/api/users").
		then().
		statusCode(201).log().all();
	}
}
