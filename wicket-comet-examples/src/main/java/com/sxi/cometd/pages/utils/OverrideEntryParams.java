/**
 * 
 */
package com.sxi.cometd.pages.utils;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Emmanuel Nollase - emanux
 * created 2009 7 21 - 18:43:53
 */
public class OverrideEntryParams implements Serializable
{

    private String funcId;
    private String reasonCancelled;
    private String reasonRejected;
    private Date approveDate;
    private Date actionDate;
    private int action;
    private String ovrdType;
    private String refNo;
    private String ovrdkey;
    private String submittedBy;
    private String submittedTo; 
    private int reqOvrdCnt;
    
    public String getReasonCancelled()
    {
        return reasonCancelled;
    }
    public void setReasonCancelled(String reasonCancelled)
    {
        this.reasonCancelled = reasonCancelled;
    }
    public String getReasonRejected()
    {
        return reasonRejected;
    }
    public void setReasonRejected(String reasonRejected)
    {
        this.reasonRejected = reasonRejected;
    }
    public Date getApproveDate()
    {
        return approveDate;
    }
    public void setApproveDate(Date approveDate)
    {
        this.approveDate = approveDate;
    }
    public Date getActionDate()
    {
        return actionDate;
    }
    public void setActionDate(Date actionDate)
    {
        this.actionDate = actionDate;
    }
    public int getAction()
    {
        return action;
    }
    public void setAction(int action)
    {
        this.action = action;
    }
    public String getOvrdType()
    {
        return ovrdType;
    }
    public void setOvrdType(String ovrdType)
    {
        this.ovrdType = ovrdType;
    }
    public String getRefNo()
    {
        return refNo;
    }
    public void setRefNo(String refNo)
    {
        this.refNo = refNo;
    }
    public String getFuncId()
    {
        return funcId;
    }
    public void setFuncId(String funcId)
    {
        this.funcId = funcId;
    }
    public String getSubmittedBy()
    {
        return submittedBy;
    }
    public void setSubmittedBy(String submittedBy)
    {
        this.submittedBy = submittedBy;
    }
    public int getReqOvrdCnt()
    {
        return reqOvrdCnt;
    }
    public void setReqOvrdCnt(int reqOvrdCnt)
    {
        this.reqOvrdCnt = reqOvrdCnt;
    }
    public String getSubmittedTo()
    {
        return submittedTo;
    }
    public void setSubmittedTo(String submittedTo)
    {
        this.submittedTo = submittedTo;
    }
    public String getOvrdkey()
    {
        return ovrdkey;
    }
    public void setOvrdkey(String ovrdkey)
    {
        this.ovrdkey = ovrdkey;
    }
    
    
}
