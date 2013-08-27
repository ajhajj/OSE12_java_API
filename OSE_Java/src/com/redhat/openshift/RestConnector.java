package com.redhat.openshift;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class RestConnector 
  {
	static final String DEFAULT_API_VERSION = "1.5";
	AuthScope scope = null;
	Credentials credentials = null;
	String host = null;
	String user = null;
	String password = null;
	private String acceptHeader = null;
    
	public RestConnector(String user, String password, String host)
	  {
		init(user, password, host, null);
	  }
	
	public RestConnector(String user, String password, String host, String apiVersion)
	  {
		init(user, password, host, apiVersion);
	  }
	
	private void init(String user, String password, String host, String apiVersion)
	  {
		this.user = user;
		this.password = password;
		this.host = host;
		
		if(apiVersion == null)
		  apiVersion = DEFAULT_API_VERSION;
		
		this.acceptHeader = "application/json; version=" + apiVersion;
    	scope = new AuthScope(host, 443);
    	credentials = new UsernamePasswordCredentials(user, password);
	  }
	
	public String execGet(String restMethod)
	  {
		return(connect(host, "GET", restMethod, scope, credentials, null));
	  }
	
	public String execPost(String restMethod, Map<String, String> parameters)
	  {
		return(connect(host, "POST", restMethod, scope, credentials, parameters));
	  }
	
	public String execPut(String restMethod, Map<String, String> parameters)
	  {
		return(connect(host, "PUT", restMethod, scope, credentials, parameters));
	  }
	
	public String execDelete(String restMethod, Map<String, String> parameters)
	  {
		return(connect(host, "DELETE", restMethod, scope, credentials, parameters));
	  }
	
    private String connect(String host, String httpMethod, String restMethod, AuthScope scope, Credentials credentials, Map<String, String> parameters)
      {
    	String jsonString = null;
    	Iterator<String> it = null;
    	List <NameValuePair> nvps = null;
		String key = null;
		String value = null;
		HttpEntity entity = null;
    	DefaultHttpClient httpclient = null;
    	HttpRequestBase request = null;
    	HttpResponse response = null;
    	String url = "https://" + host + "/broker/rest/" + restMethod + "?nolinks=true&force=false";
    	
    	httpclient = new DefaultHttpClient();
    	if("PUT".equals(httpMethod))
    	  request = new HttpPut(url);
    	else if("POST".equals(httpMethod))
      	  request = new HttpPost(url);
    	else if("GET".equals(httpMethod))
      	  request = new HttpGet(url);
    	else if("DELETE".equals(httpMethod))
    	  {
    		if((parameters != null) && (parameters.size() > 0))
      	      {
        		it = parameters.keySet().iterator();

        		while(it.hasNext())
        		  {
        			key = it.next();
        			value = parameters.get(key);
        			it.remove();
                    url += "&" + key + "=" + value;
        		  }
        		
        		parameters = null;
        	  }
      	    request = new HttpDelete(url);
    	  }
    	
    	request.addHeader("Accept", acceptHeader);
    	request.addHeader("Content-Type", "application/x-www-form-urlencoded");

    	if((parameters != null) && (parameters.size() > 0))
    	  {
            nvps = new ArrayList <NameValuePair>();
    		it = parameters.keySet().iterator();

    		while(it.hasNext())
    		  {
    			key = it.next();
    			value = parameters.get(key);
                nvps.add(new BasicNameValuePair(key, value));
    		  }
    		
            ((HttpEntityEnclosingRequestBase)request).setEntity(new UrlEncodedFormEntity(nvps, Consts.UTF_8));
    	  }

    	try 
  	      {
    		if((scope != null) && (credentials != null))
    		  httpclient.getCredentialsProvider().setCredentials(scope, credentials);
    		
    	    response = httpclient.execute(request);

    	    // not immediately checking for response status code because we will receive JSON response for non 200 codes
    	    entity = response.getEntity();
	        if(entity != null)
	          jsonString = EntityUtils.toString(entity);
   	    
	        if(jsonString == null)
    	      System.err.println(response.getStatusLine().toString());
    	  } 
    	catch(Exception ex)
    	  {
    		System.err.println(ex.toString());
    	  }
    	finally 
    	  {
    		request.releaseConnection();
    	  }
    	
    	return(jsonString);
      }
  }
