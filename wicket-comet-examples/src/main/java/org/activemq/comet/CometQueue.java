/**
 * 
 */
package org.activemq.comet;

import org.springframework.jms.core.JmsTemplate;

/**
 * @author Emmanuel Nollase - emanux
 * created 2009 10 10 - 11:03:16
 */
public class CometQueue
{

    protected JmsTemplate jmsTemplate;

    public void setJmsTemplate(JmsTemplate jmsTemplate)
    {
        this.jmsTemplate = jmsTemplate;
    }
    
    
}
