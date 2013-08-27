package com.redhat.openshift;

public interface DomainInfo extends ActionStatus
  {
	public String getId();
	
	public String getSuffix();
	
	public String getType();
	
	public String getStatus();
  }
