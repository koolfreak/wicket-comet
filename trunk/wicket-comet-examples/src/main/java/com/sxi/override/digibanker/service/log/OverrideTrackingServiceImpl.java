/**
 * 
 */
package com.sxi.override.digibanker.service.log;

import java.util.Date;

import com.sxi.cometd.pages.utils.OverrideConstants;
import com.sxi.cometd.pages.utils.OverrideEntryParams;
import com.sxi.cometd.pages.utils.OverrideGenerator;
import com.sxi.override.digibanker.dao.log.OverrideTrackerDao;
import com.sxi.override.digibanker.exception.OverrideException;
import com.sxi.override.digibanker.model.ovrd.OverrideDetail;
import com.sxi.override.digibanker.model.ovrd.OverrideHeader;

/**
 * @author Emmanuel Nollase - emanux
 * created 2009 7 21 - 18:42:21
 */
public class OverrideTrackingServiceImpl implements OverrideTrackingService
{

    private OverrideTrackerDao overrideTrackerDao;
    
    public void setOverrideTrackerDao(OverrideTrackerDao overrideTrackerDao)
    {
        this.overrideTrackerDao = overrideTrackerDao;
    }

    /*
     * (non-Javadoc)
     * @see com.sxi.override.digibanker.service.log.OverrideTrackingService#createOverrideEntry(com.sxi.cometd.pages.utils.OverrideEntryParams)
     */
    public void createOverrideEntry(OverrideEntryParams entryParams)
    {
	OverrideHeader ovrdHead = overrideTrackerDao.findOvrdHdByRefNo(entryParams.getRefNo());
	final OverrideDetail overrideDetail = new OverrideDetail();
	
	// check first if the reference number already exist
	// if it does not exist insert a new record in override header,
	// else ignore, just create only overrideDetail
	if( null == ovrdHead )
	{
	    ovrdHead = new OverrideHeader();
	    	// set the function id for transaction for override
		ovrdHead.setFuncId(entryParams.getFuncId());
		// set the number of override count
		ovrdHead.setReqOvrdCnt(entryParams.getReqOvrdCnt());
		// transaction reference number
		ovrdHead.setRefNo(entryParams.getRefNo());
		// override requester
		ovrdHead.setSubmittedBy(entryParams.getSubmittedBy());
		// the date requested
		ovrdHead.setSubmittedDate(new Date());
	    save(ovrdHead);
	}
	
	overrideDetail.setOvrdHdrId(ovrdHead);
	overrideDetail.setUserId(entryParams.getSubmittedTo());
	overrideDetail.setOvrdKey(entryParams.getOvrdkey());
	overrideDetail.setOvrdType(entryParams.getOvrdType());
	
	save(overrideDetail);
	
    }

    private void save(OverrideHeader header)
    {
	overrideTrackerDao.save(header);
    }
    
    private void save(OverrideDetail detail)
    {
	overrideTrackerDao.save(detail);
    }

    public OverrideHeader findOverrideHeader(String refNo)
    {
	return overrideTrackerDao.findOvrdHdByRefNo(refNo);
    }

    public boolean checkForPreviousApprover(String user, String headerId)
    {
	boolean isPreviousApprover = false;
	final Integer result = overrideTrackerDao.supervisorCheck(user, headerId);
	
	if(result != null && result == 1 )
	{
	    isPreviousApprover = true;
	}
	
	return isPreviousApprover;
    }

    public int countSupervisorApproved(String headerId)
    {
	return overrideTrackerDao.supervisorCheck(null, headerId).intValue();
    }
    
    public int countOverrideEntry(String refNo)
    {
	int cnt = 0;
	final OverrideHeader ovrdHead = findOverrideHeader(refNo);
	if(ovrdHead != null)
	{
	    cnt = countSupervisorApproved(ovrdHead.getId());
	}
	return cnt;
    }

