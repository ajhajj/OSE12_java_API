package com.redhat.json;

public interface JSONConverter 
  {
	public String toJSON(Object obj);
	public Object fromJSON(String str, Class<?> type);
  }
