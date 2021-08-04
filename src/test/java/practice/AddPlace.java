package practice;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;

public class AddPlace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI="https://rahulshettyacademy.com";
	String response=	given().queryParam("key","qaclick123").header("Content-type","application/json")
				.body(payload.Addplace())
		.when().post("maps/api/place/add/json")
		
/*		To read the response value from body directly use body and then use equalTo method 
		of hamcrest to asset the value:
		
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
 */
		
		/* To extract response message as a String  */
		.then().assertThat()
		.header("Server","Apache/2.4.18 (Ubuntu)")
		.statusCode(200)
		.extract().response().asString();
	
	System.out.println(response);
	
	//However it is very difficult to assert in string vakues thus we have to parse /string to Json
	String placeid=parsejson.readjson(response,"place_id");
	System.out.println(placeid);
	
	
	//Update place API
	String address="New address 121 walkstreet";
	given()
	  .queryParam("key","qaclick123")
	  .body(payload.UpdatePlace(placeid, address)).
	when()
	.put("maps/api/place/update/json")
	.then().log().all().statusCode(200)
	.body("msg", equalTo("Address successfully updated"));
	

	//GetPlaceAPI
	given()
	  .queryParam("place_id",placeid)
	  .queryParam("key","qaclick123").
	when()
	  .get("maps/api/place/get/json").
	then()
	  .log().all()
	  .statusCode(200)
	  .assertThat().body("address",equalTo(address));

	
	}

}
