package org.wicketstuff.push.examples.application;

import java.io.Serializable;

import org.apache.wicket.Request;
import org.apache.wicket.Response;
import org.apache.wicket.Session;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.apache.wicket.util.time.Duration;
import org.wicketstuff.push.IChannelService;
import org.wicketstuff.push.IPushService;
import org.wicketstuff.push.cometd.CometdService;
import org.wicketstuff.push.examples.pages.Index;
import org.wicketstuff.push.timer.TimerChannelService;
import org.wicketstuff.push.timer.TimerPushService;

import com.sxi.cometd.pages.DigibankerIndexPage;

/**
 * Runs the ExampleApplication when invoked from command line.
 */
public class ExampleApplication extends WebApplication implements Serializable {
	private static final long serialVersionUID = 1L;

	private final IChannelService cometdService;
	private final IChannelService timerChannelService;
	private final IPushService timerPushService;

	/**
	 * Constructor
	 */
	public ExampleApplication() {
		
		cometdService = new CometdService(this);
		timerChannelService = new TimerChannelService(Duration.seconds(2));
		timerPushService = new TimerPushService(Duration.seconds(2));
	}

	
	@Override
	protected void init() {
		super.init();
		
		addComponentInstantiationListener(new SpringComponentInjector(this));
		
	}


	/**
	 * @see wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage() {
		return DigibankerIndexPage.class;
	    //return Index.class;
	}

	@Override
	public Session newSession(Request request, Response response) {
		return new WicketCometdSession(request);
	}

	public IChannelService getCometdService() {
		return cometdService;
	}

	public IChannelService getTimerChannelService() {
		return timerChannelService;
	}

	public IPushService getTimerPushService() {
		return timerPushService;
	}
}