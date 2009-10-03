/**
 * 
 */
package com.sxi.cometd.behavior;

import java.util.HashMap;
import java.util.Map;

import org.apache.wicket.Component;
import org.apache.wicket.PageParameters;
import org.apache.wicket.RequestCycle;
import org.apache.wicket.behavior.AbstractBehavior;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.template.TextTemplateHeaderContributor;
import org.wicketstuff.push.examples.pages.TestRedirect;

import com.sxi.cometd.CometdAppBehavior;
import com.sxi.cometd.pages.list.ListOverridePage;

/**
 * @author Emmanuel Nollase - emanux created: Jul 15, 2009 - 12:41:24 PM
 * 
 */
public class RedirectUrlBehavior extends AbstractBehavior
{

    @Override
    public void bind(Component component)
    {
	final IModel params = new AbstractReadOnlyModel() {
	    @Override
	    public Object getObject()
	    {
		final Map<String, Object> param = new HashMap<String, Object>();
		param.put("listoverride", RequestCycle.get().urlFor(new ListOverridePage(new PageParameters())));
		return param;
	    }
	};
	component.add(TextTemplateHeaderContributor.forJavaScript(CometdAppBehavior.class,	"js/redirecturls.js", params));
	super.bind(component);
    }

    @Override
    public void renderHead(IHeaderResponse response)
    {
	super.renderHead(response);
    }

}
