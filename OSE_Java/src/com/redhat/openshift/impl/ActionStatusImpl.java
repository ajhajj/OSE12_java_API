package com.redhat.openshift.impl;

import com.redhat.openshift.ActionStatus;
import com.redhat.openshift.Message;

public class ActionStatusImpl implements ActionStatus 
  {
	MessageImpl[] messages = null;
	String status = null;
	
	@Override
	public String getActionStatus() 
	  {
		return(status);
	  }

	@Override
	public Message[] getMessages() 
	  {
		return((Message[])messages);
	  }

	@Override
	public boolean hasMessages() 
	  {
		return(messages != null);
	  }
  }
