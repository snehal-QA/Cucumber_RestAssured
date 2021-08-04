package practice;


public class resolvecomplexjson {

	public static void main(String[] args) {
					
		//To get number of courses.
		int noofcourses=parsejson.rawtojson(payload.Practicejson()).getInt("courses.size()");
		System.out.println("Total number of courses: "+noofcourses);
		
		
		// Print PurchaseAmount
		String purchaseamount=(parsejson.rawtojson(payload.Practicejson())).getString("dashboard.purchaseAmount");
		System.out.println("Purchase Amount: "+(parsejson.rawtojson(payload.Practicejson())).getString("dashboard.purchaseAmount"));
        
		
		//Print Title of first course
		System.out.println("Title of first course: "+parsejson.readjson(payload.Practicejson(),"courses[0].title"));
		
		//Print Title of the first course
		for(int i=0;i<noofcourses;i++)
		{
			System.out.println("Title of "+(i+1)+" course: "+parsejson.readjson(payload.Practicejson(),"courses["+i+"].title"));
		}
		
		//Print All course titles and their respective Prices
		for(int i=0;i<noofcourses;i++)
		{
			System.out.println("Course Title: "+parsejson.readjson(payload.Practicejson(),"courses["+i+"].title")
			+" CoursePrice: "+parsejson.readjson(payload.Practicejson(),"courses["+i+"].price"));
		}
		
		//Print no of copies sold by RPA Course
		for(int i=0;i<noofcourses;i++)
		{
			String coursename=parsejson.readjson(payload.Practicejson(),"courses["+i+"].title");
			System.out.println(coursename);
			if(coursename.equalsIgnoreCase("RPA"))
			{
		       System.out.println("No. of copies sold by RPA course: "
			      +parsejson.readjson(payload.Practicejson(),"courses["+i+"].copies"));
		       break;
			}  	     
		     
		}
		
		//Verify if Sum of all Course prices matches with Purchase Amount
		int sum=0;
		for(int i=0;i<noofcourses;i++)
		{
		    int copies=parsejson.rawtojson(payload.Practicejson()).getInt("courses["+i+"].copies");
			sum=(parsejson.rawtojson(payload.Practicejson()).getInt("courses["+i+"].price")*copies)+sum;
		}
		 System.out.println(sum);
	}

	
}
