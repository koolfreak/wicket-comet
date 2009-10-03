/**
 * 
 */
package com.sxi.cometd.utils;

import java.util.Map;
import java.util.Set;

/**
 * @author Emmanuel Nollase - emanux created: Jul 14, 2009 - 11:25:18 PM
 * 
 */
public final class CometdUtils
{

    public static void remove(final Map<String, String> datas)
    {
	if (datas.containsKey(RemoteConstants.ACCEPTED))
	{
	    datas.remove(RemoteConstants.ACCEPTED);
	}

	if (datas.containsKey(RemoteConstants.OUTGOING))
	{
	    datas.remove(RemoteConstants.OUTGOING);
	}

	if (datas.containsKey(RemoteConstants.PROXY))
	{
	    datas.remove(RemoteConstants.PROXY);
	}

	if (datas.containsKey(RemoteConstants.RANDOM))
	{
	    datas.remove(RemoteConstants.RANDOM);
	}
    }

    public static StringBuilder buildResponse(final Map<String, String> datas)
    {
	// remove first unnecessary data entry from cometd response
	remove(datas);

	final StringBuilder build = new StringBuilder();

	final Set<String> vdata = datas.keySet();
	for (String key : vdata)
	{
	    build.append(key).append(": ").append(datas.get(key)).append('#');
	}
	return build;
    }
    
    public static String getRequestOverride(final Map<String, String> datas)
    {
	final StringBuilder reqOverride = buildResponse(datas);
	reqOverride.append("##Requesting for remote supervisor override.");
	return reqOverride.toString();
    }

    public static String getAcceptResponse(final Map<String, String> datas)
    {
	final StringBuilder acceptResp = buildResponse(datas);
	acceptResp.append("##Override Approved.");
	return acceptResp.toString();
    }

    public static String getRejectResponse(final Map<String, String> datas)
    {
	final StringBuilder rejectResp = buildResponse(datas);
	rejectResp.append("##Override Rejected.");
	return rejectResp.toString();
    }

    /****** use for user notification *****************************/
    
    public static boolean isAccepted(final Map<String, String> datas)
    {
	boolean _accepted = false;
	if (datas.containsKey(RemoteConstants.ACCEPTED))
	{
	    _accepted = Boolean.valueOf(datas.get(RemoteConstants.ACCEPTED));
	}
	return _accepted;
    }
    
    public static boolean isRejected(final Map<String, String> datas)
    {
	boolean _rejected = false;
	if (datas.containsKey(RemoteConstants.ACCEPTED))
	{
	    _rejected = !Boolean.valueOf(datas.get(RemoteConstants.ACCEPTED));
	}
	return _rejected;
    }
    
    public static boolean isNotification(final Map<String, String> datas)
    {
	boolean _notify = false;
	if(datas.containsKey(RemoteConstants.NOTIFY))
	{
	    _notify = Boolean.valueOf(datas.get(RemoteConstants.NOTIFY));
	}
	return _notify;
    }
    
    public static boolean isOutgoing(final Map<String, String> datas)
    {
	boolean _outgoing = false;
	if (datas.containsKey(RemoteConstants.OUTGOING))
	{
	    _outgoing = Boolean.valueOf(datas.get(RemoteConstants.OUTGOING));
	}
	return _outgoing;
    }
    
    /************ use for pop-up alerts ***********************************/
    
    public static String requestAlertSuccess(final Map<String, String> datas)
    {
	final StringBuilder reqalerts = buildResponse(datas);
	reqalerts.append("##Override request was successfully sent.");
	return reqalerts.toString();
    }
    
    public static String requestAlertFailed(final Map<String, String> datas)
    {
	final StringBuilder reqalerts = buildResponse(datas);
	reqalerts.append("##Override request was failed.");
	return reqalerts.toString();
    }
    
    public static String statusTransaction(final Map<String, String> datas)
    {
	final StringBuilder reqalerts = buildResponse(datas);
	return reqalerts.toString();
    }
    
   /* public static String transferTransaction(final Map<String, String> datas)
    {
	final StringBuilder reqalerts = buildResponse(datas);
	reqalerts.append("##Override transaction was transfered.");
	return reqalerts.toString();
    }
    
    public static String cancelTransaction(final Map<String, String> datas)
    {
	final StringBuilder reqalerts = buildResponse(datas);
	reqalerts.append("##Override transaction was canceled.");
	return reqalerts.toString();
    }*/

    private CometdUtils()
    {
    }
}
