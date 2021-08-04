package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.addPlace;
import pojo.location;



public class PayloadBuilder {
	
	public static  addPlace getaddplacejson()
	{
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
		return ap;
	}
}