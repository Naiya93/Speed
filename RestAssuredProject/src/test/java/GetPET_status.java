import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class GetPET_status {

	@Test
	void Get_Pet() {
		
		System.out.println("--------------------Get PET by id---------------------------");
		baseURI="https://petstore.swagger.io";
		
		given().get("/v2/pet/100").then().statusCode(200).log().all();
	}
	
	@Test
	void Get_Petbystatus() {
		
		System.out.println("--------------------Get PET by Status---------------------------");
		baseURI="https://petstore.swagger.io";
		
		given().get("/v2/pet/findByStatus?status=available").then().statusCode(200)
		.body("data.id",equalTo(100)); 
	  //.log().all();
	}
}
