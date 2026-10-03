package net.ibizsys.paas.ctrlmodel;

/**
 * 动态列表门户部件模型
 * 
 * @author lionlau
 *
 */
public abstract class DynaListPortletModelBase extends DynaPortletModelBase implements IListPortletModel {
	@Override
	public String getPortletType() {
		return PORTLETTYPE_LIST;
	}

}
