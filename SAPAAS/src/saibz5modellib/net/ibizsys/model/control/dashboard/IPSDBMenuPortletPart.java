package net.ibizsys.model.control.dashboard;

import net.ibizsys.model.control.menu.IPSAppMenu;

/**
 * 快速菜单部件
 * @author lionlau
 *
 */
public interface IPSDBMenuPortletPart extends IPSDBPortletPart
{
	/**
	 * 获取菜单部件
	 * @return
	 */
	IPSAppMenu getPSAppMenu();
}
