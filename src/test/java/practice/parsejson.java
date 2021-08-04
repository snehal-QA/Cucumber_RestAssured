package practice;

import io.restassured.path.json.JsonPath;

public class parsejson {
	
	public static String readjson(String response,String key)
	{
		JsonPath js= new JsonPath(response);
		return js.getString(key);
	}
	
	public static JsonPath rawtojson(String response)
	{
		JsonPath js= new JsonPath(response);
		return js;
		
	}

}
