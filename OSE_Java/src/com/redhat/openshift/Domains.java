package com.redhat.openshift;

public interface Domains extends ActionStatus 
  {
	/**
	 * Returns a list of known domains for the current user.
	 * 
	 * @return an array of <code>{@link Domain}</code> objects.
	 */
	public Domain[] getDomains();
  }
