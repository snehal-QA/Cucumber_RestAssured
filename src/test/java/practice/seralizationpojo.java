package practice;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojo.addPlace;
import pojo.getPlace;
import pojo.location;

import static io.restassured.RestAssured.*;


import java.util.ArrayList;
import java.util.List;

public class seralizationpojo {

	public static void main(String[] args) {
		RestAssured.baseURI="https://rahulshettyacademy.com";
		//To form a body using deserailzation:
		addPlace ap=new addPlace();
		ap.setAccuracy(50);
		ap.setName("Frontline house");
		ap.setAddress("29, side layout,walkerstreet");
		ap.setPhone_number("(+91) 983 893 3937");
		ap.setWebsite("http://google.com");
		ap.setLanguage("French-IN");
		//Setting location
		location l=new location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		ap.setLocation(l);
		//Setting types
		List<String> l1=new ArrayList<String>();
		l1.add("shoe park");
		l1.add("shop");
		ap.setTypes(l1);
				
			
		Response r=given()
			.queryParam("key", "qaclick123")
			.body(ap)
		.when()
			.post("/maps/api/place/add/json")
		.then()
			.assertThat()
			.statusCode(200)
			.log().all()
			.extract().response();
		
		//Extract place_id from response.
		String js=parsejson.readjson(r.asString(),"place_id");
		 
		
		//Seralization
		getPlace gp=given()
			.queryParam("place_id",js)
			.queryParam("key","qaclick123")
			.expect().defaultParser(Parser.JSON).
		when()
			.get("/maps/api/place/get/json")
			.as(getPlace.class);
	   System.out.println(gp.getAddress());

	}

}
