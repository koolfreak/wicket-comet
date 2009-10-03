/**
 * 
 */
package com.sxi.cometd.core.listeners;

import java.util.Map;

import org.wicketstuff.push.IChannelListener;
import org.wicketstuff.push.IChannelTarget;

import com.sxi.cometd.utils.CometdUtils;

/**
 * @author Emmanuel Nollase - emanux created 2009 7 20 - 18:44:37
 */
public class BroadcastListener implements IChannelListener
{

    /*
     * (non-Javadoc)
     * 
     * @see org.wicketstuff.push.IChannelListener#onEvent(java.lang.String,
     * java.util.Map, org.wicketstuff.push.IChannelTarget)
     */
    public void onEvent(String channel, Map<String, String> datas,
	    IChannelTarget target)
    {

	// implement broadcaster here
	if (CometdUtils.isNotification(datas))
	{
	    target.appendJavascript("sxicometd.alerts.success('"
		    + CometdUtils.statusTransaction(datas) + "')");
	}
    }

}
