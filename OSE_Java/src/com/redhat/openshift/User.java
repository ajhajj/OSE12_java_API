package com.redhat.openshift;

public interface User 
  {
	/**
	 * Specifies the API version in use by the OpenShift server.
	 * 
	 * @return <code>String</code> containing version tag
	 */
	public String getApiVersion();
	public String getStatus();
	public String[] getMessages();
	
	/**
	 * Total number of gears consumed by all applications owned by user.
	 * 
	 * @return <code>int</code> showing gears used
	 */
	public int getUsedGearCount(); 
	public String getCreatedTime();
	public String getId();
	
	/**
	 * Account user name.
	 * 
	 * @return login <code>String</code>
	 */
	public String getLogin(); 
	
	/**
	 * Maximum number of gears available to the specified user.
	 * 
	 * @return max gear <code>int</code>
	 */
	public int getMaxGears(); 
	
	/**
	 * Subscription plan of the specified user.
	 * 
	 * @return plan id <code>String</code>
	 */
	public String getPlanId(); 
	
	/**
	 * State of the account for the specified user.
	 * 
	 * @return plan state <code>String</code>
	 */
	public String getPlanState(); 
	public String getUsageAccountId(); 
	
	/**
	 * Available gear sizes depending on the type of plan.
	 * 
	 * @return <code>String[]</code> of available gear sizes
	 */
	public String[] getGearSizes();
	
	/**
	 * Indicates whether the user is on an upgraded plan.
	 * 
	 * @return <code>boolean</code> indicator
	 */
	public boolean isPlanUpgraded(); 
	
	/**
	 * Indicates whether the user has the ability to create subaccounts.
	 * 
	 * @return <code>boolean</code> indicator
	 */
	public boolean hasSubaccounts();
  }
