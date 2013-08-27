package com.redhat.openshift.impl;

import com.redhat.json.JSONConverter;
import com.redhat.json.JSONConverterFactory;
import com.redhat.openshift.Methods;
import com.redhat.openshift.RestConnector;
import com.redhat.openshift.User;
import com.redhat.openshift.UserManager;

public class UserManagerImpl implements UserManager
  {
	private RestConnector conn = null;
	
	public UserManagerImpl(RestConnector conn)
	  {
		this.conn = conn;
	  }
	
	@Override
	public User getUserInfo() 
	  {
		String jsonResponse = null;
		JSONConverter converter = null;
		User user = null;
		
		jsonResponse = conn.execGet(Methods.USER);
		converter = JSONConverterFactory.getConverter();
    	user = (User)converter.fromJSON(jsonResponse, com.redhat.openshift.impl.User.class);
    	
		return(user);
	  }
  }
