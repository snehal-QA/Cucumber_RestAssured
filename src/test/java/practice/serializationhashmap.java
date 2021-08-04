package practice;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import serialize_deseralize_hashmap.Addplace_hashmap;

public class serializationhashmap {

	public static void main(String[] args) throws JsonProcessingException {
		
		String addplacejson= new ObjectMapper().writeValueAsString(Addplace_hashmap.addplace_json());
		System.out.println(addplacejson);
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		Response r=given()
				.queryParam("key", "qaclick123")
				.body(addplacejson)
			.when()
				.post("/maps/api/place/add/json")
			.then()
				.assertThat()
				.statusCode(200)
				.log().all()
				.extract().response();
		
		String placeid=parsejson.readjson(r.asString(),"place_id");
		
		//deserialize
		String gp=given()
				.queryParam("place_id",placeid)
				.queryParam("key","qaclick123").
			when()
				.get("/maps/api/place/get/json").asString();
		System.out.println(gp);
		
		//Convert json text response to Hashmap
		Map<String,Object> getresponsemap=new ObjectMapper().readValue(gp, Map.class);
		System.out.println(getresponsemap);
		System.out.println(getresponsemap.size());
		
		String loc="location";
		 
		// Print Linked Hashmap from Hashmap
		System.out.println(((Map)getresponsemap.get(loc)).get("latitude"));
		((Map)getresponsemap.get(loc)).forEach((k, v) -> System.out.println((k + ":" + v)));
		
		// Print Array from Array
		System.out.println(Addplace_hashmap.addplace_json().get("types").getClass().getSimpleName());
		//System.out.println(getresponsemap.get("types"));
		((ArrayList)Addplace_hashmap.addplace_json().get("types")).forEach(k -> System.out.println(k));
		
	}

}
