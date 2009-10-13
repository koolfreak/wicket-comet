package com.sxi.cometd.pages.list;

import java.io.Serializable;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.wicket.PageParameters;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.push.ChannelEvent;

import com.sxi.cometd.pages.DigiBasePage;
import com.sxi.cometd.pages.utils.OverrideConstants;
import com.sxi.cometd.utils.RemoteConstants;
import com.sxi.override.digibanker.model.TestTransaction;
import com.sxi.override.digibanker.model.ovrd.OverrideBean;
import com.sxi.override.digibanker.model.ovrd.OverrideHeader;
import com.sxi.override.digibanker.model.ovrd.OverrideModel;
import com.sxi.override.digibanker.service.log.OverrideTrackingService;
import com.sxi.override.digibanker.service.ovrd.OverrideService;

/**
 * @author Emmanuel Nollase - emanux
 * created 2009 7 22 - 16:27:27
 */
public class ViewOverridePage extends DigiBasePage
{
    private static final Log log = LogFactory.getLog(ViewOverridePage.class);
    
    @SpringBean private OverrideTrackingService trackingService;
    @SpringBean private OverrideService overrideService;
    
    public ViewOverridePage(PageParameters parameters,final OverrideModel model)
    {
	super(parameters);
	
	final TestTransaction _txn = (TestTransaction) SerializationUtils.deserialize(model.getHdrMdl());
	
	add(new Label("tranCode", _txn.getTranCode()));
	add(new Label("tranType", _txn.getTranType()));
	add(new Label("tranAmt", _txn.getTranAmt().toString()));
	add(new Label("tranDscp", _txn.getTranDscp()));
	
	final OverrideBean ovrdbean = new OverrideBean();
	ovrdbean.setSupervisor(getUser());
	
	final Form form = new Form("supform", new CompoundPropertyModel(ovrdbean));
	add(form);
	
	form.add(new Label("supervisor"));
	final RequiredTextField pass = new RequiredTextField("password");
	form.add(pass);
	
	
	
	final String requestee = model.getRequestBy();
	
	// we can find override header by reference number
	final OverrideHeader ovrdHead = trackingService.findOverrideHeader(model.getRefNo());
	
	final AjaxButton accept = new AjaxButton("accept", form)
	{
	    @Override
	    protected void onSubmit(AjaxRequestTarget target, Form form)
	    {
		// FIXME check user credentials first before sending an event: allowed or not
		
		/*boolean isPreviousChecker = trackingService.checkForPreviousApprover(getUser(), ovrdHead.getId());
		if(isPreviousChecker)
		{
		    target.appendJavascript("sxicometd.alerts.failed('Sorry, you are the previous approver of this transaction.')");
		    return;
		}*/
		
		boolean apprv = trackingService.acceptTransaction(ovrdHead, model.getOvrdKey());
		if(apprv)
		{
        		final ChannelEvent event = new ChannelEvent(requestee);
        		event.addData(RemoteConstants.ACCEPTED, "true");
        		event.addData("Transaction", model.getReason());
        		event.addData("Transaction Date", model.getTxnDt().toString());
        		event.addData("Reference Number",model.getRefNo());
        		event.addData("Supervisor", getUser());
        		
        		getChannelService().publish(event);
        		
        		/*if(ovrdHead.getOvrdStatus() == OverrideConstants.OVRD_STATUS_APPROVED)
        		{*/
        		    model.setStatus(1);
        		    overrideService.update(model);
        		//}
        		//target.appendJavascript("sxicometd.alerts.failed('Override success.')");
        		setRedirect(true);
        		setResponsePage(ListOverridePage.class);
		}
		else
		{
		    target.appendJavascript("sxicometd.alerts.failed('Sorry, override failed.')");
		}
		
	    }
	};
	form.add(accept);
	
	final AjaxButton reject = new AjaxButton("reject",form)
	{
	    
	    @Override
	    protected void onSubmit(AjaxRequestTarget target, Form form)
	    {
		// TODO Auto-generated method stub
		// check user credentials first before sending an event
		
		boolean reject = trackingService.rejectTransaction(ovrdHead, model.getOvrdKey());
		if(reject)
		{
        		final ChannelEvent event = new ChannelEvent(requestee);
        		event.addData(RemoteConstants.ACCEPTED, "false");
        		event.addData("Transaction", _txn.getTranType());
        		event.addData("Refereence Number",model.getRefNo());
        		event.addData("From", getUser());
        		
        		getChannelService().publish(event);
        		
        		/*if(ovrdHead.getOvrdStatus() == OverrideConstants.OVRD_STATUS_REJECTED)
        		{*/
        		    model.setStatus(4);
        		    overrideService.update(model);
        		//}
        		setRedirect(true);
            		setResponsePage(ListOverridePage.class);
		}
		else
		{
		    target.appendJavascript("sxicometd.alerts.failed('Sorry, override failed.')");
		}
	    }
	};
	form.add(reject);
	
	/*final AjaxButton transfer = new AjaxButton("transfer",form)
	{
	    
	    @Override
	    protected void onSubmit(AjaxRequestTarget target, Form form)
	    {
		// TODO Auto-generated method stub
		boolean transfer = trackingService.transferTransaction(ovrdHead, model.getOvrdKey());
		if(transfer)
		{
        		final ChannelEvent event = new ChannelEvent(requestee);
        		event.addData(RemoteConstants.NOTIFY, "true");
        		event.addData("Transaction", _txn.getTranType());
        		event.addData("Status", "Transaction was transfered");
        		event.addData("Refereence Number",model.getRefNo());
        		event.addData("From", getUser());
        		
        		getChannelService().publish(event);
		}
		else
		{
		    target.appendJavascript("sxicometd.alerts.failed('Sorry, error occured.')");
		}
	    }
	};
	form.add(transfer);
	
	final AjaxButton cancel = new AjaxButton("cancel",form)
	{
	    
	    @Override
	    protected void onSubmit(AjaxRequestTarget target, Form form)
	    {
		// TODO Auto-generated method stub
		boolean cancel = trackingService.acceptTransaction(ovrdHead, model.getOvrdKey());
		if(cancel)
		{
        		final ChannelEvent event = new ChannelEvent(requestee);
        		event.addData(RemoteConstants.NOTIFY, "true");
        		event.addData("Transaction", _txn.getTranType());
        		event.addData("Status", "Transaction was canceled");
        		event.addData("Refereence Number",model.getRefNo());
        		event.addData("From", getUser());
		
		 getChannelService().publish(event);
		}
		else
		{
		    target.appendJavascript("sxicometd.alerts.failed('Sorry, error occured.')");
		}
		
		
	    }
	};
	form.add(cancel.setDefaultFormProcessing(false)); */
    }
    
}

