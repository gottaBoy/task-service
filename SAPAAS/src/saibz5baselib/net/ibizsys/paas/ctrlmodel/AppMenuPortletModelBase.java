package net.ibizsys.paas.ctrlmodel;

/**
 * 应用菜单栏门户部件模型
 * 
 * @author lionlau
 *
 */
public abstract class AppMenuPortletModelBase extends PortletModelBase implements IAppMenuPortletModel {
	@Override
	public String getPortletType() {
		return PORTLETTYPE_APPMENU;
	}
}
