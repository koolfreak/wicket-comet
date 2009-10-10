/**
 * 
 */
package org.activemq.comet.impl;

import org.activemq.comet.CometQueue;
import org.activemq.comet.interf.ResultCometQueue;

/**
 * @author Emmanuel Nollase - emanux
 * created 2009 10 10 - 11:09:09
 */
public class CometQueueImpl extends CometQueue implements ResultCometQueue
{

    /* (non-Javadoc)
     * @see org.activemq.comet.interf.ResultCometQueue#resultNotice(java.lang.String)
     */
    public void resultNotice(String message)
    {
	// TODO add some DB query or simple send the message
	
	jmsTemplate.convertAndSend(message);

    }

}
