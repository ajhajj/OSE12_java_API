package com.redhat.json;

import com.redhat.json.impl.GsonEngine;

public class JSONConverterFactory 
  {
    static public JSONConverter getConverter()
      {
    	return(new GsonEngine());
      }
  }
