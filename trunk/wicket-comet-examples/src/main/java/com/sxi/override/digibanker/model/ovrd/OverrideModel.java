/**
 * 
 */
package com.sxi.override.digibanker.model.ovrd;

import java.util.Date;

import com.sxi.override.digibanker.model.BaseModel;

/**
 * @author Emmanuel Nollase - emanux
 * created 2009 7 21 - 10:59:26
 */
public class OverrideModel extends BaseModel {

	private String funcCd;
	private String ovrdType;
	private String ovrdKey;
	private String refNo;
	private String reason;
	private Date txnDt;
	private Date deadline;
	private String requestBy;
	private byte[] hdrMdl;
	private byte[] dtlMdl;
	private int status; // 0 - open, 1 - close
	private boolean del;
	
	public String getFuncCd() {
		return funcCd;
	}
	public void setFuncCd(String funcCd) {
		this.funcCd = funcCd;
	}
	public String getOvrdKey() {
		return ovrdKey;
	}
	public void setOvrdKey(String ovrdKey) {
		this.ovrdKey = ovrdKey;
	}
	
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Date getTxnDt() {
		return txnDt;
	}
	public void setTxnDt(Date txnDt) {
		this.txnDt = txnDt;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public String getRequestBy() {
		return requestBy;
	}
	public void setRequestBy(String requestBy) {
		this.requestBy = requestBy;
	}
	public byte[] getHdrMdl() {
		return hdrMdl;
	}
	public void setHdrMdl(byte[] hdrMdl) {
		this.hdrMdl = hdrMdl;
	}
	public byte[] getDtlMdl() {
		return dtlMdl;
	}
	public void setDtlMdl(byte[] dtlMdl) {
		this.dtlMdl = dtlMdl;
	}
	public boolean isDel() {
		return del;
	}
	public void setDel(boolean del) {
		this.del = del;
	}
	public String getOvrdType()
	{
	    return ovrdType;
	}
	public void setOvrdType(String ovrdType)
	{
	    this.ovrdType = ovrdType;
	}
	public int getStatus()
	{
	    return status;
	}
	public void setStatus(int status)
	{
	    this.status = status;
	}
	public String getRefNo()
	{
	    return refNo;
	}
	public void setRefNo(String refNo)
	{
	    this.refNo = refNo;
	}
	
}
