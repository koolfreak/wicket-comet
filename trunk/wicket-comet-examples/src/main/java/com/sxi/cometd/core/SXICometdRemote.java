/**
 * 
 */
package com.sxi.cometd.core;

import org.apache.wicket.PageParameters;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.model.PropertyModel;
import org.wicketstuff.push.ChannelEvent;
import org.wicketstuff.push.IChannelService;
import org.wicketstuff.push.examples.application.WicketCometdSession;
import org.wicketstuff.push.examples.pages.ExamplePage;

import com.sxi.cometd.core.listeners.RemoteListener;
import com.sxi.cometd.utils.RemoteConstants;

/**
 * @author Emmanuel Nollase - emanux 
 * created: Jul 14, 2009 - 3:27:16 PM
 * 
 */
public abstract class SXICometdRemote extends ExamplePage
{

    private static final long serialVersionUID = 1L;

    private String touser;

    public SXICometdRemote(final PageParameters parameters)
    {

	final Form formChat = new Form("chatForm");
	final String userchannel = WicketCometdSession.get().getCometUser();

	final RequiredTextField touserf = new RequiredTextField("touser", new PropertyModel(this,"touser"));
	formChat.add(touserf);

	getChannelService().addChannelListener(this, userchannel, new RemoteListener());
	
	formChat.add(new AjaxButton("send", formChat) {
	    private static final long serialVersionUID = 1L;
	    @Override
	    protected void onSubmit(final AjaxRequestTarget target, final Form form)
	    {
		// Update message
		String toUser = touserf.getModelObjectAsString();
		String fromUser = WicketCometdSession.get().getCometUser();

		final ChannelEvent event = new ChannelEvent(toUser);
		event.addData("From", fromUser);
		event.addData("Override Type", "Transaction Limit");
		event.addData("Function", "Cash Deposit");
		event.addData(RemoteConstants.OUTGOING, "true");
		// event.addData(RemoteConstants.ACCEPTED, "false");
		getChannelService().publish(event);

	    }
	});
	add(formChat);
    }

    protected abstract IChannelService getChannelService();

    public String getTouser()
    {
	return touser;
    }

    public void setTouser(String touser)
    {
	this.touser = touser;
    }

}
