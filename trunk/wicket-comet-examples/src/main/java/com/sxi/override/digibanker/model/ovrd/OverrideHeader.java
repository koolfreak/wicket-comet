/**
 * 
 */
package com.sxi.override.digibanker.model.ovrd;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;

import com.sxi.override.digibanker.model.BaseModel;

/**
 * @author Emmanuel Nollase - emanux
 * created 2009 7 21 - 11:21:50
 */
public class OverrideHeader extends BaseModel {

	private String funcId;
	/*
	 * Override Status
	 * 0 - Pending
	 * 1 - Partially Approved
	 * 2 - Approved
	 * 3 - Rjected
	 */
	private int ovrdStatus;
	private int reqOvrdCnt;
	private String submittedBy;
	private Date submittedDate;
	private Date approveDate;
	
	private String refNo;
	private String reasonCancelled;
	private String reasonRejected;
	
	public String getFuncId() {
		return funcId;
	}
	public void setFuncId(String funcId) {
		this.funcId = funcId;
	}
	public int getOvrdStatus() {
		return ovrdStatus;
	}
	public void setOvrdStatus(int ovrdStatus) {
		this.ovrdStatus = ovrdStatus;
	}
	public int getReqOvrdCnt() {
		return reqOvrdCnt;
	}
	public void setReqOvrdCnt(int reqOvrdCnt) {
		this.reqOvrdCnt = reqOvrdCnt;
	}
	public String getSubmittedBy() {
		return submittedBy;
	}
	public void setSubmittedBy(String submittedBy) {
		this.submittedBy = submittedBy;
	}
	public Date getSubmittedDate() {
		return submittedDate;
	}
	public void setSubmittedDate(Date submittedDate) {
		this.submittedDate = submittedDate;
	}
	public Date getApproveDate() {
		return approveDate;
	}
	public void setApproveDate(Date approveDate) {
		this.approveDate = approveDate;
	}
	public String getRefNo() {
		return refNo;
	}
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}
	public String getReasonCancelled() {
		return reasonCancelled;
	}
	public void setReasonCancelled(String reasonCancelled) {
		this.reasonCancelled = reasonCancelled;
	}
	public String getReasonRejected() {
		return reasonRejected;
	}
	public void setReasonRejected(String reasonRejected) {
		this.reasonRejected = reasonRejected;
	}
	
	@Override
	public boolean equals(Object obj)
	{
	    return EqualsBuilder.reflectionEquals(this, obj);
	}
}
