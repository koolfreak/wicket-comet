/**
 * 
 */
package com.sxi.cometd.core;

import org.apache.wicket.PageParameters;
import org.cometd.RemoveListener;
import org.wicketstuff.push.ChannelEvent;
import org.wicketstuff.push.IChannelService;
import org.wicketstuff.push.cometd.CometdService;
import org.wicketstuff.push.examples.application.WicketCometdSession;
import org.wicketstuff.push.examples.pages.ExamplePage;

import com.sxi.cometd.core.listeners.RemoteListener;

/**
 * @author Emmanuel Nollase - emanux 
 * created 2009 7 20 - 16:43:46
 */
public abstract class CometdBasePage extends ExamplePage
{

    public CometdBasePage(final PageParameters parameters)
    {
	final String userchannel = WicketCometdSession.get().getCometUser();
	getChannelService().addChannelListener(this, userchannel,
		new RemoteListener());
	
    }

    protected abstract IChannelService getChannelService();
}
