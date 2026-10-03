package net.ibizsys.model.control.calendar;

import net.ibizsys.model.core.IPSModelObject;



/**
 * 系统日历部件项关联视图对象接口
 * @author Administrator
 *
 */
public interface IPSSysCalendarItemRV extends IPSModelObject
{


	
	/**
	 * 获取应用视图标识
	 * @return
	 */
	String getPSDEViewBaseId();
	
	/**
	 * 获取树节点
	 * @return
	 */
	IPSSysCalendarItem getPSSysCalendarItem();
	

	/**
	 * 获取视图参数
	 * @return
	 */
	String getViewParam();
}
