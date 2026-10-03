package net.ibizsys.paas.ctrlmodel;

/**
 * 动态搜索表单门户部件模型
 * 
 * @author lionlau
 *
 */
public abstract class DynaSearchFormPortletModelBase extends DynaPortletModelBase implements ISearchFormPortletModel {
	@Override
	public String getPortletType() {
		return PORTLETTYPE_SEARCHFORM;
	}

}
