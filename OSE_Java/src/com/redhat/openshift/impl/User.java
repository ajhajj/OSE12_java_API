package com.redhat.openshift.impl;

import com.redhat.openshift.impl.User.Data.Capabilities;

public class User implements com.redhat.openshift.User
  {
	private String api_version = null;
	private String status = null;
	private String[] messages = null;
	private Data data = null;
	
	public String getApiVersion() 
	  {
		return(api_version);
	  }
	
	public String getStatus() 
	  {
		return(status);
	  }
	
	public String[] getMessages() 
	  {
		return(messages);
	  }

	public int getUsedGearCount() 
	  {
		int gears = -1;
		
		if(data != null)
		  gears = data.consumed_gears;
		
		return(gears);
	  }
	
	public String getCreatedTime() 
	  {
		String created = null;
		
		if(data != null)
			created = data.created_at;
		
		return(created);
	  }
	
	public String getId() 
	  {
		String id = null;
		
		if(data != null)
			id = data.id;
		
		return(id);
	  }

	public String getLogin() 
	  {
		String login = null;
		
		if(data != null)
			login = data.login;
		
		return(login);
	  }

	public int getMaxGears() 
	  {
		int maxGears = -1;
		
		if(data != null)
			maxGears = data.max_gears;
		
		return(maxGears);
	  }

	public String getPlanId() 
	  {
		String id = null;
		
		if(data != null)
			id = data.plan_id;
		
		return(id);
	  }
	
	public String getPlanState() 
	  {
		String state = null;
		
		if(data != null)
			state = data.plan_state;
		
		return(state);
	  }

	public String getUsageAccountId() 
	  {
		String id = null;
		
		if(data != null)
			id = data.usage_account_id;
		
		return(id);
	  }

	public String[] getGearSizes() 
	  {
		Capabilities cap = null;
		String[] sizes = null;
		
		if(data != null)
		  {
			cap = data.getCapabilities();
			if(cap != null)
			  sizes = cap.gear_sizes;
		  }
		
		return(sizes);
	  }
	
	public boolean isPlanUpgraded() 
	  {
		Capabilities cap = null;
		boolean enabled = false;
		
		if(data != null)
		  {
			cap = data.getCapabilities();
			if(cap != null)
			  enabled = cap.plan_upgrade_enabled;
		  }
		
		return(enabled);
	  }
	
	public boolean hasSubaccounts() 
	  {
		Capabilities cap = null;
		boolean sub = false;
		
		if(data != null)
		  {
			cap = data.getCapabilities();
			if(cap != null)
			  sub = cap.subaccounts;
		  }
		
		return(sub);
	  }

	public static class Data
	  {
		int consumed_gears;
		String created_at;
		String id;
		String login;
		int max_gears;
		String plan_id;
		String plan_state;
		String usage_account_id;
		Capabilities capabilities = null;
		
		public Capabilities getCapabilities()
		  {
		    return(capabilities);	
		  }	

		public static class Capabilities 
		  {
			String[] gear_sizes = null;
			boolean plan_upgrade_enabled;
			boolean subaccounts;
	      }
	  }
  }
