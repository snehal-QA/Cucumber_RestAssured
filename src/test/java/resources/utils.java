package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class utils {
	
	RequestSpecification req;
	ResponseSpecification res;
	PrintStream log;
	public RequestSpecification requestSpecification() throws IOException
	{
		log=new PrintStream(new FileOutputStream("logging.txt"));
		
		RequestSpecification req=new RequestSpecBuilder()
//				.setBaseUri("https://rahulshettyacademy.com")
				.setBaseUri(readpropertyvalue("baseurl"))
				.addQueryParam("key", "qaclick123")
				.setContentType("application/json")
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.build();
		return req;
	}
	
	public static String readpropertyvalue(String Key) throws FileNotFoundException, IOException
	{
		Properties prop=new Properties();
		//FileInputStream fis=new FileInputStream("//RestAssured//src//test//java//resources//global.properties");
		//FileInputStream fis=new FileInputStream("C:\\SnehProjects\\API framework-RestAssured\\RestAssured\\src\\test\\java\\resources\\global.properties");
		FileInputStream fis=new FileInputStream("src/test/java/resources/global.properties");
		prop.load(fis);
		return prop.getProperty("baseurl");
	}
	

}
