package net.ibizsys.paas.ctrlmodel;

/**
 * 搜索表单门户部件模型
 * 
 * @author lionlau
 *
 */
public abstract class SearchFormPortletModelBase extends PortletModelBase implements ISearchFormPortletModel {
	@Override
	public String getPortletType() {
		return PORTLETTYPE_SEARCHFORM;
	}

}
