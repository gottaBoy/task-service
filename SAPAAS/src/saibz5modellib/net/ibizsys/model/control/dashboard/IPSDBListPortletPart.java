package net.ibizsys.model.control.dashboard;

import net.ibizsys.model.control.list.IPSList;

/**
 * 列表部件
 * @author lionlau
 *
 */
public interface IPSDBListPortletPart extends IPSDBSysPortletPart
{
	/**
	 * 获取图形部件
	 * @return
	 */
	IPSList getPSList();
}
