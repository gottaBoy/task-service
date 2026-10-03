package net.ibizsys.model.control.dashboard;

import net.ibizsys.model.res.IPSSysPortlet;


/**
 * 数据看板系统门户部件面板
 * @author Administrator
 *
 */
public interface IPSDBSysPortletPart extends IPSDBPortletPart{
	
	/**
	 * 获取系统门户部件
	 * @return
	 */
	IPSSysPortlet getPSSysPortlet();
	
	
	/**
	 * 获取计时器
	 * @return
	 */
	long getTimer();
}
