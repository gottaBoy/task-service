package net.ibizsys.ssdynawf.core;

import net.ibizsys.model.wf.IPSWFVersion;

/**
 * 动态工作流版本模型基类
 * @author Administrator
 *
 */
public abstract class WFVersionModelBase extends net.ibizsys.sswf.core.WFVersionModelBase implements IDynaWFVersionModel{

	private IPSWFVersion iPSWFVersion = null;
	private String startDEViewId;
	private String mobStartDEViewId;
	private String startDEViewUserData;
	private String mobStartDEViewUserData;

	public String getStartDEViewId() {
		return startDEViewId;
	}

	protected void setStartDEViewId(String startDEViewId) {
		this.startDEViewId = startDEViewId;
	}

	public String getMobStartDEViewId() {
		return mobStartDEViewId;
	}

	protected void setMobStartDEViewId(String mobStartDEViewId) {
		this.mobStartDEViewId = mobStartDEViewId;
	}

	public String getStartDEViewUserData() {
		return startDEViewUserData;
	}

	protected void setStartDEViewUserData(String startDEViewUserData) {
		this.startDEViewUserData = startDEViewUserData;
	}

	public String getMobStartDEViewUserData() {
		return mobStartDEViewUserData;
	}

	protected void setMobStartDEViewUserData(String mobStartDEViewUserData) {
		this.mobStartDEViewUserData = mobStartDEViewUserData;
	}
	@Override
	public IDynaWFModel getDynaWFModel() {
		return (IDynaWFModel) this.getWFModel();
	}

	@Override
	public IPSWFVersion getPSWFVersion() {
		return this.iPSWFVersion;
	}
	
	/**
	 * 设置工作流版本模型对象
	 * @param iPSWFVersion
	 */
	protected void setPSWFVersion(IPSWFVersion iPSWFVersion) {
		this.iPSWFVersion = iPSWFVersion;
	}

}
