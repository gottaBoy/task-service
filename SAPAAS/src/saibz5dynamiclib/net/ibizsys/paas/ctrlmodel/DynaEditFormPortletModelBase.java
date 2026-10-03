package net.ibizsys.paas.ctrlmodel;

/**
 * 动态表单门户部件模型
 * 
 * @author lionlau
 *
 */
public abstract class DynaEditFormPortletModelBase extends DynaPortletModelBase implements IEditFormPortletModel {
	
	@Override
	public String getPortletType() {
		return PORTLETTYPE_FORM;
	}

}
