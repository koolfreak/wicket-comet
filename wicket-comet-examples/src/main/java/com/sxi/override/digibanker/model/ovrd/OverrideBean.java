/**
 * 
 */
package com.sxi.override.digibanker.model.ovrd;

import com.sxi.cometd.model.IOverridable;

/**
 * @author Emmanuel Nollase - emanux
 * created 2009 7 21 - 12:45:13
 */
public class OverrideBean implements IOverridable {

	private String supervisor;
	private String password;
	private String localOverride;
	private String queuedOverride;
	private String remoteOverride;
	private String overrideType;
	
	public String getOverrideType() {
		return overrideType;
	}
	public void setOverrideType(String overrideType) {
		this.overrideType = overrideType;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}
	public String getLocalOverride() {
		return localOverride;
	}
	public void setLocalOverride(String localOverride) {
		this.localOverride = localOverride;
	}
	public String getQueuedOverride() {
		return queuedOverride;
	}
	public void setQueuedOverride(String queuedOverride) {
		this.queuedOverride = queuedOverride;
	}
	public String getRemoteOverride() {
		return remoteOverride;
	}
	public void setRemoteOverride(String remoteOverride) {
		this.remoteOverride = remoteOverride;
	}
}
