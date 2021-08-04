package serialize_deseralize_hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Addplace_hashmap {
	
	public static Map<String,Object> addplace_json()
	{
	  //For location subjson
	  Map<String, Double> locationmap=new HashMap();
	  locationmap.put("lat", -38.383494);
	  locationmap.put("lng", 33.427362);
	  
	  //For Array
	  ArrayList<String> typearr=new ArrayList<String>();
	  typearr.add("shoe park");
	  typearr.add("shop");
	  
	  //ArrayList<String> typearr2=Stream.of("shoe park","shop").collect().toList();
	  
	  //Complete JSON
	  Map<String,Object> addplacemap=new HashMap<String,Object>();
	  addplacemap.put("location",locationmap);
	  addplacemap.put("accuracy", 50);
	  addplacemap.put("name", "new home");
	  addplacemap.put("phone_number", "(+91) 983 893 3937");
	  addplacemap.put("address","220,walkerstreet, mangoes");
	  addplacemap.put("types",typearr);
	  addplacemap.put("website","http://google.com");
	  addplacemap.put("language","French-IN");
	  
	  System.out.println(addplacemap.get("accuracy").getClass().getSimpleName());
	  //Everything in hashmap is ready	
	  return addplacemap;
	}

}