    public void createOverrideDetailEntry(String ovrdKey,int action) throws OverrideException
    {
	
	    final OverrideDetail ovrdDtl = overrideTrackerDao.findOvrdDtlByOvrdKey(ovrdKey);
	    
	    switch (action) {
	    case 1:
		ovrdDtl.setAction(OverrideConstants.OVRD_ACTION_ACCEPT);
		break;
	    case 2:
		ovrdDtl.setAction(OverrideConstants.OVRD_ACTION_RETURN);
		break;
	    case 3:
		 ovrdDtl.setAction(OverrideConstants.OVRD_ACTION_TRANSFER);
	    case 4:
		ovrdDtl.setAction(OverrideConstants.OVRD_ACTION_REJECT);
		break;
	    case 5:
		ovrdDtl.setAction(OverrideConstants.OVRD_ACTION_CANCEL);
		break;
	    default:
		break;
	    }
	    
	    ovrdDtl.setActionDate(new Date());
	    
	    try
	    {
		overrideTrackerDao.update(ovrdDtl);
	    } catch (Exception e)
	    {
		throw new OverrideException(e);
	    }
	    
    }
    
    public boolean acceptTransaction(OverrideHeader header,String ovrdkey)
    {
	boolean _approve = false;
	final int ovrdStat = header.getOvrdStatus();
	
	if (ovrdStat == OverrideConstants.OVRD_STATUS_PARTIALLY_APPROVED
		|| ovrdStat == OverrideConstants.OVRD_STATUS_PENDING)
	{
	    try
	    {
		createOverrideDetailEntry(ovrdkey, OverrideConstants.OVRD_ACTION_ACCEPT);
	    } 
	    catch (OverrideException e)
	    {
		e.printStackTrace();
		return false;
	    }
	    
	    final int reqCnt = header.getReqOvrdCnt();
	    final int actualCnt = countSupervisorApproved(header.getId());
	    
	    
	    if(actualCnt < reqCnt)
	    {
		 header.setOvrdStatus(OverrideConstants.OVRD_STATUS_PARTIALLY_APPROVED);
	    }
	    else if(reqCnt == actualCnt)
	    {
		 header.setApproveDate(new Date());
		 header.setOvrdStatus(OverrideConstants.OVRD_STATUS_APPROVED);
	    }
	    
	    overrideTrackerDao.update(header);
	    _approve = true;
	}
	
	return _approve;
    }
    
    public boolean rejectTransaction(OverrideHeader header,String ovrdkey)
    {
	try
	{
	    createOverrideDetailEntry(ovrdkey,OverrideConstants.OVRD_ACTION_REJECT);
	    header.setOvrdStatus(OverrideConstants.OVRD_STATUS_REJECTED);
	    overrideTrackerDao.update(header);
	    return true;
	} 
	catch (OverrideException e)
	{
	    e.printStackTrace();
	}
	return false;
    }
    
    public boolean transferTransaction(OverrideHeader header,String ovrdkey)
    {
	try
	{
	    createOverrideDetailEntry(ovrdkey, OverrideConstants.OVRD_ACTION_TRANSFER);
	    return true;
	} 
	catch (OverrideException e)
	{
	    e.printStackTrace();
	}
	return false;
    }
    
    public boolean returnTransaction(OverrideHeader header,String ovrdkey)
    {
	try
	{
	    createOverrideDetailEntry(ovrdkey,OverrideConstants.OVRD_ACTION_RETURN);
	    return true;
	} 
	catch (OverrideException e)
	{
	    e.printStackTrace();
	}
	return false;
    }
    
    public boolean cancelTransaction(OverrideHeader header,String ovrdkey)
    {
	try
	{
	    createOverrideDetailEntry(ovrdkey,OverrideConstants.OVRD_ACTION_CANCEL);
	    return true;
	} 
	catch (OverrideException e)
	{
	    e.printStackTrace();
	}
	return false;
    }

    public boolean checkLocalOverride(String refNo,String ovrdkey)
    {
	boolean _exist = false;
	final OverrideHeader header = overrideTrackerDao.findOvrdHdByRefNo(refNo);
	
	 _exist = acceptTransaction(header, ovrdkey);
	
	return _exist;
    }
}
