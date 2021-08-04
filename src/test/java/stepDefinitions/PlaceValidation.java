package stepDefinitions;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.addPlace;
import pojo.location;
import practice.parsejson;
import resources.APIResources;
import resources.PayloadBuilder;
import resources.utils;

public class PlaceValidation extends utils {
	
	RequestSpecification reqspec;
	ResponseSpecification res;
	Response response;
	
	@Given("we use Addplace payload with post request")
	public void we_use_addplace_payload_with_post_request() throws IOException {
		
		//To form a body using deserailzation:	
		addPlace payload=PayloadBuilder.getaddplacejson();
		
		///
		reqspec=given().spec(requestSpecification()).body(payload);
				
	}

	@When("user calls this {string}")
	public void user_calls_this(String addplaceresource) {
		
		APIResources resources=APIResources.valueOf(addplaceresource);
		System.out.println("Value of enum: "+resources.getresource());
		
		res=new ResponseSpecBuilder()
				.expectStatusCode(200)
				.expectContentType(ContentType.JSON)
				.build();
		response=reqspec
	    		.when()
	    		.post(addplaceresource)
	    		.then()
	    		.spec(res)
	    		.extract()
	    		.response();
	}

	@Then("Response code {int} is returned")
	public void response_code_is_returned(int int1) {
		assertEquals(response.getStatusCode(),int1);
	    
	}
	
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String expectedvalue) {
		String valueatkey=parsejson.readjson(response.asString(), key);
	    assertEquals(valueatkey,expectedvalue);
	}



}
