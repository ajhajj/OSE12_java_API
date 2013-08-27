package com.redhat.test;

import com.redhat.json.JSONConverter;
import com.redhat.json.JSONConverterFactory;

public class JSONTest 
  {
	private static JSONConverter jcon = null;
	
	public static void main(String[] args)
	  {
	    jcon = JSONConverterFactory.getConverter();
	    testToJSON();
	    testFromJSON();
	  }
	
    public static void testToJSON()
      {
    	String jsonString = null;
    	
    	jsonString = jcon.toJSON(new TestObj());
    	System.out.println("Testing to JSON string:");
        System.out.println(jsonString);
      }
	
    public static void testFromJSON()
      {
    	TestObj test = (TestObj)jcon.fromJSON("{\"firstName\":\"Amritpal\",\"lastName\":\"Jhajj\",\"favoriteNum\":100}", TestObj.class);
    	System.out.println("\n\nTesting from JSON string:");
        System.out.println("First Name: " + test.firstName);
        System.out.println("Last Name: " + test.lastName);
        System.out.println("Favorite Number: " + test.favoriteNum);
      }
  }
