package com.redhat.openshift.impl;

import java.util.HashMap;

import com.redhat.json.JSONConverter;
import com.redhat.json.JSONConverterFactory;
import com.redhat.openshift.ActionStatus;
import com.redhat.openshift.DomainInfo;
import com.redhat.openshift.DomainManager;
import com.redhat.openshift.Domains;
import com.redhat.openshift.Methods;
import com.redhat.openshift.RestConnector;

public class DomainManagerImpl implements DomainManager 
  {
	private RestConnector conn = null;
	
	public DomainManagerImpl(RestConnector conn)
	  {
		this.conn = conn;
	  }
	
	@Override
	public Domains getDomains() 
	  {
		String jsonResponse = null;
		JSONConverter converter = null;
		Domains doms = null;
		
		jsonResponse = conn.execGet(Methods.DOMAINS);
		if(jsonResponse != null)
		  {
			System.out.println(jsonResponse);
			converter = JSONConverterFactory.getConverter();
	    	doms = (Domains)converter.fromJSON(jsonResponse, com.redhat.openshift.impl.DomainsImpl.class);
		  }
    	
		return(doms);
	  }

	@Override
	public ActionStatus CreateDomain(String id) 
	  {
		JSONConverter converter = null;
		String jsonResponse = null;
		HashMap<String, String> map = null;
		ActionStatus actionStatus = null;
		
		map = new HashMap<String, String>();
		map.put("id", id);
		jsonResponse = conn.execPost(Methods.DOMAINS, map);
		if(jsonResponse != null)
		  {
			System.out.println(jsonResponse);
		    converter = JSONConverterFactory.getConverter();
		    actionStatus = (ActionStatus)converter.fromJSON(jsonResponse, com.redhat.openshift.impl.ActionStatusImpl.class);
		  }
		
		return(actionStatus);
	  }
	
	@Override
	public DomainInfo getDomainInfo(String id)
	  {
		String jsonResponse = null;
		JSONConverter converter = null;
		DomainInfo info = null;
		
		jsonResponse = conn.execGet(Methods.DOMAINS + "/" + id);
		if(jsonResponse != null)
		  {
			System.out.println(jsonResponse);
			converter = JSONConverterFactory.getConverter();
	    	info = (DomainInfo)converter.fromJSON(jsonResponse, com.redhat.openshift.impl.DomainInfoImpl.class);
		  }
    	
		return(info);
	  }

	@Override
	public DomainInfo updateDomainName(String oldName, String newName) 
	  {
		String jsonResponse = null;
		JSONConverter converter = null;
		DomainInfo info = null;
		HashMap<String, String> map = null;
		
		map = new HashMap<String, String>();
		map.put("id", newName);
		jsonResponse = conn.execPut(Methods.DOMAINS + "/" + oldName, map);
		if(jsonResponse != null)
		  {
			System.out.println(jsonResponse);
			converter = JSONConverterFactory.getConverter();
	    	info = (DomainInfo)converter.fromJSON(jsonResponse, com.redhat.openshift.impl.DomainInfoImpl.class);
		  }
    	
		return(info);
	  }

	@Override
	public ActionStatus deleteDomainName(String id) 
	  {
		JSONConverter converter = null;
		String jsonResponse = null;
		ActionStatus actionStatus = null;
		
		jsonResponse = conn.execDelete(Methods.DOMAINS + "/" + id, null);
		if(jsonResponse != null)
		  {
			System.out.println(jsonResponse);
		    converter = JSONConverterFactory.getConverter();
		    actionStatus = (ActionStatus)converter.fromJSON(jsonResponse, com.redhat.openshift.impl.ActionStatusImpl.class);
		  }
		
		return(actionStatus);
	  }

	@Override
	public ActionStatus deleteDomainName(String id, boolean force) 
	  {
		JSONConverter converter = null;
		String jsonResponse = null;
		HashMap<String, String> map = null;
		ActionStatus actionStatus = null;
		
		map = new HashMap<String, String>();
		map.put("force", "" + force);
		jsonResponse = conn.execDelete(Methods.DOMAINS + "/" + id, map);
		if(jsonResponse != null)
		  {
			System.out.println(jsonResponse);
		    converter = JSONConverterFactory.getConverter();
		    actionStatus = (ActionStatus)converter.fromJSON(jsonResponse, com.redhat.openshift.impl.ActionStatusImpl.class);
		  }
		
		return(actionStatus);
	  }
  }
