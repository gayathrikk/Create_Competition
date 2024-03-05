package com.test.Code4humanity;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Code4humanity_apis {
	
	 @Test(priority=1)
	 public void analyticsActivities()
	 
	    {
	    	//app atlas registration
	    	Response response1 = RestAssured
	    		    .given()
	    		    .auth()
	    		    .basic("admin", "admin")
	    		    .when()
	    		    .get("http://code4humanity.humanbrain.in:8000/analytics/analyticsActivities");

	        int statusCode1 = response1.getStatusCode();
	        if (statusCode1 == 200) {
	            System.out.println("API request to the analytics activities passed. Status code: " + statusCode1);
	        } else {
	            System.out.println("API request to the analytics activities failed. Status code: " + statusCode1);
	        }
	        Assert.assertEquals(statusCode1, 200, "API request to the analytics activities failed");
	        
	    }
	 @Test(priority=2)
	 public void Jobdetails()
	 
	    {
	    	//app atlas registration
	    	Response response1 = RestAssured
	    		    .given()
	    		    .auth()
	    		    .basic("admin", "admin")
	    		    .when()
	    		    .get("http://code4humanity.humanbrain.in:8000/analytics/jobDetailes/57");

	        int statusCode1 = response1.getStatusCode();
	        if (statusCode1 == 200) {
	            System.out.println("API request to the job details passed. Status code: " + statusCode1);
	        } else {
	            System.out.println("API request to the job details failed. Status code: " + statusCode1);
	        }
	        Assert.assertEquals(statusCode1, 200, "API request to the job details failed");
	        
	    }
	 
	 @Test(priority=3)
	 public void code()
	 
	    {
	    	//app atlas registration
	    	Response response1 = RestAssured
	    		    .given()
	    		    .auth()
	    		    .basic("admin", "admin")
	    		    .when()
	    		    .get("http://dgx3.humanbrain.in:8881/lab");

	        int statusCode1 = response1.getStatusCode();
	        if (statusCode1 == 200) {
	            System.out.println("API request to the code details passed. Status code: " + statusCode1);
	        } else {
	            System.out.println("API request to the code details failed. Status code: " + statusCode1);
	        }
	        Assert.assertEquals(statusCode1, 200, "API request to the code details failed");
	        
	    }
	 
	 

}
