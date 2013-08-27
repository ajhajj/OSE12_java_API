package com.redhat.json.impl;

import com.google.gson.Gson;
import com.redhat.json.JSONConverter;

public class GsonEngine implements JSONConverter 
  {
	private Gson gson = null;

	public GsonEngine()
	  {
		gson = new Gson();
	  }
	
	public String toJSON(Object obj)
	  {
		return(gson.toJson(obj));
	  }
	
	public Object fromJSON(String str, Class<?> type)
	  {
		return(gson.fromJson(str, type));
	  }
  }
