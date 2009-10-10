/**
 * 
 */
package org.activemq.comet.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.apache.activemq.command.ActiveMQTextMessage;

/**
 * @author Emmanuel Nollase - emanux
 * created 2009 10 10 - 11:14:46
 */
public class ResultListener implements MessageListener
{

    /* (non-Javadoc)
     * @see javax.jms.MessageListener#onMessage(javax.jms.Message)
     */
    public void onMessage(Message message)
    {
	// TODO add some routine calls
	
	ActiveMQTextMessage om = (ActiveMQTextMessage) message;
	try
	{
	    System.out.println("message is: "+om.getText());
	} catch (JMSException e)
	{
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

}
