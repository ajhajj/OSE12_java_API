package com.redhat.openshift;

/**
 * Message response from OpenShift server.
 *
 * @author Amritpal Jhajj
 */
public interface Message 
  {
	/**
	 * Provides the exit code specified by the OpenShift server.
	 * 
	 * @return <code>int</code> code value.
	 */
	public int getExitCode();
	
	/**
	 * The name of the field that was being actioned on.
	 * 
	 * @return <code>String</code> representing the field name.
	 */
	public String getField();
	
	/**
	 * Reports on the message severity.
	 * 
	 * @return a <code>String</code> severity indicator.
	 */
	public String getSeverity();
	
	/**
	 * Message text returned from the OpenShift server.
	 * 
	 * @return the text <code>String</code>
	 */
	public String getText();
  }
