package com.redhat.openshift;

import com.redhat.openshift.impl.DomainManagerImpl;
import com.redhat.openshift.impl.UserManagerImpl;

public class ManagerFactory 
  {
	RestConnector conn = null;
	
	public ManagerFactory(String user, String password, String host)
	  {
		conn = new RestConnector(user, password, host);
	  }
	
	public UserManager getUserManager()
	  {
		UserManager mgr = null;
		
		mgr = new UserManagerImpl(conn);
		return(mgr);
	  }
	
	public DomainManager getDomainManager()
	  {
		DomainManager mgr = null;
		
		mgr = new DomainManagerImpl(conn);
		return(mgr);
	  }
  }
