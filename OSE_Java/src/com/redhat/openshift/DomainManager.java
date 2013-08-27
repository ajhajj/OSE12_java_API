package com.redhat.openshift;

public interface DomainManager 
  {
	/**
	 * Returns a list of OpenShift domains.
	 * @return a <code>{@link Domains}</code> object.
	 */
	Domains getDomains();
	
	/**
	 * Creates a new OpenShift domain.
	 * @param id the domain name to be associated with the OpenShift domain <code>suffix</code>.
	 * @return <code>{@link ActionStatus}</code> object conveying operation success status and details.
	 */
	ActionStatus CreateDomain(String id);
	
	/**
	 * Reports domain metadata.
	 * 
	 * @param id Domain identifier <code>String</code>
	 * @return <code>{@link DomainInfo}</code> object
	 */
	DomainInfo getDomainInfo(String id);
	
	/**
	 * Updates the domain name of an existing OpenShift domain.
	 * 
	 * @param oldName existing domain identifier <code>String</code>
	 * @param newName new value for domain identifier <code>String</code>
	 * @return <code>{@link DomainInfo}</code> object
	 */
	DomainInfo updateDomainName(String oldName, String newName);
	
	/**
	 * Delete a domain for an OpenShift user account.  The API will exit with an error message 
	 * if there are applications within the domain you want to delete. You must delete all 
	 * applications before you can delete the domain.
	 * 
	 * @param id Domain identifier <code>String</code>
	 * @return <code>{@link ActionStatus}</code> object
	 */
	ActionStatus deleteDomainName(String id);
	
	/**
	 * Delete a domain for an OpenShift user account.  The API will exit with an error message 
	 * if there are applications within the domain you want to delete. You must either delete 
	 * all applications before you can delete the domain, or set the force parameter to true. 
	 * Setting the force parameter to true will automatically delete all applications under 
	 * that domain, and then delete the domain.
	 * 
	 * @param id Domain identifier <code>String</code>
	 * @param force <code>boolean</code> indicating whether to force deletion.
	 * @return <code>{@link ActionStatus}</code> object
	 */
	ActionStatus deleteDomainName(String id, boolean force);
  }
