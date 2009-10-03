/**
 * 
 */
package com.sxi.override.digibanker.service.log;

import com.sxi.cometd.pages.utils.OverrideEntryParams;
import com.sxi.override.digibanker.model.ovrd.OverrideHeader;

/**
 * @author Emmanuel Nollase - emanux
 * created 2009 7 21 - 18:41:53
 */
public interface OverrideTrackingService
{
    void createOverrideEntry(OverrideEntryParams entryParams);
    
    
    OverrideHeader findOverrideHeader(String refNo);
    
    boolean checkForPreviousApprover(String user,String headerId);
    
    int countSupervisorApproved(String headerId);

    boolean checkLocalOverride(String refNo,String ovrdkey);

    boolean acceptTransaction(OverrideHeader header, String ovrdkey);

    boolean rejectTransaction(OverrideHeader header, String ovrdkey);


    boolean transferTransaction(OverrideHeader header, String ovrdkey);


    boolean returnTransaction(OverrideHeader header, String ovrdkey);


    boolean cancelTransaction(OverrideHeader header, String ovrdkey);


    int countOverrideEntry(String refNo);
}
