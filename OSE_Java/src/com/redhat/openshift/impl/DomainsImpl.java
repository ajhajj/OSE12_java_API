package com.redhat.openshift.impl;

import com.redhat.openshift.Domain;
import com.redhat.openshift.Domains;

public class DomainsImpl extends ActionStatusImpl implements Domains
  {
	private DomainImpl[] data = null;
	
	public Domain[] getDomains()
	  {
		return(data);
	  }
	
	public static class DomainImpl implements Domain
	  {
		private String id = null;
		private String suffix = null;
		
		public String getId()
		  {
			return(id);
		  }
		
		public String getSuffix()
		  {
			return(suffix);
		  }
	  }
  }
