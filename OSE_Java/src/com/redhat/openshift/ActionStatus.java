package com.redhat.openshift;

public interface ActionStatus 
  {
	/**
	 * Provides the 'action' status <code>String</code> received from the OpenShift server.
	 *  
	 * @return status <code>String</code>
	 */
	public String getActionStatus();
	
	/**
	 * Array of messages received from the OpenShift server.
	 * 
	 * @return array of <code>{@link Message}</code> objects
	 */
	public Message[] getMessages();
	
	/**
	 * Reports on whether any messages were returned from the OpenShift server.
	 * 
	 * @return <code>boolean</code>
	 */
	public boolean hasMessages();
  }
