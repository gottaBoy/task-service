package net.ibizsys.ssdyna.demodel;

/**
 * Dynamic entity workflow metadata not exposed by the legacy DEWF base.
 */
public abstract class DynaDEWFModelBase extends net.ibizsys.pswf.core.DEWFModelBase {
	private int wfProxyMode;
	private String proxyDataField;
	private String proxyModuleField;

	public int getWFProxyMode() {
		return wfProxyMode;
	}

	protected void setWFProxyMode(int wfProxyMode) {
		this.wfProxyMode = wfProxyMode;
	}

	public String getProxyDataField() {
		return proxyDataField;
	}

	protected void setProxyDataField(String proxyDataField) {
		this.proxyDataField = proxyDataField;
	}

	public String getProxyModuleField() {
		return proxyModuleField;
	}

	protected void setProxyModuleField(String proxyModuleField) {
		this.proxyModuleField = proxyModuleField;
	}
}
