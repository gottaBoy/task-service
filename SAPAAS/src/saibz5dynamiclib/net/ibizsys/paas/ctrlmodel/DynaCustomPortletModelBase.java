package net.ibizsys.paas.ctrlmodel;

/**
 * 动态自定义门户部件模型
 * 
 * @author lionlau
 *
 */
public abstract class DynaCustomPortletModelBase extends DynaPortletModelBase {
	
	@Override
	public String getPortletType() {
		return PORTLETTYPE_CUSTOM;
	}
}
