package com.redhat.openshift;

public interface Domain 
  {
	/**
	 * Returns the ID portion of the domain string.  Where the domain string looks like:
	 * &lt;application name&gt;-&lt;ID&gt;.&lt;suffix&gt;
	 * 
	 * @return domain ID <code>String</code>
	 */
    public String getId();

	/**
	 * Returns the suffix portion of the domain string.  Where the domain string looks like:
	 * &lt;application name&gt;-&lt;ID&gt;.&lt;suffix&gt;
	 * 
	 * @return domain suffix <code>String</code>
	 */
    public String getSuffix();
  }
