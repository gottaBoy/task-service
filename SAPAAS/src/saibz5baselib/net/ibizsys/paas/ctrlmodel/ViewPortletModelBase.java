package net.ibizsys.paas.ctrlmodel;

/**
 * 视图门户部件模型
 * 
 * @author lionlau
 *
 */
public abstract class ViewPortletModelBase extends PortletModelBase {
	@Override
	public String getPortletType() {
		return PORTLETTYPE_VIEW;
	}
}
