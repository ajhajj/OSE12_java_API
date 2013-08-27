package com.redhat.openshift.impl;

import com.redhat.openshift.Message;

public class MessageImpl implements Message 
  {
	int exit_code;
	String field = null;
	String severity = null;
	String text = null;
	
	@Override
	public int getExitCode() 
	  {
		return(this.exit_code);
	  }

	@Override
	public String getField() 
	  {
		return(this.field);
	  }

	@Override
	public String getSeverity() 
	  {
		return(this.severity);
	  }

	@Override
	public String getText() 
	  {
		return(this.text);
	  }
  }
