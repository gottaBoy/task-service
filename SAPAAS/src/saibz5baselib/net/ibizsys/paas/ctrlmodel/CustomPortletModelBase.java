package net.ibizsys.paas.ctrlmodel;

/**
 * 自定义门户部件模型
 * 
 * @author lionlau
 *
 */
public abstract class CustomPortletModelBase extends PortletModelBase {
	@Override
	public String getPortletType() {
		return PORTLETTYPE_CUSTOM;
	}
}
