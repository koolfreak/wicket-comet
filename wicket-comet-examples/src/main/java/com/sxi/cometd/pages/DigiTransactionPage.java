package com.sxi.cometd.pages;

import org.apache.wicket.PageParameters;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.ajax.markup.html.IndicatingAjaxButton;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;

import com.sxi.override.digibanker.model.TestTransaction;


/**
 * 
 * @author Emmanuel Nollase - emanux
 * created 2009 7 21 - 16:46:10
 */
public class DigiTransactionPage extends DigiBasePage
{

    public DigiTransactionPage(PageParameters parameters)
    {
	super(parameters);
	
	final Form form = new Form("txnform", new CompoundPropertyModel(new TestTransaction()));
	add(form);
	
	form.add(new TextField("tranCode"));
	form.add(new TextField("tranType"));
	form.add(new TextField("tranAmt"));
	form.add(new TextField("tranDscp"));
	
	final IndicatingAjaxButton submit = new IndicatingAjaxButton("submit",form)
	{
	    
	    @Override
	    protected void onSubmit(AjaxRequestTarget target, Form form)
	    {
		final TestTransaction txn = (TestTransaction) form.getModelObject();
		setResponsePage(new DigibankerOverridePage(txn,new PageParameters()));
	    }
	};
	form.add(submit);
    }

}

