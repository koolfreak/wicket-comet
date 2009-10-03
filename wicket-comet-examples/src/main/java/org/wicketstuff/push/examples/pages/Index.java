package org.wicketstuff.push.examples.pages;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;
import org.wicketstuff.push.examples.application.WicketCometdSession;

import com.sxi.cometd.core.CometdRemote;
import com.sxi.cometd.pages.DigibankerOverridePage;

public class Index extends WebPage {

	private String user;
	
	public Index() {
		
		add(new Link("override") {
			
			@Override
			public void onClick() {
				setResponsePage(DigibankerOverridePage.class);
			}
		});
		
		Form form = new Form("userform");
		
		final TextField usert = new TextField("user", new PropertyModel(this,"user"));
		
		form.add(usert);
		
		form.add(new AjaxButton("log", form){

			@Override
			protected void onSubmit(AjaxRequestTarget target, Form form) {
				String usr = usert.getModelObjectAsString();
				WicketCometdSession.get().setCometUser(usr);
				setResponsePage(CometdRemote.class);
			}
		});
		add(form);
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	
}
