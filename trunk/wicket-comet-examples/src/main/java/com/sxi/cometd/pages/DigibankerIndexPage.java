package com.sxi.cometd.pages;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.wicketstuff.push.examples.application.WicketCometdSession;

import com.sxi.cometd.core.CometdRemote;
import com.sxi.cometd.pages.utils.LoggedUsers;

/**
 * 
 * @author Emmanuel Nollase - emanux 
 * created 2009 7 21 - 16:16:39
 */
public class DigibankerIndexPage extends WebPage
{
    private String user;

    public DigibankerIndexPage()
    {
	final Form form = new Form("userform");

	final TextField usert = new TextField("user", new PropertyModel(this,
		"user"));

	form.add(usert);

	form.add(new AjaxButton("log", form)
	{

	    @Override
	    protected void onSubmit(AjaxRequestTarget target, Form form)
	    {
		String usr = usert.getModelObjectAsString();
		WicketCometdSession.get().setCometUser(usr);
		LoggedUsers.add(usr);
		setResponsePage(DigiBasePage.class);
	    }
	});
	add(form);
    }

    public String getUser()
    {
	return user;
    }

    public void setUser(String user)
    {
	this.user = user;
    }
}
