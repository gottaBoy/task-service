package net.ibizsys.paas.ctrlmodel;

/**
 * 表单门户部件模型
 * 
 * @author lionlau
 *
 */
public abstract class EditFormPortletModelBase extends PortletModelBase implements IEditFormPortletModel {
	@Override
	public String getPortletType() {
		return PORTLETTYPE_FORM;
	}

}
