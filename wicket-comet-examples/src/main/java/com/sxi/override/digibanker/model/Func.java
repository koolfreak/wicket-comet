/**
 * 
 */
package com.sxi.override.digibanker.model;

/**
 * @author Emmanuel Nollase - emanux
 * created 2009 7 21 - 10:55:27
 */
public class Func extends BaseModel {

	private String funcCode;
	private String funcDesc;
	private int reqOvrdCnt;
	private int overridableType;
	
	
	public String getFuncCode() {
		return funcCode;
	}
	public void setFuncCode(String funcCode) {
		this.funcCode = funcCode;
	}
	public String getFuncDesc() {
		return funcDesc;
	}
	public void setFuncDesc(String funcDesc) {
		this.funcDesc = funcDesc;
	}
	public int getReqOvrdCnt() {
		return reqOvrdCnt;
	}
	public void setReqOvrdCnt(int reqOvrdCnt) {
		this.reqOvrdCnt = reqOvrdCnt;
	}
	public int getOverridableType() {
		return overridableType;
	}
	public void setOverridableType(int overridableType) {
		this.overridableType = overridableType;
	}
	
	
}
