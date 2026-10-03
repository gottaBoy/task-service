package net.ibizsys.model.control.titlebar;

import net.ibizsys.model.control.menu.IPSAppMenu;

/**
 * 应用标题栏对象接口
 * @author Administrator
 *
 */
public interface IPSAppTitleBar extends IPSTitleBar {

	/**
	 * 获取左侧应用菜单部件
	 * @return
	 */
	IPSAppMenu getLeftPSAppMenu();
	
	
	/**
	 * 获取右侧应用菜单部件
	 * @return
	 */
	IPSAppMenu getRightPSAppMenu();
}
