package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.control.ControlTypes;

/**
 * 门户部件模型
 * 
 * @author lionlau
 *
 */
public abstract class PortletModelBase extends ContainerModelBase implements IPortletModel {
	private String strTitle = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.dashboard.IPortlet#getTitle()
	 */
	@Override
	public String getTitle() {
		return this.strTitle;
	}

	/**
	 * 设置标题
	 * 
	 * @param strTitle
	 */
	protected void setTitle(String strTitle) {
		this.strTitle = strTitle;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.IControl#getControlType()
	 */
	@Override
	public String getControlType() {
		return ControlTypes.Portlet;
	}

}
