/**
 * 
 */
package com.sxi.override.digibanker.model;

import com.sxi.cometd.model.IOverridable;

/**
 * @author Emmanuel Nollase - emanux
 * created 2009 7 21 - 10:51:34
 */
public class BaseModel implements IOverridable {

	private String id;
	private int version;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	
	
}
