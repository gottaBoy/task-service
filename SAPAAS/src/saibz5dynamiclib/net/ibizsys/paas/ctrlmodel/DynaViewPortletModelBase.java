package net.ibizsys.paas.ctrlmodel;

/**
 * 动态视图门户部件模型
 * 
 * @author lionlau
 *
 */
public abstract class DynaViewPortletModelBase extends DynaPortletModelBase {
	@Override
	public String getPortletType() {
		return PORTLETTYPE_VIEW;
	}
}
