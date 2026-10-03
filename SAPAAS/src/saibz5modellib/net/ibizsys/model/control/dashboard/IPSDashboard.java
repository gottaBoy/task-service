package net.ibizsys.model.control.dashboard;

import net.ibizsys.model.control.IPSAjaxControl;
import net.ibizsys.model.control.IPSControlContainer;
import net.ibizsys.paas.control.dashboard.IDashboard;

/**
 * 数据看板部件对象接口
 * @author lionlau
 *
 */
public interface IPSDashboard extends IPSAjaxControl,IPSControlContainer,IDashboard
{
	/**
	 * 获取部件
	 * @return
	 */
	java.util.Iterator<IPSDBPortletPart> getPSPortlets();
	
	
	
	/**
	 * 注册部件
	 * @param iPSPortlet
	 * @throws Exception
	 */
	void registerPSPortlet(IPSDBPortletPart iPSPortlet)throws Exception;
}
