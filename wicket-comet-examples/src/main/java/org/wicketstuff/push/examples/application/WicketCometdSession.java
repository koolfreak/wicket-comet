/**
 * 
 */
package org.wicketstuff.push.examples.application;

import org.apache.wicket.Request;
import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebSession;

/**
 * @author Emmanuel Nollase - emanux
 * created: Jul 14, 2009 - 12:07:38 PM
 *
 */
public class WicketCometdSession extends WebSession {

	private String cometUser;
	
	public WicketCometdSession(Request request) {
		super(request);
	}

	public synchronized String getCometUser() {
		return cometUser;
	}

	public synchronized void setCometUser(String cometUser) {
		this.cometUser = cometUser;
		dirty();
	}

	public static WicketCometdSession get()
	{
		return (WicketCometdSession) Session.get();
	}
}
