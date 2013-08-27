package com.redhat.openshift.impl;

import com.redhat.openshift.DomainInfo;

public class DomainInfoImpl extends ActionStatusImpl implements DomainInfo 
  {
	DomainInfoData data = null;
	
	@Override
	public String getId() 
	  {
		String id = null;
		
		if(data != null)
		  id = data.getId();
		
		return(id);
	  }

	@Override
	public String getSuffix() 
	  {
		String suffix = null;
		
		if(data != null)
		  suffix = data.getSuffix();
		
		return(suffix);
	  }

	@Override
	public String getStatus() 
	  {
		String status = null;
		
		if(data != null)
		  status = data.getStatus();
		
		return(status);
	  }

	@Override
	public String getType() 
	  {
		String type = null;
		
		if(data != null)
		  type = data.getType();
		
		return(type);
	  }
	
	public class DomainInfoData
	  {
		String id = null;
		String suffix = null;
		String status = null;
		String type = null;
		
		public String getId() 
		  {
			return(id);
		  }

		public String getSuffix() 
		  {
			return(suffix);
		  }

		public String getStatus() 
		  {
			return(status);
		  }

		public String getType() 
		  {
			return(type);
		  }
	  }
  }
