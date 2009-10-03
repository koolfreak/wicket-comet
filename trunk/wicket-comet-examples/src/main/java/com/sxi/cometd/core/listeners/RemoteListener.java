/**
 * 
 */
package com.sxi.cometd.core.listeners;

import java.util.Map;

import org.wicketstuff.push.IChannelListener;
import org.wicketstuff.push.IChannelTarget;

import com.sxi.cometd.utils.CometdUtils;

/**
 * @author Emmanuel Nollase - emanux
 * created: Jul 14, 2009 - 3:38:30 PM
 *
 */
public class RemoteListener implements IChannelListener {

	/* (non-Javadoc)
	 * @see org.wicketstuff.push.IChannelListener#onEvent(java.lang.String, java.util.Map, org.wicketstuff.push.IChannelTarget)
	 */
	public void onEvent(String channel, Map<String, String> datas,IChannelTarget target) {
		
		if(CometdUtils.isOutgoing(datas))
		{
			target.appendJavascript("sxicometd.request.override('"+CometdUtils.getRequestOverride(datas)+"')");
		}

		if(CometdUtils.isAccepted(datas))
		{
			//target.appendJavascript("Wicket.Window.close()");
			target.appendJavascript("sxicometd.override.approve('"+CometdUtils.getAcceptResponse(datas)+"')");
		}
		
		if(CometdUtils.isRejected(datas))
		{
			//target.appendJavascript("Wicket.Window.close()");
			target.appendJavascript("sxicometd.override.reject('"+CometdUtils.getRejectResponse(datas)+"')");
			// TODO disable submit button
		}
		
		if(CometdUtils.isNotification(datas))
		{
		    target.appendJavascript("sxicometd.alerts.success('"+CometdUtils.statusTransaction(datas)+"')");
		}
	}

}
