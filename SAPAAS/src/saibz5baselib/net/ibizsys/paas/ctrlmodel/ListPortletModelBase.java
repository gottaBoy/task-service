package net.ibizsys.paas.ctrlmodel;

/**
 * 列表门户部件模型
 * 
 * @author lionlau
 *
 */
public abstract class ListPortletModelBase extends PortletModelBase implements IListPortletModel {
	@Override
	public String getPortletType() {
		return PORTLETTYPE_LIST;
	}

}
