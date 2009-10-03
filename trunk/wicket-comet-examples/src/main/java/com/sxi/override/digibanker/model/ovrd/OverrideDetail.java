/**
 * 
 */
package com.sxi.override.digibanker.model.ovrd;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;

import com.sxi.override.digibanker.model.BaseModel;

/**
 * @author Emmanuel Nollase - emanux
 * created 2009 7 21 - 11:34:14
 */
public class OverrideDetail extends BaseModel {

	private OverrideHeader ovrdHdrId;
	private String userId;
	private Date actionDate;
	/*
	 * Override Action
	 * 0 - Pending
	 * 1 - Accept
	 * 2 - Return
	 * 3 - Transfer
	 * 4 - Reject
	 * 5 - Cancel
	 */
	private String ovrdKey;
	private int action;
	private String ovrdType;
	
	public OverrideHeader getOvrdHdrId() {
		return ovrdHdrId;
	}
	public void setOvrdHdrId(OverrideHeader ovrdHdrId) {
		this.ovrdHdrId = ovrdHdrId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getActionDate() {
		return actionDate;
	}
	public void setActionDate(Date actionDate) {
		this.actionDate = actionDate;
	}
	public int getAction() {
		return action;
	}
	public void setAction(int action) {
		this.action = action;
	}
	public String getOvrdType() {
		return ovrdType;
	}
	public void setOvrdType(String ovrdType) {
		this.ovrdType = ovrdType;
	}
	public String getOvrdKey() {
		return ovrdKey;
	}
	public void setOvrdKey(String ovrdKey) {
		this.ovrdKey = ovrdKey;
	}
	
	@Override
	public boolean equals(Object obj)
	{
	    return EqualsBuilder.reflectionEquals(this, obj);
	}
	
}
