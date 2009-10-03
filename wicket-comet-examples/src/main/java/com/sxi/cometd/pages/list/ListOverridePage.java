package com.sxi.cometd.pages.list;

import java.util.Iterator;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.sxi.cometd.pages.DigiBasePage;
import com.sxi.override.digibanker.model.BaseModel;
import com.sxi.override.digibanker.model.ovrd.OverrideModel;
import com.sxi.override.digibanker.service.ovrd.OverrideService;

/**
 * 
 * @author Emmanuel Nollase - emanux
 * created 2009 7 22 - 15:10:28
 */
public class ListOverridePage extends DigiBasePage
{

    @SpringBean private OverrideService overrideService;
    
    public ListOverridePage(PageParameters parameters)
    {
	super(parameters);
	
	final IDataProvider dp = new IDataProvider()
	{
	    
	    public void detach()
	    {
	    }
	    
	    public int size()
	    {
		return overrideService.findOverridesSize();
	    }
	    
	    public IModel model(Object object)
	    {
		BaseModel model = (BaseModel) object;
		return new CompoundPropertyModel(model);
	    }
	    
	    public Iterator iterator(int first, int count)
	    {
		return overrideService.findOverrides(first, count).iterator();
	    }
	};
	
	final DataView dv = new DataView("ovrdlst",dp,10)
	{
	    
	    @Override
	    protected void populateItem(Item item)
	    {
		final OverrideModel ovrd = (OverrideModel) item.getModelObject();
		final Link link = new Link("lnkovrd")
		{
		    @Override
		    public void onClick()
		    {
			setResponsePage(new ViewOverridePage(new PageParameters(), ovrd));
		    }
		};
		link.add(new Label("refNo"));
		item.add(link);
		item.add(new Label("ovrdType"));
		item.add(new Label("funcCd"));
		item.add(new Label("reason"));
		item.add(new Label("requestBy"));
		item.add(new Label("txnDt"));
		
	    }
	};
	
	add(dv);
	
	add(new PagingNavigator("nav", dv));
    }
}

