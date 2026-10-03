package net.ibizsys.model.control.dashboard;

import net.ibizsys.model.app.view.IPSAppView;


/**
 * 界面视图部件
 * @author lionlau
 *
 */
public interface IPSDBViewPortletPart extends IPSDBSysPortletPart
{

	/**
	 * 获取部件的应用视图
	 * @return
	 */
	IPSAppView getPortletPSAppView();
}
