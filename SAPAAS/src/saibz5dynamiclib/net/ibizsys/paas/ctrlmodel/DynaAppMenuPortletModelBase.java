package net.ibizsys.paas.ctrlmodel;

/**
 * 动态应用菜单栏门户部件模型
 * 
 * @author lionlau
 *
 */
public abstract class DynaAppMenuPortletModelBase extends DynaPortletModelBase implements IAppMenuPortletModel {
	
	@Override
	public String getPortletType() {
		return PORTLETTYPE_APPMENU;
	}
}
