/**
 * 
 */
package com.sxi.cometd.pages.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * @author Emmanuel Nollase - emanux
 * created 2009 7 21 - 16:24:44
 */
public class LoggedUsers
{
    private static final Log log = LogFactory.getLog(LoggedUsers.class);
    
    public final static List<String> LOGGED_USERS = Collections.synchronizedList(new ArrayList<String>());
    
    public static void add(String user)
    {
	synchronized (LOGGED_USERS)
	{
		LOGGED_USERS.add(user);
	}
    }
    
    public static boolean contain(String user)
    {
	synchronized (LOGGED_USERS)
	{
	    return LOGGED_USERS.contains(user);   
	}
    }
    
    public static void remove(String user)
    {
	synchronized (LOGGED_USERS)
	{
	 if(contain(user))
	 {
	    LOGGED_USERS.remove(user); 
	 }
	}
    }
    
    public static void printLoggedUsers()
    {
	synchronized (LOGGED_USERS)
	{
	    	for(String s : LOGGED_USERS)
		{
		    log.info("logged user: "+s);
		}
	}
	
    }
    
    private LoggedUsers(){}
}
