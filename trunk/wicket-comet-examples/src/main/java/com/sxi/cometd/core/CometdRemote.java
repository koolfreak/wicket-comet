/**
 * 
 */
package com.sxi.cometd.core;

import org.apache.wicket.PageParameters;
import org.apache.wicket.behavior.HeaderContributor;
import org.cometd.RemoveListener;
import org.wicketstuff.push.ChannelEvent;
import org.wicketstuff.push.IChannelService;
import org.wicketstuff.push.cometd.CometdService;

import com.sxi.cometd.CometdAppBehavior;
import com.sxi.cometd.behavior.RedirectUrlBehavior;

/**
 * @author Emmanuel Nollase - emanux 
 * created: Jul 14, 2009 - 4:57:56 PM
 * 
 * 
 */
public class CometdRemote extends SXICometdRemote
{

    public CometdRemote(PageParameters parameters)
    {
	super(parameters);

	add(HeaderContributor.forJavaScript(CometdAppBehavior.class, "js/cometd-app.js"));
	add(new RedirectUrlBehavior());

	final CometdService s = (CometdService) getCometdService();
	s.addChannelRemoveListener("chat", new RemoveListener() {

	    public void removed(final String clientId, final boolean timeout)
	    {
		final ChannelEvent event = new ChannelEvent("chat");
		event.addData("message", clientId + "just left");
		getChannelService().publish(event);
	    }
	});
    }

    @Override
    protected IChannelService getChannelService()
    {
	return getCometdService();
    }

   

}
